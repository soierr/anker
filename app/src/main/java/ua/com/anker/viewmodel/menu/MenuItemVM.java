package ua.com.anker.viewmodel.menu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import javax.inject.Inject;

import lombok.Getter;
import ua.com.anker.App;
import ua.com.anker.data.dao.MenuDao;
import ua.com.anker.data.model.MenuItem;

public class MenuItemVM extends ViewModel {
    @Getter
    private final LiveData<PagedList<MenuItem>> menuItems;
    @Inject
    MenuDao menuDao;

    public MenuItemVM() {
        App.getAppComponent().inject(this);
        menuItems = new LivePagedListBuilder<>(menuDao.findAllMenuItems(), 10).build();
    }
}
