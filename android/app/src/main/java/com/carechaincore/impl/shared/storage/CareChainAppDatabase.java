package com.carechaincore.impl.shared.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.carechaincore.impl.shared.storage.DAOs.calorie.CalorieHistoryDao;
import com.carechaincore.impl.shared.storage.DAOs.heartRate.HeartRateHistoryDAO;
import com.carechaincore.impl.shared.storage.DAOs.pedometer.PedometerHistoryDAO;
import com.carechaincore.impl.shared.storage.DAOs.sleep.SleepHistoryDao;
import com.carechaincore.impl.shared.storage.DAOs.sleep.SleepHistoryItemDao;
import com.carechaincore.impl.shared.storage.DAOs.stress.StressHistoryDAO;
import com.carechaincore.impl.shared.storage.models.entities.calorie.CalorieHistoryData;
import com.carechaincore.impl.shared.storage.models.entities.heartRate.HeartRateHistory;
import com.carechaincore.impl.shared.storage.models.entities.pedometer.PedometerHistoryData;
import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistory;
import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistoryItem;
import com.carechaincore.impl.shared.storage.models.entities.stress.StressHistory;

@Database(entities = {
        PedometerHistoryData.class,
        SleepHistory.class,
        SleepHistoryItem.class,
        HeartRateHistory.class,
        StressHistory.class,
        CalorieHistoryData.class,
}, version = 1)
      
public abstract class CareChainAppDatabase extends RoomDatabase {
    public abstract PedometerHistoryDAO PedometerHistoryDAO();
    public abstract SleepHistoryDao SleepHistoryDao();
    public abstract SleepHistoryItemDao SleepHistoryItemDao();
    public abstract HeartRateHistoryDAO HeartRateHistoryDAO();
    public abstract CalorieHistoryDao CalorieHistoryDao();
    public abstract StressHistoryDAO StressHistoryDAO();
}
