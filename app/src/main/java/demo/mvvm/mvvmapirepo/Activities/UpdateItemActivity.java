package demo.mvvm.mvvmapirepo.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import demo.mvvm.mvvmapirepo.POJOClasses.Item;
import demo.mvvm.mvvmapirepo.R;
import demo.mvvm.mvvmapirepo.ViewModel.ItemViewModel;

public class UpdateItemActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = UpdateItemActivity.class.getSimpleName();

    TextInputEditText edtUpdateItemName, edtUpdateItemCode;
    TextInputLayout textInputLayoutUpdateItemName, textInputLayoutUpdateItemCode;
    ItemViewModel mItemViewModel;
    Button btnUpdateItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);
        initUI();
        initToolbar();

        //Initialize ViewModel
        mItemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
    }

    void initUI() {
        edtUpdateItemName = findViewById(R.id.edtUpdateItemName);
        edtUpdateItemCode = findViewById(R.id.edtUpdateItemCode);

        textInputLayoutUpdateItemName = findViewById(R.id.textInputLayoutUpdateItemName);
        textInputLayoutUpdateItemCode = findViewById(R.id.textInputLayoutUpdateItemCode);

        btnUpdateItem = findViewById(R.id.btnAddItem);

        //edtUpdateItemName.setText(mItemViewModel.getAllItem());

    }

    void initToolbar() {
        Toolbar toolbarAddNote = findViewById(R.id.toolbarUpdateItem);
        toolbarAddNote.setTitle("Add Note");
        toolbarAddNote.setNavigationIcon(R.drawable.ic_left_arrow);

        toolbarAddNote.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void updateItem() {

        String itemName = edtUpdateItemName.getText().toString();
        String itemCode = edtUpdateItemCode.getText().toString();

        if (itemName.trim().isEmpty() || itemCode.trim().isEmpty()) {
            textInputLayoutUpdateItemName.setError("Enter Item Name");
            textInputLayoutUpdateItemCode.setError("Enter Item Code");
            return;
        }

        //Adding all data to Database through ViewModel >> Repository >> Database
        //mItemViewModel.insert(new Item(itemName,    ));

        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.itemSaveNote:
                updateItem();

            default:
                return;
        }
    }
}
