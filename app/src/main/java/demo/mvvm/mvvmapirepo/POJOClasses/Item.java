package demo.mvvm.mvvmapirepo.POJOClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("Id")
    @Expose
    public Integer id;
    @SerializedName("ItemCode")
    @Expose
    public String itemCode;
    @SerializedName("ItemName")
    @Expose
    public String itemName;

    public Item(String itemCode, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}