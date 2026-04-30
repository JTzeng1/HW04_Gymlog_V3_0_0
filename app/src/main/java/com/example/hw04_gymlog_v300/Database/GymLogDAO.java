package com.example.hw04_gymlog_v300.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hw04_gymlog_v300.Database.entities.GymLog;


import java.util.List;


@Dao
public interface GymLogDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GymLog gymlog);

    @Query("SELECT * FROM " + GymLogDataBase.GYM_LOG_TABLE + " ORDER BY date DESC")
    List<GymLog> getAllRecords();

    @Query("SELECT * FROM " + GymLogDataBase.GYM_LOG_TABLE + " WHERE userId = :loggedInUserId ORDER BY date DESC")
    List<GymLog> getRecordsByUserId(int loggedInUserId);

    @Query("SELECT * FROM " + GymLogDataBase.GYM_LOG_TABLE + " WHERE userId = :loggedInUserId ORDER BY date DESC")
    LiveData<List<GymLog>> getRecordsByUserIdLivesData(int loggedInUserId);
}


