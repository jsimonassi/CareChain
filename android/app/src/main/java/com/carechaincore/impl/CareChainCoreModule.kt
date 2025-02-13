package com.carechaincore.impl

import com.carechaincore.NativeCareChainCoreSpec
import com.facebook.react.bridge.ReactApplicationContext

class CareChainCoreModule(reactContext: ReactApplicationContext) : NativeCareChainCoreSpec(reactContext) {

    companion object {
        const val NAME = NativeCareChainCoreSpec.NAME
    }

    override fun startScanDevices() {
        TODO("Not yet implemented")
    }

    override fun pairDevice(deviceMac: String?) {
        TODO("Not yet implemented")
    }

    override fun disconnectDevice(deviceMac: String?) {
        TODO("Not yet implemented")
    }

    override fun syncAllData() {
        TODO("Not yet implemented")
    }

}