package demo.mvvm.mvvmapirepo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import demo.mvvm.mvvmapirepo.Adapters.ItemAdapter;
import demo.mvvm.mvvmapirepo.ItemClickListener;
import demo.mvvm.mvvmapirepo.POJOClasses.Item;
import demo.mvvm.mvvmapirepo.R;
import demo.mvvm.mvvmapirepo.ViewModel.ItemViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ItemClickListener {

    ItemViewModel mItemViewModel;
    ItemAdapter mItemAdapter;
    RecyclerView noteRecyclerView;
    FloatingActionButton fabNoteMain;
    List<Item> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = new ArrayList<>();

        mItemAdapter = new ItemAdapter(this);

        initViewModel();
        initUI();
        initToolbar();
    }

    void initViewModel() {

        mItemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        mItemViewModel.getAllItem().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                listItems.addAll(items);
                mItemAdapter.setItemList(listItems);
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void initUI() {
        noteRecyclerView = findViewById(R.id.itemRecyclerView);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteRecyclerView.setHasFixedSize(true);

        fabNoteMain = findViewById(R.id.fabItemMain);
        fabNoteMain.setOnClickListener(this);

        noteRecyclerView.setAdapter(mItemAdapter);
    }

    void initToolbar() {
        Toolbar toolbarAddNote = findViewById(R.id.toolbarMainItem);
        toolbarAddNote.setTitle("Notes");
        toolbarAddNote.inflateMenu(R.menu.main_menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabItemMain:
                Intent addItemIntent = new Intent(this, AddItemActivity.class);
                startActivity(addItemIntent);
        }
    }

    @Override
    public void itemDeleteListener(Integer position) {
        //mItemViewModel.delete(listItems.get(position).id);
        Toast.makeText(this, mItemViewModel.getAllItem().getValue().get(position).getItemName() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemEditClicked(Integer position) {
        Intent updateItemIntent = new Intent(this, UpdateItemActivity.class);
        startActivity(updateItemIntent);
    }
}
