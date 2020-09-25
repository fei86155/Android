package com.example.android.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android.db.dao.UserDao;
import com.example.android.db.entity.User;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 15:56
 * Update Date:
 * Modified By:
 * Description:
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}