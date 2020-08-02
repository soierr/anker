package ua.com.anker.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import ua.com.anker.viewmodel.menu.MenuItemVM;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MenuItemVM menuItemVM);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder applicationContext(Context applicationContext);

        AppComponent build();
    }
}
