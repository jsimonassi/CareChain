package com.carechaincore.impl.shared.storage.repositories.pedometer;

import com.carechaincore.impl.shared.helpers.DateHelpers;
import com.carechaincore.impl.shared.storage.DAOs.pedometer.PedometerHistoryDAO;
import com.carechaincore.impl.shared.storage.DataStorage;
import com.carechaincore.impl.shared.storage.models.entities.pedometer.PedometerHistoryData;

import java.util.Date;
import java.util.List;

public class PedometerHistoryRepository {

    public static void update(String date, int pedometer, int distance, int calories) {
        getPedometerHistoryDao().update(date, pedometer, distance, calories);
    }

    public static void update(PedometerHistoryData... pedometerHistoryData) {
        getPedometerHistoryDao().update(pedometerHistoryData);
    }

    public static void insert(PedometerHistoryData... pedometerHistoryData) {
        getPedometerHistoryDao().insert(pedometerHistoryData);
    }

    public static PedometerHistoryData get(String date) {
        return getPedometerHistoryDao().get(date);
    }

    public static List<PedometerHistoryData> getHistoryOfDay(Date dateDay) {
        Date startDate = DateHelpers.getStartOfDay(dateDay);
        Date endDate = DateHelpers.addDateDays(startDate, 1);

        String startDateString = DateHelpers.formatDateOnlyISO(startDate);
        String endDateString = DateHelpers.formatDateOnlyISO(endDate);

        return getPedometerHistoryDao().getHistoryOfDay(startDateString, endDateString);
    }

    public static List<PedometerHistoryData> getHistoryOfPeriod(Date startDate, Date endDate) {
        startDate = DateHelpers.getStartOfDay(startDate);
        endDate = DateHelpers.getEndOfDay(endDate);

        String startDateString = DateHelpers.formatDateISO(startDate);
        String endDateString = DateHelpers.formatDateISO(endDate);

        return getPedometerHistoryDao().getHistoryOfPeriod(startDateString, endDateString);
    }

    public static List<PedometerHistoryData> getHistoryLastMonth() {
        Date startDate = DateHelpers.addDateMonths(new Date(), -1);
        String startDateString = DateHelpers.formatDate(startDate, "yyyy-MM-dd'T00:00:00'");
        return getPedometerHistoryDao().getHistoryAfterDate(startDateString);
    }

    private static PedometerHistoryDAO getPedometerHistoryDao() {
        return DataStorage.Companion.getInstance().getDatabase().PedometerHistoryDAO();
    }
}
