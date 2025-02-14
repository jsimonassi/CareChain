package com.carechaincore.impl

import android.app.Application
import com.carechaincore.NativeCareChainCoreSpec
import com.carechaincore.impl.ido.config.SDKConfig
import com.carechaincore.impl.shared.events.SDKEventSender
import com.carechaincore.impl.ido.connection.ScanManager
import com.facebook.react.bridge.ReactApplicationContext

class CareChainCoreModule(reactContext: ReactApplicationContext) : NativeCareChainCoreSpec(reactContext) {

    companion object {
        const val NAME = NativeCareChainCoreSpec.NAME
    }

    override fun initSdk() {
        val application = reactApplicationContext.applicationContext as Application
        SDKConfig.setContext(application)
        SDKConfig.initBLEManager()
        SDKEventSender.getInstance(reactApplicationContext)
    }

    override fun startScanDevices() {
        ScanManager(reactApplicationContext).startBtScan()
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
