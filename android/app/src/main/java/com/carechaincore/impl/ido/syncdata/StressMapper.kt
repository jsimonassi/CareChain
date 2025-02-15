package com.carechaincore.impl.ido.syncdata

import com.carechaincore.impl.shared.helpers.DateHelpers
import com.carechaincore.impl.shared.storage.models.entities.heartRate.HeartRateHistory
import com.carechaincore.impl.shared.storage.models.entities.stress.StressHistory
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableMap
import com.ido.ble.data.manage.database.HealthPressureItem

object StressMapper {

    fun convertSdkObj2DataStorageObj(sdkStressList: List<HealthPressureItem>): List<StressHistory>? {
        if (sdkStressList.isEmpty()) return null

        val dbList: MutableList<StressHistory> = ArrayList()
        var currentDate: Long = sdkStressList[0].date.time

        for (item in sdkStressList) {
            currentDate += item.offset * 60000L
            if (item.value > 0) {
                val dbItem = StressHistory()
                dbItem.value = item.value
                dbItem.date = DateHelpers.formatEpochToISO(currentDate)
                dbList.add(dbItem)
            }
        }

        return dbList
    }

    fun convertDataStorageObj2JSObj(dbStressList: List<StressHistory>): WritableArray {
        val jsList: WritableArray = Arguments.createArray()
        for (item in dbStressList) {
            val jsItem: WritableMap = Arguments.createMap()
            jsItem.putString("date", item.date)
            jsItem.putInt("value", item.value)
            jsList.pushMap(jsItem)
        }
        return jsList
    }

}