package com.carechaincore.impl.shared.storage.models.entities.heartRate;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity
public class HeartRateHistory {
    @PrimaryKey
    @NonNull
    public String date;

    public int value;
    public int minValuePeriod;
    public int maxValuePeriod;

    public boolean deleted;
}
