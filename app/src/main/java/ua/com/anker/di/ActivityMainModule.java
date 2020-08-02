package ua.com.anker.di;

import androidx.fragment.app.Fragment;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import ua.com.anker.ActivityMain;
import ua.com.anker.ui.adapter.ViewPagerAdapter;
import ua.com.anker.ui.fragment.FragmentMenu;
import ua.com.anker.ui.fragment.FragmentMenuEditor;
import ua.com.anker.ui.fragment.FragmentMenuStats;
import ua.com.anker.ui.fragment.FragmentVPDrinks;
import ua.com.anker.ui.fragment.FragmentVPFood;
import ua.com.anker.viewmodel.activity.Screen;

@Module
public class ActivityMainModule {
    @Provides
    @IntoMap
    @EnumScreenKey(Screen.MENU)
    Fragment fragmentMenu() {
        return new FragmentMenu();
    }

    //todo implement all below
    @Provides
    @IntoMap
    @EnumScreenKey(Screen.MENU_STATS)
    Fragment fragmentMenuStats() {
        return new FragmentMenuStats();
    }

    @Provides
    @IntoMap
    @EnumScreenKey(Screen.MENU_EDITOR)
    Fragment fragmentMenuEditor() {
        return new FragmentMenuEditor();
    }

    @Provides
    @IntoMap
    @IntKey(0)
    Fragment fragmentsVPDrinks() {
        return new FragmentVPDrinks();
    }

    @Provides
    @IntoMap
    @IntKey(1)
    Fragment fragmentsVPFood() {
        return new FragmentVPFood();
    }
}
