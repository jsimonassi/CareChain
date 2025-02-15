package com.carechaincore.impl.ido.syncdata

import com.carechaincore.impl.shared.helpers.DateHelpers
import com.carechaincore.impl.shared.storage.models.entities.pedometer.PedometerHistoryData
import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistory
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.ido.ble.data.manage.database.HealthSleepV3

object SleepMapper {
    fun convertSdkObj2DataStorageObj(sleepInfo: HealthSleepV3?): SleepHistory? {
        if (sleepInfo == null) return null

        val dbSleep = SleepHistory()
        dbSleep.sleepDate = DateHelpers.formatDateISO(
            DateHelpers.getDateTimeFromComponents(
            sleepInfo.get_up_year,
                sleepInfo.get_up_month,
                sleepInfo.get_up_day,
                sleepInfo.get_up_hour,
                sleepInfo.get_up_minte, 0))

        dbSleep.sleepDateStart = DateHelpers.formatDateISO(
            DateHelpers.getDateTimeFromComponents(
            sleepInfo.fall_asleep_year,
                sleepInfo.fall_asleep_month,
                sleepInfo.fall_asleep_day,
                sleepInfo.fall_asleep_hour,
                sleepInfo.fall_asleep_minte, 0))

        dbSleep.remSleepMinutes = sleepInfo.rem_mins
        dbSleep.lightSleepMinutes = sleepInfo.light_mins
        dbSleep.deepSleepMinutes = sleepInfo.deep_mins
        dbSleep.awakeSleepMinutes = sleepInfo.wake_mins
        dbSleep.totalSleepMinutes = sleepInfo.total_sleep_time_mins

        return dbSleep
    }

    fun convertDataStorageObj2JSObj(dbSleep: SleepHistory): WritableMap {
        val jsItem: WritableMap = Arguments.createMap()
        jsItem.putString("date", dbSleep.sleepDate)
        jsItem.putInt("totalSleepMinutes", dbSleep.totalSleepMinutes)
        jsItem.putInt("lightSleepMinutes", dbSleep.lightSleepMinutes)
        jsItem.putInt("deepSleepMinutes", dbSleep.deepSleepMinutes)
        jsItem.putInt("remSleepMinutes", dbSleep.remSleepMinutes)
        jsItem.putInt("awakeSleepMinutes", dbSleep.awakeSleepMinutes)
        return jsItem
    }

}