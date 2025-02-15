package com.carechaincore.impl.shared.storage.repositories.stress;

import com.carechaincore.impl.shared.helpers.DateHelpers;
import com.carechaincore.impl.shared.storage.DAOs.stress.StressHistoryDAO;
import com.carechaincore.impl.shared.storage.DataStorage;
import com.carechaincore.impl.shared.storage.models.entities.stress.StressHistory;

import java.util.Date;
import java.util.List;

public class StressHistoryRepository {
    public static void insert(StressHistory... stressHistory) {
        getStressHistoryDAO().insert(stressHistory);
    }

    public static void update(StressHistory... stressHistories) {
        getStressHistoryDAO().update(stressHistories);
    }

    public static List<StressHistory> getHistory() {
        return getStressHistoryDAO().getHistory();
    }

    public static List<StressHistory> getHistoryOfDay(Date dayDate) {
        Date startDayDate = DateHelpers.getStartOfDay(dayDate);
        Date nextDayDate = DateHelpers.addDateDays(dayDate, 1);

        String startDayDateString = DateHelpers.formatDateOnlyISO(startDayDate);
        String nextDayDateString = DateHelpers.formatDateOnlyISO(nextDayDate);

        return getStressHistoryDAO().getHistoryOfDay(startDayDateString, nextDayDateString);
    }

    public static List<StressHistory> getHistoryOfPeriod(Date startDate, Date endDate) {
        startDate = DateHelpers.getStartOfDay(startDate);
        endDate = DateHelpers.getEndOfDay(endDate);

        String startDateString = DateHelpers.formatDateISO(startDate);
        String endDateString = DateHelpers.formatDateISO(endDate);

        return getStressHistoryDAO().getHistoryOfPeriod(startDateString, endDateString);
    }

    private static StressHistoryDAO getStressHistoryDAO() {
        return DataStorage.Companion.getInstance().getDatabase().StressHistoryDAO();
    }
}
