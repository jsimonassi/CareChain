package com.carechaincore.impl

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider


class CareChainCorePackage : TurboReactPackage() {
    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? =
        if (name == CareChainCoreModule.NAME) {
            CareChainCoreModule(reactContext)
        } else {
            null
        }

    override fun getReactModuleInfoProvider() = ReactModuleInfoProvider {
        mapOf(
            CareChainCoreModule.NAME to ReactModuleInfo(
                CareChainCoreModule.NAME,
                CareChainCoreModule.NAME,
                false,
                false,
                false,
                false,
                true
            )
        )
    }

}