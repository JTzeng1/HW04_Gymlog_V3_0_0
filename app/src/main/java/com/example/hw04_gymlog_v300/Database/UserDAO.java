package com.example.hw04_gymlog_v300.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hw04_gymlog_v300.Database.entities.GymLog;
import com.example.hw04_gymlog_v300.Database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + GymLogDataBase.USER_TABLE + " ORDER BY userName")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM " + GymLogDataBase.USER_TABLE + " ORDER BY userName")
    List<User> getAllUsersList();

    @Query("DELETE FROM " + GymLogDataBase.USER_TABLE)
    void deleteAll();

    @Query("SELECT * FROM " + GymLogDataBase.USER_TABLE + " WHERE userName = :username")
    LiveData<User> getUserByUserName(String username);

    @Query("SELECT * FROM " + GymLogDataBase.USER_TABLE + " WHERE id = :userId")
    LiveData<User> getUserByUserId(int userId);


}
