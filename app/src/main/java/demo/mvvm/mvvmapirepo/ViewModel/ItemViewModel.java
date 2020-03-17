package demo.mvvm.mvvmapirepo.ViewModel;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import demo.mvvm.mvvmapirepo.POJOClasses.Item;
import demo.mvvm.mvvmapirepo.Repository.ItemRepository;

public class ItemViewModel extends AndroidViewModel {

    ItemRepository mItemRepository ;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        mItemRepository = new ItemRepository();
    }

    public void insert(Item item) {
        mItemRepository.insert(item);
    }

    public void update(Item item) {
        mItemRepository.update(item);
    }

    public void delete(Integer item) {
        mItemRepository.delete(item);
    }

    public void deleteAllNote() {
        mItemRepository.deleteAll();
    }

    public MutableLiveData<List<Item>> getAllItem() {
        return mItemRepository.getAllItem();
    }
}
