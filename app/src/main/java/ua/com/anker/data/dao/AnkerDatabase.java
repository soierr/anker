package ua.com.anker.data.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ua.com.anker.data.model.MenuItem;

@Database(entities = {MenuItem.class}, version = 1, exportSchema = false)
public abstract class AnkerDatabase extends RoomDatabase {
    public abstract MenuDao menuDao();
}
