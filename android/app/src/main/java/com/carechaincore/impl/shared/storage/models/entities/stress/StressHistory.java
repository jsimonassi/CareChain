package com.carechaincore.impl.shared.storage.models.entities.stress;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity
public class StressHistory {

    @PrimaryKey
    @NonNull
    public String date;
    public int value;
    public int minValuePeriod;
    public int maxValuePeriod;
    public boolean deleted;
}
