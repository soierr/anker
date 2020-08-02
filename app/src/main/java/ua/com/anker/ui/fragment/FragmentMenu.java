package ua.com.anker.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Objects;

import javax.inject.Inject;

import ua.com.anker.ActivityMain;
import ua.com.anker.R;
import ua.com.anker.ui.adapter.ViewPagerAdapter;

public class FragmentMenu extends Fragment {
    @Inject
    ViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        Objects.requireNonNull(((ActivityMain) getActivity())).getActivityMainComponent()
                .inject(this);
        ViewPager2 viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        return view;
    }
}
