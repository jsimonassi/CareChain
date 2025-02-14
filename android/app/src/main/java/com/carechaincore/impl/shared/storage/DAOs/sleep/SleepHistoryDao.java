package com.carechaincore.impl.shared.storage.DAOs.sleep;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistory;
import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistoryWithItems;

import java.util.List;

@Dao
public interface SleepHistoryDao {
    @Insert
    Long insert(SleepHistory sleepHistory);

    @Insert
    List<Long> insert(SleepHistory... sleepHistories);

    @Query("SELECT * FROM SleepHistory WHERE sleepDate = :sleepDate")
    SleepHistory getBySleepDate(String sleepDate);

    @Query("SELECT * FROM SleepHistory WHERE sleepDateStart = :sleepDateStart")
    SleepHistory getBySleepDateStart(String sleepDateStart);

    @Update
    void update(SleepHistory sleepHistory);

    @Update
    void update(SleepHistory... sleepHistories);

    @Transaction
    @Query("SELECT * FROM SleepHistory WHERE deleted = 0")
    List<SleepHistoryWithItems> getSleepHistoryWithItems();

    @Query("SELECT * FROM SleepHistory WHERE sleepDate >= :startDate AND sleepDate <= :endDate")
    List<SleepHistory> getHistoryOfPeriod(String startDate, String endDate);
}
