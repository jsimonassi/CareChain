package com.carechaincore.impl.ido.syncdata

import com.carechaincore.impl.shared.events.AvailableEvents
import com.carechaincore.impl.shared.events.SDKEventSender
import com.carechaincore.impl.shared.storage.DAOs.pedometer.PedometerHistoryDAO
import com.carechaincore.impl.shared.storage.repositories.heartRate.HeartRateHistoryRepository
import com.carechaincore.impl.shared.storage.repositories.pedometer.PedometerHistoryRepository
import com.carechaincore.impl.shared.storage.repositories.sleep.SleepHistoryRepository
import com.carechaincore.impl.shared.storage.repositories.stress.StressHistoryRepository
import com.facebook.react.bridge.Arguments
import com.ido.ble.BLEManager
import com.ido.ble.business.sync.SyncPara
import com.ido.ble.callback.SyncV3CallBack
import com.ido.ble.data.manage.database.HealthActivityV3
import com.ido.ble.data.manage.database.HealthBloodPressureV3
import com.ido.ble.data.manage.database.HealthBodyComposition
import com.ido.ble.data.manage.database.HealthBodyPower
import com.ido.ble.data.manage.database.HealthGpsV3
import com.ido.ble.data.manage.database.HealthHRVdata
import com.ido.ble.data.manage.database.HealthHeartRateSecond
import com.ido.ble.data.manage.database.HealthNoise
import com.ido.ble.data.manage.database.HealthPressure
import com.ido.ble.data.manage.database.HealthPressureItem
import com.ido.ble.data.manage.database.HealthRespiratoryRate
import com.ido.ble.data.manage.database.HealthSleepV3
import com.ido.ble.data.manage.database.HealthSpO2
import com.ido.ble.data.manage.database.HealthSpO2Item
import com.ido.ble.data.manage.database.HealthSportV3
import com.ido.ble.data.manage.database.HealthSwimming
import com.ido.ble.data.manage.database.HealthTemperature
import com.ido.ble.data.manage.database.HealthV3Ecg
import com.ido.ble.protocol.model.DrinkPlanData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SyncDataManager {

    companion object {
        const val SYNC_STATUS_IN_PROGRESS = 0
        const val SYNC_STATUS_FINISHED = 1

        @Volatile
        private var instance: SyncDataManager? = null

        fun getInstance(): SyncDataManager {
            return instance ?: synchronized(this) {
                instance ?: SyncDataManager().also { instance = it }
            }
        }
    }

    fun requestSyncData() {
        configureCallbacks()

        val syncPara = SyncPara()
        syncPara.isNeedSyncConfigData = false
        BLEManager.syncAllData(syncPara)
    }

    private fun configureCallbacks() {
        BLEManager.unregisterSyncV3CallBack(syncV3DataCallback)
        BLEManager.registerSyncV3CallBack(syncV3DataCallback)
    }

    private fun sendSyncEvent(status: Int, progress: Int) {
        val ret = Arguments.createMap()
        ret.putInt("status", status)
        ret.putInt("progress", progress)
        SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SYNC_STATUS, ret)
    }


    private val syncV3DataCallback = object : SyncV3CallBack.ICallBack {
        override fun onStart() {
            sendSyncEvent(SYNC_STATUS_IN_PROGRESS, 0)
        }

        override fun onProgress(progress: Int) {
            if(progress % 5 == 0){
                sendSyncEvent(SYNC_STATUS_IN_PROGRESS, progress)
            }
        }

        override fun onStop() {
            sendSyncEvent(SYNC_STATUS_FINISHED, 100)
        }

        override fun onSuccess() {
            sendSyncEvent(SYNC_STATUS_FINISHED, 100)
        }

        override fun onFailed() {
            sendSyncEvent(SYNC_STATUS_FINISHED, 100)
        }

        override fun onGetHealthSpO2Data(
            p0: HealthSpO2?,
            p1: MutableList<HealthSpO2Item>?,
            p2: Boolean
        ) {
            
        }

        override fun onGetHealthPressureData(
            healthPressure: HealthPressure,
            healthPressureItemList: MutableList<HealthPressureItem>,
            p2: Boolean
        ) {
            val parsedData = StressMapper.convertSdkObj2DataStorageObj(healthPressureItemList)
            if (!parsedData.isNullOrEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    StressHistoryRepository.insert(*parsedData.toTypedArray())
                }
            }
        }

        override fun onGetHealthHeartRateSecondData(sdkHr: HealthHeartRateSecond, p1: Boolean) {
            val parsedData = HeartRateMapper.convertSdkObj2DataStorageObj(sdkHr)
            if (!parsedData.isNullOrEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    HeartRateHistoryRepository.insert(*parsedData.toTypedArray())
                }
            }
        }

        override fun onGetHealthSwimmingData(p0: HealthSwimming?) {}

        override fun onGetHealthActivityV3Data(p0: HealthActivityV3?) {
            
        }

        override fun onGetHealthSportV3Data(sdkPedometer: HealthSportV3) {
            val parsedData = PedometerMapper.convertSdkObj2DataStorageObj(sdkPedometer)
            if (parsedData != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    PedometerHistoryRepository.insert(parsedData)
                }
            }
        }

        override fun onGetHealthSleepV3Data(sdkSleep: HealthSleepV3?) {
            val parsedData = SleepMapper.convertSdkObj2DataStorageObj(sdkSleep)
            if (parsedData != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    SleepHistoryRepository.insert(parsedData)
                }
            }
        }

        override fun onGetHealthGpsV3Data(p0: HealthGpsV3?) {
            
        }

        override fun onGetHealthNoiseData(p0: HealthNoise?) {
            
        }

        override fun onGetHealthTemperature(p0: HealthTemperature?) {
            
        }

        override fun onGetHealthBloodPressure(p0: HealthBloodPressureV3?) {
            
        }

        override fun onGetHealthRespiratoryRate(p0: HealthRespiratoryRate?) {
            
        }

        override fun onGetHealthBodyPower(p0: HealthBodyPower?) {
            
        }

        override fun onGetHealthHRV(p0: HealthHRVdata?) {
            
        }

        override fun onGetDrinkPlan(p0: DrinkPlanData?) {
            
        }

        override fun onGetHealthBodyCompositionData(p0: HealthBodyComposition?) {
            
        }

        override fun onGetHealthV3EcgData(p0: HealthV3Ecg?) {
            
        }
    }
}