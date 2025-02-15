package com.carechaincore.impl.shared.storage.repositories.sleep;

import com.carechaincore.impl.shared.helpers.DateHelpers;
import com.carechaincore.impl.shared.storage.DAOs.sleep.SleepHistoryDao;
import com.carechaincore.impl.shared.storage.DataStorage;
import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class SleepHistoryRepository {

    public static Long insert(SleepHistory sleepHistory) {
        return getSleepHistoryDao().insert(sleepHistory);
    }

    public static List<Long> insert(SleepHistory... sleepHistories) {
        return getSleepHistoryDao().insert(sleepHistories);
    }

    public static void update(SleepHistory sleepHistory) {
        getSleepHistoryDao().update(sleepHistory);
    }

    public static void update(SleepHistory... sleepHistories) {
        getSleepHistoryDao().update(sleepHistories);
    }

    public static SleepHistory getBySleepDate(String sleepDate) {
        return getSleepHistoryDao().getBySleepDate(sleepDate);
    }

    public static SleepHistory getBySleepDateStart(String sleepDateStart) {
        return getSleepHistoryDao().getBySleepDateStart(sleepDateStart);
    }

    public static List<SleepHistory> getSleepHistoryByPeriod(Date startDate, Date endDate) {
        startDate = DateHelpers.getStartOfDay(startDate);
        endDate = DateHelpers.getEndOfDay(endDate);

        String startDateString = DateHelpers.formatDateISO(startDate);
        String endDateString = DateHelpers.formatDateISO(endDate);

        return getSleepHistoryDao().getHistoryOfPeriod(startDateString, endDateString);
    }

    public static List<SleepHistory> getSleepHistoryByPeriod(LocalDate startDate, LocalDate endDate) {
        Date startDateLegacy = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDateLegacy = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return getSleepHistoryByPeriod(startDateLegacy, endDateLegacy);
    }

    private static SleepHistoryDao getSleepHistoryDao() {
        return DataStorage.Companion.getInstance().getDatabase().SleepHistoryDao();
    }
}
