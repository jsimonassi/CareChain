package com.carechaincore.impl.ido.connection

import com.carechaincore.impl.shared.events.AvailableEvents
import com.carechaincore.impl.shared.events.SDKEventSender
import com.facebook.react.bridge.Arguments
import com.ido.ble.BLEManager
import com.ido.ble.bluetooth.connect.ConnectFailedReason
import com.ido.ble.bluetooth.device.BLEDevice
import com.ido.ble.callback.BindCallBack
import com.ido.ble.callback.ConnectCallBack

class PairDeviceManager private constructor() {

    companion object {

        const val PAIR_STATE_CONNECTED = 1
        const val PAIR_STATE_DISCONNECTED = 2
        const val PAIR_STATE_CONNECTING = 3

        @Volatile
        private var instance: PairDeviceManager? = null

        fun getInstance(): PairDeviceManager {
            return instance ?: synchronized(this) {
                instance ?: PairDeviceManager().also { instance = it }
            }
        }
    }

    fun pairDevice(deviceMac: String) {
        BLEManager.setIsNeedRemoveBondBeforeConnect(false)

        BLEManager.unregisterConnectCallBack(connectionCallBack)
        BLEManager.registerConnectCallBack(connectionCallBack)

        BLEManager.unregisterBindCallBack(bindCallBack)
        BLEManager.registerBindCallBack(bindCallBack)

        val device = BLEDevice()
        device.mDeviceAddress = deviceMac
        device.mDeviceName = ""
        BLEManager.connect(device)
    }

    fun disconnectDevice() {
        BLEManager.unbind()
    }


    private val connectionCallBack: ConnectCallBack.ICallBack = object : ConnectCallBack.ICallBack {
        override fun onConnectStart(mac: String?) {}

        override fun onConnecting(p0: String?) {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_CONNECTING)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }

        override fun onRetry(p0: Int, p1: String?) {}

        override fun onConnectSuccess(mac: String) {
            if (BLEManager.isBind()) {
                if (!BLEManager.isConnected()) {
                    BLEManager.autoConnect()
                } else {
                    val ret = Arguments.createMap()
                    ret.putInt("state", PAIR_STATE_CONNECTED)
                    SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
                }
            } else {
                BLEManager.bind()
            }
        }

        override fun onConnectFailed(p0: ConnectFailedReason?, p1: String?) {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_DISCONNECTED)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }

        override fun onConnectBreak(mac: String?) {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_DISCONNECTED)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }

        override fun onInDfuMode(mac: BLEDevice?) {}

        override fun onDeviceInNotBindStatus(mac: String?) {
            BLEManager.bind()
        }

        override fun onInitCompleted(mac: String?) {}
    }


    private val bindCallBack: BindCallBack.ICallBack = object : BindCallBack.ICallBack {
        override fun onSuccess() {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_CONNECTED)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }

        override fun onFailed(p0: BindCallBack.BindFailedError?) {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_DISCONNECTED)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }

        override fun onCancel() {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_DISCONNECTED)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }

        override fun onReject() {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_DISCONNECTED)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }

        override fun onNeedAuth(p0: Int) {
            val ret = Arguments.createMap()
            ret.putInt("state", PAIR_STATE_DISCONNECTED)
            SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_PAIR_STATE, ret)
        }
    }

}