package com.carechaincore.impl.ido.config

import android.app.Application
import com.ido.ble.BLEManager
import com.ido.ble.InitParam

object SDKConfig {

    fun setContext(application: Application) {
        BLEManager.onApplicationCreate(application)
    }

    fun initBLEManager() {
        val initParam = InitParam()
        initParam.isEnableLog = true
        initParam.log_save_days = 7
        initParam.isSaveDeviceDataToDB = true
        initParam.isNeedSoLibAutoSyncConfigIfReboot = false
        initParam.isEncryptedSPData = false
        BLEManager.init(initParam)
    }
}