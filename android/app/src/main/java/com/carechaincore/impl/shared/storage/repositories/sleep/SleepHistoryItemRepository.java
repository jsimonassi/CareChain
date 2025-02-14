package com.carechaincore.impl.shared.storage.repositories.sleep;

import com.carechaincore.impl.shared.storage.DAOs.sleep.SleepHistoryItemDao;
import com.carechaincore.impl.shared.storage.DataStorage;
import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistoryItem;

import java.util.List;

public class SleepHistoryItemRepository {
    public static void insert(SleepHistoryItem... sleepHistoryItems) {
        getSleepHistoryItemDao().insert(sleepHistoryItems);
    }

    public static void deleteByIdSleepHistory(long sleepHistoryId) {
        getSleepHistoryItemDao().deleteByIdSleepHistory(sleepHistoryId);
    }

    public static void deleteByIdsSleepHistory(List<Long> sleepHistoryIds) {
        getSleepHistoryItemDao().deleteByIdsSleepHistory(sleepHistoryIds);
    }

    private static SleepHistoryItemDao getSleepHistoryItemDao() {
        return DataStorage.Companion.getInstance().getDatabase().SleepHistoryItemDao();
    }
}
