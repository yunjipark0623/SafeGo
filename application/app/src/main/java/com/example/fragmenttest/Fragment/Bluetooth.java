package com.example.fragmenttest.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fragmenttest.BluetoothRecyclerAdapter;
import com.example.fragmenttest.BoardActivity;
import com.example.fragmenttest.R;
import com.example.fragmenttest.vo.BluetoothVO;

import java.util.ArrayList;
import java.util.List;



public class Bluetooth extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_bluetooth,container,false);

        Button button = (Button) rootView.findViewById(R.id.community);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://192.168.0.218:8080/board")));
                startActivity(myIntent);
            }
        });

        return rootView;
    }



}
