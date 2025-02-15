package com.carechaincore.impl.shared.storage.DAOs.stress;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.carechaincore.impl.shared.storage.models.entities.stress.StressHistory;

import java.util.List;

@Dao
public interface StressHistoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(StressHistory... stressHistories);

    @Update
    void update(StressHistory... stressHistories);

    @Query("SELECT * FROM StressHistory WHERE deleted = 0")
    List<StressHistory> getHistory();

    @Query("SELECT * FROM StressHistory WHERE date >= :dayDate AND date < :nextDayDate")
    List<StressHistory> getHistoryOfDay(String dayDate, String nextDayDate);

    @Query("SELECT * FROM StressHistory WHERE date >= :startDate AND date <= :endDate")
    List<StressHistory> getHistoryOfPeriod(String startDate, String endDate);
}
