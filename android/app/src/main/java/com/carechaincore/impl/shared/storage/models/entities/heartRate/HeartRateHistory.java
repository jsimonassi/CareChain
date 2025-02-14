package com.carechaincore.impl.shared.storage.models.entities.heartRate;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {@Index(value = {"date"}, unique = true)}
)
public class HeartRateHistory {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int value;
    public int minValuePeriod;
    public int maxValuePeriod;
    @NonNull
    public String date;
    public boolean deleted;
}
