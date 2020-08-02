package ua.com.anker.data.repository;

import java.util.List;

import lombok.AllArgsConstructor;
import ua.com.anker.data.dao.MenuDao;
import ua.com.anker.data.model.MenuItem;

@AllArgsConstructor
public class MenuRepositoryImpl implements MenuRepository {

    private MenuDao menuDao;

    @Override
    public List<MenuItem> findAll() {
        return menuDao.findAll();
    }

    @Override
    public void save(MenuItem menuItem) {
        menuDao.save(menuItem);
    }
}
