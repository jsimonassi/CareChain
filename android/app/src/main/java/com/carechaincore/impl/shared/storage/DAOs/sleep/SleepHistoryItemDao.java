package com.carechaincore.impl.shared.storage.DAOs.sleep;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistoryItem;

import java.util.List;

@Dao
public interface SleepHistoryItemDao {
    @Insert
    void insert(SleepHistoryItem... sleepHistoryItems);

    @Query("DELETE FROM SleepHistoryItem WHERE idSleepHistory = :idSleepHistory")
    void deleteByIdSleepHistory(long idSleepHistory);

    @Query("DELETE FROM SleepHistoryItem WHERE idSleepHistory IN (:idsSleepHistory)")
    void deleteByIdsSleepHistory(List<Long> idsSleepHistory);
}
