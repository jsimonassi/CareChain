package com.carechaincore.impl.shared.storage.DAOs.heartRate;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.carechaincore.impl.shared.storage.models.entities.heartRate.HeartRateHistory;

import java.util.List;

@Dao
public interface HeartRateHistoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HeartRateHistory... heartRateHistories);

    @Update
    void update(HeartRateHistory... heartRateHistories);

    @Query("SELECT * FROM HeartRateHistory WHERE deleted = 0")
    List<HeartRateHistory> getHistory();

    @Query("SELECT * FROM HeartRateHistory WHERE date >= :dayDate AND date < :nextDayDate")
    List<HeartRateHistory> getHistoryOfDay(String dayDate, String nextDayDate);

    @Query("SELECT * FROM HeartRateHistory WHERE date >= :startDate AND date <= :endDate")
    List<HeartRateHistory> getHistoryOfPeriod(String startDate, String endDate);

}
