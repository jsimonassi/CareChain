package com.carechaincore.impl.shared.storage.models.entities.calorie;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CalorieHistoryData {

    public int activityCaloriesValue;
    public int restCaloriesValue;

    @PrimaryKey
    @NonNull
    public String date;
    public boolean deleted;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final CalorieHistoryData other = (CalorieHistoryData) obj;
        return (this.activityCaloriesValue == other.activityCaloriesValue) &&
                (this.restCaloriesValue == other.restCaloriesValue);
    }
}
