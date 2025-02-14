package com.carechaincore.impl.ido.syncdata

import com.carechaincore.impl.shared.helpers.DateHelpers
import com.carechaincore.impl.shared.storage.models.entities.pedometer.PedometerHistoryData
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
}