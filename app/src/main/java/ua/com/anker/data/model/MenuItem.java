package ua.com.anker.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity(tableName = "MENU_ITEMS")
public class MenuItem {
    @PrimaryKey(autoGenerate = true)
    private int code;
    private String title;
    private String description;
    private long price;
    private byte[] image;
}
