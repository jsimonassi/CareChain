package com.carechaincore.impl.shared.storage.DAOs.calorie;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.carechaincore.impl.shared.storage.models.entities.calorie.CalorieHistoryData;

import java.util.List;

@Dao
public interface CalorieHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CalorieHistoryData... calorieHistoryData);

    @Update
    void update(CalorieHistoryData... calorieHistoryData);

    @Query("SELECT * FROM CalorieHistoryData WHERE date in (:dateList)")
    List<CalorieHistoryData> getDataByDateList(List<String> dateList);

    @Query("SELECT * FROM CalorieHistoryData WHERE deleted = 0 ORDER BY date")
    List<CalorieHistoryData> getHistory();

    @Query("SELECT * FROM CalorieHistoryData WHERE date >= :startDate AND date <= :endDate")
    List<CalorieHistoryData> getHistoryOfPeriod(String startDate, String endDate);

}
