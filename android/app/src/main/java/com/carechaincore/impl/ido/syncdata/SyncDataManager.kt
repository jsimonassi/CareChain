package com.carechaincore.impl.ido.syncdata

import com.carechaincore.impl.shared.events.AvailableEvents
import com.carechaincore.impl.shared.events.SDKEventSender
import com.facebook.react.bridge.Arguments
import com.ido.ble.BLEManager
import com.ido.ble.business.sync.SyncPara
import com.ido.ble.callback.SyncCallBack
import com.ido.ble.callback.SyncV3CallBack
import com.ido.ble.data.manage.database.HealthActivityV3
import com.ido.ble.data.manage.database.HealthBloodPressed
import com.ido.ble.data.manage.database.HealthBloodPressedItem
import com.ido.ble.data.manage.database.HealthBloodPressureV3
import com.ido.ble.data.manage.database.HealthBodyComposition
import com.ido.ble.data.manage.database.HealthBodyPower
import com.ido.ble.data.manage.database.HealthGpsV3
import com.ido.ble.data.manage.database.HealthHRVdata
import com.ido.ble.data.manage.database.HealthHeartRate
import com.ido.ble.data.manage.database.HealthHeartRateItem
import com.ido.ble.data.manage.database.HealthHeartRateSecond
import com.ido.ble.data.manage.database.HealthNoise
import com.ido.ble.data.manage.database.HealthPressure
import com.ido.ble.data.manage.database.HealthPressureItem
import com.ido.ble.data.manage.database.HealthRespiratoryRate
import com.ido.ble.data.manage.database.HealthSleep
import com.ido.ble.data.manage.database.HealthSleepItem
import com.ido.ble.data.manage.database.HealthSleepV3
import com.ido.ble.data.manage.database.HealthSpO2
import com.ido.ble.data.manage.database.HealthSpO2Item
import com.ido.ble.data.manage.database.HealthSport
import com.ido.ble.data.manage.database.HealthSportItem
import com.ido.ble.data.manage.database.HealthSportV3
import com.ido.ble.data.manage.database.HealthSwimming
import com.ido.ble.data.manage.database.HealthTemperature
import com.ido.ble.data.manage.database.HealthV3Ecg
import com.ido.ble.protocol.model.DrinkPlanData

class SyncDataManager {

    companion object {
        const val SYNC_STATUS_IN_PROGRESS = 0
        const val SYNC_STATUS_FINISHED = 1
    }

    fun requestSyncData() {
        configureCallbacks()

        val syncPara = SyncPara()
        syncPara.isNeedSyncConfigData = false
        BLEManager.syncAllData(syncPara)
    }

    private fun configureCallbacks() {
        BLEManager.unregisterSyncHealthCallBack(syncHealthCallback)
        BLEManager.unregisterSyncV3CallBack(syncV3DataCallback)

        BLEManager.registerSyncHealthCallBack(syncHealthCallback)
        BLEManager.registerSyncV3CallBack(syncV3DataCallback)
    }

    private fun sendSyncEvent(status: Int, progress: Int) {
        val ret = Arguments.createMap()
        ret.putInt("status", status)
        ret.putInt("progress", progress)
        SDKEventSender.getInstance()?.sendEvent(AvailableEvents.EVENT_SYNC_STATUS, ret)
    }


    private val syncHealthCallback = object : SyncCallBack.IHealthCallBack {
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


        //Get Data Callback

        override fun onGetSportData(
            p0: HealthSport?,
            p1: MutableList<HealthSportItem>?,
            p2: Boolean
        ) {
            
        }

        override fun onGetSleepData(p0: HealthSleep?, p1: MutableList<HealthSleepItem>?) {
            
        }

        override fun onGetHeartRateData(
            p0: HealthHeartRate?,
            p1: MutableList<HealthHeartRateItem>?,
            p2: Boolean
        ) {
            
        }

        override fun onGetBloodPressureData(
            p0: HealthBloodPressed?,
            p1: MutableList<HealthBloodPressedItem>?,
            p2: Boolean
        ) {
            
        }
    }


    private val syncV3DataCallback = object : SyncV3CallBack.ICallBack {
        override fun onStart() {
            
        }

        override fun onProgress(p0: Int) {
            
        }

        override fun onStop() {
            
        }

        override fun onSuccess() {
            
        }

        override fun onFailed() {
            
        }

        override fun onGetHealthSpO2Data(
            p0: HealthSpO2?,
            p1: MutableList<HealthSpO2Item>?,
            p2: Boolean
        ) {
            
        }

        override fun onGetHealthPressureData(
            p0: HealthPressure?,
            p1: MutableList<HealthPressureItem>?,
            p2: Boolean
        ) {
            
        }

        override fun onGetHealthHeartRateSecondData(p0: HealthHeartRateSecond?, p1: Boolean) {
            
        }

        override fun onGetHealthSwimmingData(p0: HealthSwimming?) {
            
        }

        override fun onGetHealthActivityV3Data(p0: HealthActivityV3?) {
            
        }

        override fun onGetHealthSportV3Data(p0: HealthSportV3?) {
            
        }

        override fun onGetHealthSleepV3Data(p0: HealthSleepV3?) {
            
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