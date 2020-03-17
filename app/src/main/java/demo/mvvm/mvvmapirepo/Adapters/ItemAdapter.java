package demo.mvvm.mvvmapirepo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import demo.mvvm.mvvmapirepo.ItemClickListener;
import demo.mvvm.mvvmapirepo.POJOClasses.Item;
import demo.mvvm.mvvmapirepo.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.NoteHolder> {
    private List<Item> itemList = new ArrayList<>();
    private ItemClickListener mItemClickListener;


    public ItemAdapter(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemNoteView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_adapter_view, parent, false);
        return new NoteHolder(itemNoteView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Item ObjItem = itemList.get(position);

        holder.txtItemName.setText(ObjItem.getItemName());
        holder.txtItemCode.setText(ObjItem.getItemCode());
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public Item deleteItem(Integer position) {
        return itemList.get(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView txtItemName, txtItemCode;
        private CardView cardViewNoteAdapter;
        private Button btnEditItem;

        NoteHolder(@NonNull View itemView) {
            super(itemView);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtItemCode = itemView.findViewById(R.id.txtItemCode);
            cardViewNoteAdapter = itemView.findViewById(R.id.cardViewNoteAdapter);
            btnEditItem = itemView.findViewById(R.id.btnEditItem);

            cardViewNoteAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.itemDeleteListener(getAdapterPosition());
                }
            });

            btnEditItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.itemEditClicked(getAdapterPosition());
                }
            });

        }
    }
}
