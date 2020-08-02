package ua.com.anker.ui.adapter;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;

import ua.com.anker.ActivityMain;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGES = 2;

    private Map<Integer, Fragment> fragments;

    @Inject
    public ViewPagerAdapter(Map<Integer, Fragment> fragments,
                            @NonNull ActivityMain activityMain) {
        super(activityMain);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return Objects.requireNonNull(fragments.get(position));
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

}
