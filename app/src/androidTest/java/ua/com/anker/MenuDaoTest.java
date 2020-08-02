package ua.com.anker;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import ua.com.anker.data.dao.AnkerDatabase;
import ua.com.anker.data.dao.MenuDao;
import ua.com.anker.data.model.MenuItem;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MenuDaoTest {
    private MenuDao menuDao;
    private AnkerDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AnkerDatabase.class).build();
        menuDao = db.menuDao();
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void findAllTest() {
        MenuItem menuItem = new MenuItem();
        menuItem.setCode(1);
        menuItem.setTitle("Hello there");
        menuItem.setPrice(2000);
        menuDao.save(menuItem);

        List<MenuItem> menuItems = menuDao.findAll();

        assertThat(menuItems, containsInAnyOrder(menuItem));
    }
}
