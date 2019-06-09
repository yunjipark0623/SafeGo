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

import com.example.fragmenttest.R;

import java.util.ArrayList;

import com.example.fragmenttest.R;

public class CommentListViewAdapter extends BaseAdapter {

    public CommentListViewAdapter(Context context, ArrayList<CommentList> comment_list) {
        this.context = context;
        this.comment_list = comment_list;
    }

    private Context context;
    private ArrayList<CommentList> comment_list;

    private TextView contents;
    private TextView time;


    @Override
    public int getCount() {
        return comment_list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.comment_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item,null);
            contents = (TextView)convertView.findViewById(R.id.comment_tv);
            time = (TextView)convertView.findViewById(R.id.time_tv);
        }

        contents.setText(comment_list.get(position).getContents());
        time.setText(comment_list.get(position).getTime());
        return convertView;
    }
}