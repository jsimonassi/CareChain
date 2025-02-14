package com.carechaincore.impl.shared.storage.repositories.calorie;

import com.carechaincore.impl.shared.helpers.DateHelpers;
import com.carechaincore.impl.shared.storage.DAOs.calorie.CalorieHistoryDao;
import com.carechaincore.impl.shared.storage.DataStorage;
import com.carechaincore.impl.shared.storage.models.entities.calorie.CalorieHistoryData;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CalorieHistoryRepository {

    /**
     * Salva novos dados;
     * Atualiza dados modificados;
     * Ignora dados iguais (Possuem mesmo passo, caloria e tempo ativo)
     * @param calorieHistoryDataListByHour Lista de dados concatenados/agrupados por hora.
     * A verificação de igualdade é feita com base no método "contains". Este método usa "equals"
     *      internamente e este foi sobrescrito em ({@link CalorieHistoryData}).
     */
    public static void insertOrUpdateIfExists(List<CalorieHistoryData> calorieHistoryDataListByHour) {
        if(calorieHistoryDataListByHour.isEmpty()) return;

        List<String> datesToFind = calorieHistoryDataListByHour.stream()
                .map(item -> item.date)
                .collect(Collectors.toList());

        List<CalorieHistoryData> existingItems = getCalorieHistoryDao().getDataByDateList(datesToFind);

        getCalorieHistoryDao().insert(calorieHistoryDataListByHour.stream()
                .filter(item -> !existingItems.contains(item)).toArray(CalorieHistoryData[]::new));
    }

    public static void update(CalorieHistoryData... calorieHistoryData) {
        getCalorieHistoryDao().update(calorieHistoryData);
    }

    public static void insert(CalorieHistoryData... calorieHistoryData) {
        getCalorieHistoryDao().insert(calorieHistoryData);
    }

    public static List<CalorieHistoryData> getHistory() {
        return getCalorieHistoryDao().getHistory();
    }

    public static List<CalorieHistoryData> getHistoryOfPeriod(Date startDate, Date endDate) {
        startDate = DateHelpers.getStartOfDay(startDate);
        endDate = DateHelpers.getEndOfDay(endDate);

        String startDateString = DateHelpers.formatDateISO(startDate);
        String endDateString = DateHelpers.formatDateISO(endDate);

        return getCalorieHistoryDao().getHistoryOfPeriod(startDateString, endDateString);
    }



    private static CalorieHistoryDao getCalorieHistoryDao() {
        return DataStorage.Companion.getInstance().getDatabase().CalorieHistoryDao();
    }
}
