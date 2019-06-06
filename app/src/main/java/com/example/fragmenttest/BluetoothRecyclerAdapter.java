package com.example.fragmenttest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fragmenttest.Fragment.Bluetooth;
import com.example.fragmenttest.vo.BluetoothVO;

import java.util.List;

public class BluetoothRecyclerAdapter extends RecyclerView.Adapter<BluetoothRecyclerAdapter.BluetoothViewHolder> {
    private List<BluetoothVO> bluetoothVOList;
    private Callback callback;

    public interface Callback {
        public void run(int position, BluetoothVO bluetoothVO);
    }
    public BluetoothRecyclerAdapter(List<BluetoothVO> bluetoothVOList, Callback callback) {
        this.bluetoothVOList = bluetoothVOList;
        this.callback = callback;
    }
    @NonNull
    @Override
    public BluetoothViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listviewltem, viewGroup, false);
        return new BluetoothViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BluetoothViewHolder bluetoothViewHolder, final int i) {
        bluetoothViewHolder.title.setText(bluetoothVOList.get(i).getTitle() + "gd");
        bluetoothViewHolder.author.setText(bluetoothVOList.get(i).getAuthor());
        bluetoothViewHolder.date.setText(bluetoothVOList.get(i).getDate());
        bluetoothViewHolder.count.setText(String.valueOf(bluetoothVOList.get(i).getCount()));
        bluetoothViewHolder.boardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.run(i, bluetoothVOList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return bluetoothVOList.size();
    }

    public class BluetoothViewHolder extends RecyclerView.ViewHolder {
        public TextView title, author, date, count;
        public LinearLayout boardItem;
        public BluetoothViewHolder(@NonNull View itemView) {
            super(itemView);
            boardItem = itemView.findViewById(R.id.layout_item_button);
            title = itemView.findViewById(R.id.textTitle);
            author = itemView.findViewById(R.id.text_author);
            date = itemView.findViewById(R.id.text_date);
            count = itemView.findViewById(R.id.text_count);
        }
    }
}
