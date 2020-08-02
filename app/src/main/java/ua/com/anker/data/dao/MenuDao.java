package ua.com.anker.data.dao;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ua.com.anker.data.model.MenuItem;

@Dao
public interface MenuDao {
    @Query("select * FROM menu_items")
    List<MenuItem> findAll();

    @Query("select * FROM menu_items")
    DataSource.Factory<Integer, MenuItem> findAllMenuItems();

    @Insert
    void save(MenuItem menuItem);
}
