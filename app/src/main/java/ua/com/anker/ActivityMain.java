package ua.com.anker;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import ua.com.anker.databinding.ActivityMainBinding;
import ua.com.anker.di.ActivityMainComponent;
import ua.com.anker.di.DaggerActivityMainComponent;
import ua.com.anker.viewmodel.activity.ActivityBinding;
import ua.com.anker.viewmodel.activity.NavigationEvent;
import ua.com.anker.viewmodel.activity.Screen;

public class ActivityMain extends AppCompatActivity {
    @Inject
    Map<Screen, Fragment> fragments;
    @Getter
    private ActivityMainComponent activityMainComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activityMainComponent = DaggerActivityMainComponent.builder().activity(this).build();
        activityMainComponent.inject(this);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        ActivityBinding activityBinding = new ActivityBinding();
        activityMainBinding.setActivityBinding(activityBinding);
        activityMainBinding.setLifecycleOwner(this);
        activityBinding.getLiveData().observe(this,
                this::loadFragment);

        //temporal solution to avoid activity's fragments automatic restoring
        //as no arg constructor is called leading to an exception
        if (savedInstanceState != null) {
            savedInstanceState.clear();
        }

        super.onCreate(savedInstanceState);
    }

    public void loadFragment(NavigationEvent navigationEvent) {
        replaceFragment(fragments.get(navigationEvent.getScreen()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_empty, fragment);
        fragmentTransaction.commit();
    }
}
