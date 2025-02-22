package com.carechaincore.impl.shared.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.carechaincore.impl.shared.storage.DAOs.heartRate.HeartRateHistoryDAO;
import com.carechaincore.impl.shared.storage.DAOs.pedometer.PedometerHistoryDAO;
import com.carechaincore.impl.shared.storage.DAOs.sleep.SleepHistoryDao;
import com.carechaincore.impl.shared.storage.DAOs.stress.StressHistoryDAO;
import com.carechaincore.impl.shared.storage.models.entities.heartRate.HeartRateHistory;
import com.carechaincore.impl.shared.storage.models.entities.pedometer.PedometerHistoryData;
import com.carechaincore.impl.shared.storage.models.entities.sleep.SleepHistory;
import com.carechaincore.impl.shared.storage.models.entities.stress.StressHistory;

@Database(entities = {
        PedometerHistoryData.class,
        SleepHistory.class,
        HeartRateHistory.class,
        StressHistory.class,
}, version = 1)
      
public abstract class CareChainAppDatabase extends RoomDatabase {
    public abstract PedometerHistoryDAO PedometerHistoryDAO();
    public abstract SleepHistoryDao SleepHistoryDao();
    public abstract HeartRateHistoryDAO HeartRateHistoryDAO();
    public abstract StressHistoryDAO StressHistoryDAO();
}
