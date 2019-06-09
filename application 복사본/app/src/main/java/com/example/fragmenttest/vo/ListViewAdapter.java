package com.example.fragmenttest.vo;

/**
 * Created by wjdal on 2018-07-05.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fragmenttest.Fragment.Bluetooth;
import com.example.fragmenttest.R;

import java.util.ArrayList;

import com.example.fragmenttest.R;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<BluetoothVO> bluetoothVOS = new ArrayList<BluetoothVO>();

    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return bluetoothVOS.size();
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView state = (TextView) convertView.findViewById(R.id.state);
        BluetoothVO listViewItem = bluetoothVOS.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        state.setText(listViewItem.getTitle());

        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return bluetoothVOS.get(position);
    }

    // 데이터값 넣어줌
    public void addVO(String items) {
        BluetoothVO item = new BluetoothVO();
        item.setTitle(items);
        bluetoothVOS.add(item);
    }
}