package com.carechaincore.impl.ido.connection

import android.content.Context
import com.carechaincore.impl.shared.events.AvailableEvents
import com.carechaincore.impl.shared.events.SDKEventSender
import com.carechaincore.impl.shared.helpers.PermissionHelper
import com.facebook.react.bridge.Arguments
import com.ido.ble.BLEManager
import com.ido.ble.bluetooth.device.BLEDevice
import com.ido.ble.callback.ScanCallBack
import java.lang.ref.WeakReference

class ScanManager private constructor(context: Context) : ScanCallBack.ICallBack {

    private val contextRef = WeakReference(context.applicationContext)

    companion object {
        @Volatile
        private var instance: ScanManager? = null

        fun getInstance(context: Context): ScanManager {
            return instance ?: synchronized(this) {
                instance ?: ScanManager(context).also { instance = it }
            }
        }
    }

    fun startBtScan() {
        val context = contextRef.get() ?: run {
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SCAN_ERROR, null)
            return
        }

        if (PermissionHelper.hasLocationPermission(context) &&
            PermissionHelper.hasBluetoothPermission(context)) {

            BLEManager.unregisterScanCallBack(this)
            BLEManager.registerScanCallBack(this)
            BLEManager.stopScanDevices()
            BLEManager.startScanDevices()
        } else {
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SCAN_ERROR, null)
        }
    }

    override fun onStart() {
        SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SCAN_STARTED, null)
    }

    override fun onFindDevice(device: BLEDevice?) {
        val deviceName = device?.mDeviceName
        val mac = device?.mDeviceAddress
        if (deviceName != null && mac != null) {
            val response = Arguments.createMap().apply {
                putString("name", deviceName)
                putString("mac", mac)
            }
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_DEVICE_FOUND, response)
        }
    }

    override fun onScanFinished() {
        SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SCAN_FINISHED, null)
    }
}
