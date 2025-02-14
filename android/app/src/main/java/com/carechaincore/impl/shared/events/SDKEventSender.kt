package com.carechaincore.impl.shared.events

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.modules.core.RCTNativeAppEventEmitter

class SDKEventSender private constructor(private val reactApplicationContext: ReactApplicationContext) {

    companion object {
        @Volatile
        private var instance: SDKEventSender? = null

        fun getInstance(reactApplicationContext: ReactApplicationContext): SDKEventSender {
            return instance ?: synchronized(this) {
                instance ?: SDKEventSender(reactApplicationContext).also { instance = it }
            }
        }

        fun getInstance(): SDKEventSender? {
            return instance
        }
    }

    fun sendEvent(eventName: String?, params: WritableMap?) {
        reactApplicationContext
            .getJSModule(RCTNativeAppEventEmitter::class.java)
            .emit(eventName, params)
    }
}