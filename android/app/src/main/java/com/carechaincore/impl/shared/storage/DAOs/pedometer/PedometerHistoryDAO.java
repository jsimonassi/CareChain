package com.carechaincore.impl.shared.storage.DAOs.pedometer;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.carechaincore.impl.shared.storage.models.entities.pedometer.PedometerHistoryData;

import java.util.List;

@Dao
public interface PedometerHistoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PedometerHistoryData... pedometerHistoryData);

    @Query("SELECT * FROM PedometerHistoryData WHERE date >= :lowerDate AND deleted = 0")
    List<PedometerHistoryData> getHistoryAfterDate(String lowerDate);

    @Query("SELECT * FROM PedometerHistoryData WHERE date = :date")
    PedometerHistoryData get(String date);

    @Query("SELECT * FROM PedometerHistoryData WHERE date >= :startDate AND date < :endDate")
    List<PedometerHistoryData> getHistoryOfDay(String startDate, String endDate);

    @Query("SELECT * FROM PedometerHistoryData WHERE date >= :startDate AND date <= :endDate")
    List<PedometerHistoryData> getHistoryOfPeriod(String startDate, String endDate);

    @Query("UPDATE PedometerHistoryData SET pedometer = :pedometer, distance = :distance, calories = :calories WHERE date = :date")
    void update(String date, int pedometer, int distance, int calories);

    @Update
    void update(PedometerHistoryData... pedometerHistoryData);

}