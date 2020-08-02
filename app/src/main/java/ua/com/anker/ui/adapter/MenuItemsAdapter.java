package ua.com.anker.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import ua.com.anker.R;
import ua.com.anker.data.model.MenuItem;
import ua.com.anker.databinding.MenuItemBinding;

public class MenuItemsAdapter extends PagedListAdapter<ua.com.anker.data.model.MenuItem,
        MenuItemsAdapter.MenuItemHolder> {

    public MenuItemsAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MenuItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MenuItemBinding cardMenuItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.menu_item,
                parent,
                false);
        return new MenuItemHolder(cardMenuItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemHolder holder, int position) {
        holder.setMenuItem(getItem(position));
    }

    public static class MenuItemHolder extends RecyclerView.ViewHolder {

        private MenuItemBinding menuItemBinding;

        public MenuItemHolder(MenuItemBinding menuItemBinding) {
            super(menuItemBinding.getRoot());
            this.menuItemBinding = menuItemBinding;
        }

        public void setMenuItem(MenuItem menuItem) {
            menuItemBinding.setMenuItem(menuItem);
        }
    }

    private static DiffUtil.ItemCallback<MenuItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MenuItem>() {

                @Override
                public boolean areItemsTheSame(MenuItem oldItem, MenuItem newItem) {
                    return oldItem.getCode() == newItem.getCode();
                }

                @Override
                public boolean areContentsTheSame(MenuItem oldItem, @NonNull MenuItem newItem) {
                    return oldItem.equals(newItem);
                }
            };
}
