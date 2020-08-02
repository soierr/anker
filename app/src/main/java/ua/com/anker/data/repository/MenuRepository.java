package ua.com.anker.data.repository;

import java.util.List;

import ua.com.anker.data.model.MenuItem;

public interface MenuRepository {
    List<MenuItem> findAll();
    void save(MenuItem menuItem);
}
