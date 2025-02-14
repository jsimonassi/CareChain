package com.carechaincore.impl.shared.storage.models.entities.sleep;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(
    entity = SleepHistory.class,
    parentColumns = "id",
    childColumns = "idSleepHistory",
    onDelete = ForeignKey.CASCADE)
})
public class SleepHistoryItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int sleepType;
    public int sleepMinutes;

    @NonNull
    public String startDate;

    @NonNull
    public String endDate;

    @ColumnInfo(index = true)
    public long idSleepHistory;
}
