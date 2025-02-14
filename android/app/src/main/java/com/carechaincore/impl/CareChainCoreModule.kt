package com.carechaincore.impl

import android.app.Application
import com.carechaincore.NativeCareChainCoreSpec
import com.carechaincore.impl.ido.config.SDKConfig
import com.carechaincore.impl.ido.connection.PairDeviceManager
import com.carechaincore.impl.shared.events.SDKEventSender
import com.carechaincore.impl.ido.connection.ScanManager
import com.carechaincore.impl.ido.syncdata.SyncDataManager
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext

class CareChainCoreModule(reactContext: ReactApplicationContext) : NativeCareChainCoreSpec(reactContext) {

    companion object {
        const val NAME = NativeCareChainCoreSpec.NAME
    }

    override fun initSdk(promise: Promise) {
        val application = reactApplicationContext.applicationContext as Application
        SDKConfig.setContext(application)
        SDKConfig.initBLEManager()
        SDKEventSender.getInstance(reactApplicationContext)
        promise.resolve(true)
    }

    override fun startScanDevices() {
        ScanManager.getInstance(reactApplicationContext).startBtScan()
    }

    override fun pairDevice(deviceMac: String) {
        PairDeviceManager.getInstance().pairDevice(deviceMac)
    }

    override fun disconnectDevice() {
        PairDeviceManager.getInstance().disconnectDevice()
    }

    override fun syncAllData() {
        SyncDataManager().requestSyncData()
    }
}
