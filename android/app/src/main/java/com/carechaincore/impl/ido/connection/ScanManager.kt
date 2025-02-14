package com.carechaincore.impl.ido.connection

import android.content.Context
import com.carechaincore.impl.shared.events.AvailableEvents
import com.carechaincore.impl.shared.events.SDKEventSender
import com.carechaincore.impl.shared.helpers.PermissionHelper
import com.facebook.react.bridge.Arguments
import com.ido.ble.BLEManager
import com.ido.ble.bluetooth.device.BLEDevice
import com.ido.ble.callback.ScanCallBack

class ScanManager(private val context: Context) : ScanCallBack.ICallBack {

    fun startBtScan() {
        if(PermissionHelper.hasLocationPermission(context) &&
            PermissionHelper.hasBluetoothPermission(context)){
            BLEManager.registerScanCallBack(this)

            BLEManager.stopScanDevices()
            BLEManager.startScanDevices()
        }
    }

    override fun onStart() {
        SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SCAN_STARTED, null)
    }

    override fun onFindDevice(device: BLEDevice?) {
        val deviceName = device?.mDeviceName
        val mac = device?.mDeviceAddress
        if(deviceName != null && mac != null){
            val response = Arguments.createMap()
            response.putString("name", deviceName)
            response.putString("mac", mac)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_DEVICE_FOUND, response)
        }
    }

    override fun onScanFinished() {
        SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SCAN_FINISHED, null)
    }

}