package demo.mvvm.mvvmapirepo.Repository;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import demo.mvvm.mvvmapirepo.POJOClasses.Item;
import demo.mvvm.mvvmapirepo.RetrofitUtility.RetrofitInstance;
import demo.mvvm.mvvmapirepo.Utility.ItemAPIEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemRepository {

    private MutableLiveData<List<Item>> listMutableLiveData = new MutableLiveData<>();

    public void insert(Item note) {

    }


    public void update(Item item) {

    }


    public void delete(Integer item) {

    }


    public void deleteAll() {

    }


    public MutableLiveData<List<Item>> getAllItem() {

        // Create handle for the RetrofitInstance Interface
        ItemAPIEndpoint mItemAPIEndpoint = RetrofitInstance.getRetrofitInstance().create(ItemAPIEndpoint.class);

        // Call the method with parameter in the interface to Add the new Item
        Call<List<Item>> call = mItemAPIEndpoint.getAllItems();

        // Asynchronous call
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                listMutableLiveData.postValue(response.body());
                Log.v("Get All Items : ", response.body().get(0).itemName + " : onResponse");
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.v("Get All Items : ", t + " : onFailure");
            }
        });

        return listMutableLiveData;
    }
}
