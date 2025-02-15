package com.carechaincore.impl.shared.storage.models.entities.pedometer;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PedometerHistoryData {
    @PrimaryKey
    @NonNull
    public String date;

    public int pedometer;
    public int calories;
    public int distance;
    public boolean deleted;
}