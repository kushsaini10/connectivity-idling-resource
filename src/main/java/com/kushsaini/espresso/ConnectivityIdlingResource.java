package com.kushsaini.espresso;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.espresso.IdlingResource;
import android.util.Log;

/**
 * Created by Kush Saini on 12-12-2017
 * Last Modified by Kush Saini on 05-01-2018
 * Description:
 *  This {@link IdlingResource} halts Espresso Test depending on mode which is passed to the constructor
 */

public final class ConnectivityIdlingResource implements IdlingResource {
    public static int WAIT_FOR_CONNECTION = 1;
    public static int WAIT_FOR_DISCONNECTION = 0;
    private static final String TAG = "ConnectIdlingResource";
    private final String resourceName;
    private final Context mContext;
    private final int mode;

    private volatile ResourceCallback resourceCallback;

    /**
     *
     * @param resourceName              name of the resource (used for logging and idempotency of registration
     * @param context                   context
     * @param mode                      if mode is WAIT_FOR_CONNECTION i.e. value is 1 then the {@link IdlingResource}
     *                                  halts test until internet is available and if mode is WAIT_FOR_DISCONNECTION
     *                                  i.e. value is 0 then {@link IdlingResource} waits for internet to disconnect
     */
    public ConnectivityIdlingResource(String resourceName, Context context, int mode) {
        this.resourceName = resourceName;
        this.mContext = context;
        this.mode = mode;
    }

    @Override
    public String getName() {
        return resourceName;
    }

    @Override
    public boolean isIdleNow() {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = null;
        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }else {
            Log.e(TAG, "Cannot access network information");
        }
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (mode == WAIT_FOR_DISCONNECTION)
            isConnected = !isConnected;
        if (isConnected) {
            Log.d(TAG, "Connected now!");
            resourceCallback.onTransitionToIdle();
        }else {
            Log.d(TAG, "Not connected!");
        }
        return isConnected;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }
}
