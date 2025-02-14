package com.carechaincore.impl.shared.storage.models.entities.pedometer;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {@Index(value = {"date"}, unique = true)}
)
public class PedometerHistoryData {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int pedometer;
    public int calories;
    public int distance;

    @NonNull
    public String date;
    public boolean deleted;
}