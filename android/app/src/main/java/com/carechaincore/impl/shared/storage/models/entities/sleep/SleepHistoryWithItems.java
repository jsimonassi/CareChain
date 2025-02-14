package com.carechaincore.impl.shared.storage.models.entities.sleep;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class SleepHistoryWithItems {
    @Embedded
    public SleepHistory sleepHistory;
    @Relation(
            parentColumn = "id",
            entityColumn = "idSleepHistory"
    )
    public List<SleepHistoryItem> items;
}
