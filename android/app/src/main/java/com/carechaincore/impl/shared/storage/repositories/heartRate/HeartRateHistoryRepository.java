package com.carechaincore.impl.shared.storage.repositories.heartRate;

import com.carechaincore.impl.shared.helpers.DateHelpers;
import com.carechaincore.impl.shared.storage.DAOs.heartRate.HeartRateHistoryDAO;
import com.carechaincore.impl.shared.storage.DataStorage;
import com.carechaincore.impl.shared.storage.models.entities.heartRate.HeartRateHistory;

import java.util.Date;
import java.util.List;

public class HeartRateHistoryRepository {
    public static void insert(HeartRateHistory... heartRateHistory) {
        getHeartRateHistoryDAO().insert(heartRateHistory);
    }

    public static void update(HeartRateHistory... heartRateHistories) {
        getHeartRateHistoryDAO().update(heartRateHistories);
    }

    public static List<HeartRateHistory> getHistory() {
        return getHeartRateHistoryDAO().getHistory();
    }

    public static List<HeartRateHistory> getHistoryOfDay(Date dayDate) {
        Date startDayDate = DateHelpers.getStartOfDay(dayDate);
        Date nextDayDate = DateHelpers.addDateDays(dayDate, 1);

        String startDayDateString = DateHelpers.formatDateOnlyISO(startDayDate);
        String nextDayDateString = DateHelpers.formatDateOnlyISO(nextDayDate);

        return getHeartRateHistoryDAO().getHistoryOfDay(startDayDateString, nextDayDateString);
    }

    public static List<HeartRateHistory> getHistoryOfPeriod(Date startDate, Date endDate) {
        startDate = DateHelpers.getStartOfDay(startDate);
        endDate = DateHelpers.getEndOfDay(endDate);

        String startDateString = DateHelpers.formatDateISO(startDate);
        String endDateString = DateHelpers.formatDateISO(endDate);

        return getHeartRateHistoryDAO().getHistoryOfPeriod(startDateString, endDateString);
    }

    private static HeartRateHistoryDAO getHeartRateHistoryDAO() {
        return DataStorage.Companion.getInstance().getDatabase().HeartRateHistoryDAO();
    }
}
