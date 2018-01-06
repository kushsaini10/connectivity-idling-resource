Connectivity Idling Resource
============================

An Espresso `IdlingResource` for Internet Connectivity.

There are two modes for this Idling Resource:
1. `WAIT_FOR_CONNECTION` - waits for device to be connected to internet before test moves on to next operation
2. `WAIT_FOR_DISCONNECTION` - waits for device to be disconnected from internet before test moves on to the next operation



Usage
-----

Create an Idling Resource with resourceName, context and mode:
```java
IdlingResource idlingResource = new ConnectivityIdlingResource("resourceName",
                context, ConnectivityIdlingResource.WAIT_FOR_CONNECTION);
```

Register the idling resource with `Espresso` before or while running your tests
```java
Espresso.registerIdlingResources(idlingResource);
```



Download
-------

```groovy
androidTestImplementation 'com.github.kushsaini10:connectivity-idling-resource:1.0.0'
```



License
-------

      Copyright 2017 Kush Saini
   
      Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
      You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.
