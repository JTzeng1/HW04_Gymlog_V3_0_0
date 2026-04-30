package com.example.hw04_gymlog_v300.Database.typeConverters;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTypeConverter {
    @TypeConverter
    public long convertToLong(LocalDateTime date) {
        if (date == null) {
            return 0;
        }
        return date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    @TypeConverter
    public LocalDateTime convertToDate(long epochMilli) {
        if (epochMilli == 0) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
    }
}
