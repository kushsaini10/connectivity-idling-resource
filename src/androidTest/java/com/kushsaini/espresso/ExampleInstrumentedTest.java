package com.kushsaini.espresso;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        IdlingResource connectivityIdlingResource = new ConnectivityIdlingResource("Wifi", appContext, ConnectivityIdlingResource.WAIT_FOR_CONNECTION);
        assertEquals("com.kushsaini.espresso.test", appContext.getPackageName());
    }
}
