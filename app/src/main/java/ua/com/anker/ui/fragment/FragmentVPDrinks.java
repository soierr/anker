package ua.com.anker.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import ua.com.anker.R;
import ua.com.anker.ui.adapter.MenuItemsAdapter;
import ua.com.anker.viewmodel.menu.MenuItemVM;

public class FragmentVPDrinks extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_viepager_drinks, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_drinks);
        MenuItemsAdapter adapter = new MenuItemsAdapter();
        recyclerView.setAdapter(adapter);
        MenuItemVM menuItemVM = new ViewModelProvider(this).get(MenuItemVM.class);
        menuItemVM.getMenuItems().observe(Objects.requireNonNull(getActivity()), adapter::submitList);
        return view;
    }
}
