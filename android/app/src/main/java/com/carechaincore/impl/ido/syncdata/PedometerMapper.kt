package com.carechaincore.impl.ido.syncdata

import com.carechaincore.impl.shared.helpers.DateHelpers
import com.carechaincore.impl.shared.storage.models.entities.heartRate.HeartRateHistory
import com.carechaincore.impl.shared.storage.models.entities.pedometer.PedometerHistoryData
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableMap
import com.ido.ble.data.manage.database.HealthSportV3

object PedometerMapper {
    fun convertSdkObj2DataStorageObj(sdkPedometer: HealthSportV3): PedometerHistoryData? {
        if (sdkPedometer.items.isEmpty()) return null

        val dbPedometerDayResume = PedometerHistoryData()
        dbPedometerDayResume.pedometer = sdkPedometer.total_step
        dbPedometerDayResume.calories = sdkPedometer.total_activity_calories
        dbPedometerDayResume.distance = sdkPedometer.total_distances
        dbPedometerDayResume.date = DateHelpers.formatDateISO(DateHelpers.getDateOnDay(
            sdkPedometer.year, sdkPedometer.month, sdkPedometer.day))

        return dbPedometerDayResume
    }

    fun convertDataStorageObj2JSObj(dbPedometerList: List<PedometerHistoryData>): WritableMap {
        val jsItem: WritableMap = Arguments.createMap()

        if(dbPedometerList.isEmpty()) return jsItem
        val dbPedometer = dbPedometerList[0]

        jsItem.putString("date", dbPedometer.date)
        jsItem.putInt("steps", dbPedometer.pedometer)
        jsItem.putInt("calories", dbPedometer.calories)
        jsItem.putInt("distance", dbPedometer.distance)
        return jsItem
    }
}