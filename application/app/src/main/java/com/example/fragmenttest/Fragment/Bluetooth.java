package com.example.fragmenttest.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.fragmenttest.BluetoothRecyclerAdapter;
import com.example.fragmenttest.BoardActivity;
import com.example.fragmenttest.R;
import com.example.fragmenttest.Write;
import com.example.fragmenttest.vo.BluetoothVO;

import java.util.ArrayList;
import java.util.List;



public class Bluetooth extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bluetooth, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        List<BluetoothVO> bluetoothVOList = new ArrayList<>();

        Button button = (Button)view.findViewById(R.id.Wirte); /*페이지 전환버튼*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Write.class);
                startActivity(intent);//액티비티 띄우기
            }
        });

        for(int i = 0; i < 5; i++) {
            BluetoothVO bluetoothVO = new BluetoothVO();
            bluetoothVO.setTitle("ㅎㅇ" + i);
            bluetoothVO.setDate("2016년");
            bluetoothVOList.add(bluetoothVO);
        }

        // 어댑터를 만들어줘
        BluetoothRecyclerAdapter bluetoothRecyclerAdapter = new BluetoothRecyclerAdapter(bluetoothVOList, new BluetoothRecyclerAdapter.Callback() {
            @Override
            public void run(int position, BluetoothVO bluetoothVO) {
                Intent intent = new Intent(getContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

        // 나열되는 방향? 가튼거 예를들면 수평으로 나열 수직으로 나열이나 그런걸 결정하는거
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // 어댑터를 바인딩합니다.
        recyclerView.setAdapter(bluetoothRecyclerAdapter);
        return view;


    }



}
