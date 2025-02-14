package com.carechaincore.impl.ido.connection

import android.content.Context
import android.os.Handler
import android.util.Log
import com.facebook.react.bridge.Arguments
import com.ido.ble.BLEManager
import com.ido.ble.bluetooth.connect.ConnectFailedReason
import com.ido.ble.bluetooth.device.BLEDevice
import com.ido.ble.callback.ConnectCallBack
import java.lang.ref.WeakReference

class PairDeviceManager private constructor(context: Context) : ConnectCallBack.ICallBack {

    private val contextRef = WeakReference(context.applicationContext)

    companion object {
        @Volatile
        private var instance: PairDeviceManager? = null

        fun getInstance(context: Context): PairDeviceManager {
            return instance ?: synchronized(this) {
                instance ?: PairDeviceManager(context).also { instance = it }
            }
        }
    }

    fun pairDevice(deviceMac: String) {
        BLEManager.setIsNeedRemoveBondBeforeConnect(false)
        BLEManager.unregisterConnectCallBack(this)
        BLEManager.registerConnectCallBack(this)

        val device = BLEDevice()
        device.mDeviceAddress = deviceMac
        device.mDeviceName = ""
        BLEManager.connect(device)
    }


        override fun onConnectStart(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onConnecting(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRetry(p0: Int, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onConnectSuccess(mac: String) {
        if (BLEManager.isBind()) {
            if (!BLEManager.isConnected()) {
                BLEManager.autoConnect()
            } else {
                val ret = Arguments.createMap()
//                ret.putInt("state", SDKService.STATE_CONNECTED)
//                if (lastStatePair != SDKService.STATE_CONNECTED) {
//                    IDOEventManager.sendIdoEvent(SDKService.EVENT_CONNECT_STATE_CHANGED, ret)
//                    lastStatePair = SDKService.STATE_CONNECTED
//                    IDOService.getInstance().coreModule.mainService.updateNotification(SDKService.STATE_CONNECTED)
//                    intervalNotification.checkIfDisconnected(false)
//                }
//
//                if (IDOService.getInstance().firmwareSequentialManager != null) {
//                    Handler().postDelayed({
//                        IDOService.getInstance().firmwareSequentialManager.continueUpdateFirmware()
//                    }, 6000)
//                }
            }
        } else {
            BLEManager.bind()
        }
    }

    override fun onConnectFailed(p0: ConnectFailedReason?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onConnectBreak(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onInDfuMode(p0: BLEDevice?) {
        TODO("Not yet implemented")
    }

    override fun onDeviceInNotBindStatus(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onInitCompleted(p0: String?) {
        TODO("Not yet implemented")
    }

}