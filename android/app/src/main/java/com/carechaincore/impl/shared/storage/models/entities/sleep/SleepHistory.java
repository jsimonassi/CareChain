package com.carechaincore.impl.shared.storage.models.entities.sleep;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SleepHistory {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public int totalSleepMinutes;
    public int lightSleepMinutes;
    public int deepSleepMinutes;
    public int remSleepMinutes;
    public int awakeSleepMinutes;
    public Integer awrrStatus;
    public Integer sleepScore;
    public Integer breathQuality;

    @NonNull
    public String sleepDate;
    public String sleepDateStart;
    public boolean deleted;
}
