package com.carechaincore.impl.ido.syncdata

import com.carechaincore.impl.shared.helpers.DateHelpers
import com.carechaincore.impl.shared.storage.models.entities.heartRate.HeartRateHistory
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableMap
import com.ido.ble.data.manage.database.HealthHeartRateSecond

object HeartRateMapper {

    fun convertSdkObj2DataStorageObj(sdkHeartRate: HealthHeartRateSecond): List<HeartRateHistory>? {
        if (sdkHeartRate.items.isEmpty()) return null

        val dbList: MutableList<HeartRateHistory> = ArrayList()
        var currentDate: Long = sdkHeartRate.date.time + sdkHeartRate.startTime * 1000L

        for (item in sdkHeartRate.items) {
            currentDate += item.offset * 1000L
            if (item.heartRateVal > 0) {
                val dbItem = HeartRateHistory()
                dbItem.value = item.heartRateVal
                dbItem.date = DateHelpers.formatEpochToISO(currentDate)
                dbList.add(dbItem)
            }
        }

        return dbList
    }

    fun convertDataStorageObj2JSObj(dbHeartRate: List<HeartRateHistory>): WritableArray {
        val jsList: WritableArray = Arguments.createArray()
        for (item in dbHeartRate) {
            val jsItem: WritableMap = Arguments.createMap()
            jsItem.putString("date", item.date)
            jsItem.putInt("value", item.value)
            jsList.pushMap(jsItem)
        }
        return jsList
    }
}