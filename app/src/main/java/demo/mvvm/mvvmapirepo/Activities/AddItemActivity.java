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

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = AddItemActivity.class.getSimpleName();

    TextInputEditText edtAddItemName, edtAddItemCode;
    TextInputLayout textInputLayoutTitle, textInputLayoutDescription;
    ItemViewModel mItemViewModel;
    Button btnAddItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        initUI();
        initToolbar();

        //Initialize ViewModel
        mItemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
    }

    void initUI() {
        edtAddItemName = findViewById(R.id.edtAddItemName);
        edtAddItemCode = findViewById(R.id.edtAddItemCode);

        textInputLayoutTitle = findViewById(R.id.textInputLayoutItemName);
        textInputLayoutDescription= findViewById(R.id.textInputLayoutItemCode);

        btnAddItem= findViewById(R.id.btnAddItem);
    }

    void initToolbar() {
        Toolbar toolbarAddNote = findViewById(R.id.toolbarAddItem);
        toolbarAddNote.setTitle("Add Note");
        toolbarAddNote.setNavigationIcon(R.drawable.ic_left_arrow);

        toolbarAddNote.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void saveNote() {

        String itemName = edtAddItemName.getText().toString();
        String itemCode = edtAddItemCode.getText().toString();

        if (itemName.trim().isEmpty() || itemCode.trim().isEmpty()) {
            textInputLayoutTitle.setError("Enter Item Name");
            textInputLayoutDescription.setError("Enter Item Code");
            return;
        }

        //Adding all data to Database through ViewModel >> Repository >> Database
        mItemViewModel.insert(new Item(itemName, itemCode));

        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.itemSaveNote:
                saveNote();

            default:
                return;
        }
    }
}
