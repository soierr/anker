package ua.com.anker.di;

import android.content.Context;

import androidx.room.Room;

import dagger.Module;
import dagger.Provides;
import ua.com.anker.data.dao.AnkerDatabase;
import ua.com.anker.data.dao.MenuDao;
import ua.com.anker.data.repository.MenuRepository;
import ua.com.anker.data.repository.MenuRepositoryImpl;

@Module
public class AppModule {
    @Provides
    MenuDao menuDao(AnkerDatabase ankerDatabase) {
        return ankerDatabase.menuDao();
    }

    @Provides
    MenuRepository menuRepository(MenuDao menuDao) {
        return new MenuRepositoryImpl(menuDao);
    }

    @Provides
    AnkerDatabase ankerDatabase(Context applicationContext) {
        return Room.databaseBuilder(applicationContext,
                AnkerDatabase.class,
                "ankerdb")
                .createFromAsset("database/ankerdb")
                .fallbackToDestructiveMigration()
                .build();
    }
}
