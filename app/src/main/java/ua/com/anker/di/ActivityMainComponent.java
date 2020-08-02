package ua.com.anker.di;

import dagger.BindsInstance;
import dagger.Component;
import ua.com.anker.ActivityMain;
import ua.com.anker.ui.fragment.FragmentMenu;

@Component(modules = ActivityMainModule.class)
public interface ActivityMainComponent {

    void inject(ActivityMain activityMain);
    void inject(FragmentMenu fragmentMenu);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder activity(ActivityMain activityMain);

        ActivityMainComponent build();
    }
}