package com.example.fragmenttest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmenttest.Connection.Connection;
import com.example.fragmenttest.vo.CommentList;
import com.example.fragmenttest.vo.CommentListViewAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {
    TextView name, context, comment_et, context_time;
    ListView comment_view;
    Button comment_btn;
    Connection connection;
    Connection input_comment;
    String real_context;
    String time;
    String viewed;
    int id_index;
    JsonObject jsonObject;
    JsonObject resultObject;

    CommentListViewAdapter adapter;
    ArrayList<CommentList> comment_list = new ArrayList<CommentList>();
    JSONArray contentList;
    JSONObject object;
    Object result_comment;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        comment_view = (ListView) findViewById(R.id.comment_lv);

        jsonObject = new JsonObject();
        JsonObject resultObject = null;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Intent intent = getIntent();
        id_index = intent.getExtras().getInt("id");

        name = (TextView) findViewById(R.id.title);
        context = (TextView) findViewById(R.id.context);
        comment_et = (TextView) findViewById(R.id.comment_et);
        comment_btn = (Button) findViewById(R.id.comment_btn);
        context_time = (TextView) findViewById(R.id.context_time);
        comment_btn.setOnClickListener(this);

        Log.e("게시글 보기", String.valueOf(id_index));


    }

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (requestCode == 1) {
//            if(resultCode == Activity.RESULT_OK){
//            }
//            if (resultCode == Activity.RESULT_CANCELED) {
//                getPosts();
//            }
//        }
//    }//onActivityResult
    @Override
    protected void onResume() {
        getPosts();
        getComments();
        super.onResume();
    }

    public void getComments(){
        try {
            object = new JSONObject(result_comment.toString());
            contentList = object.getJSONArray("content");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        comment_list.clear();
        for (int i = 0; i < contentList.length(); i++) {
            JSONObject test = null;
            try {
                test = contentList.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                String a = test.getString("contents");
                String c = test.getString("timeCreated");

                String[] d = new String[]{a, c};
                comment_list.add(new CommentList(d));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        adapter = new CommentListViewAdapter(PostActivity.this, comment_list);
        comment_view.setAdapter(adapter);
    }
    public void getPosts(){
        try {
            Gson gson = new Gson();
            connection = new Connection();

            // 게시글 내용 받아오기
            String result = (String) connection.execute(jsonObject, "article/" + id_index, "GET", null).get();
            JsonElement jsonElement = gson.fromJson(result, JsonElement.class);
            resultObject = jsonElement.getAsJsonObject();
            String post_context = resultObject.get("text").toString().replace("\\n", "\n");
            real_context = post_context.substring(1, post_context.length() - 1);
            time = resultObject.get("timeCreated").toString().substring(1, resultObject.get("timeCreated").toString().length() - 6);
            viewed = resultObject.get("viewed").toString();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.comment_btn:
                String comment = comment_et.getText().toString();
                JsonObject jsonObject = new JsonObject();
                input_comment = new Connection();

                jsonObject.addProperty("contents", comment);
                jsonObject.addProperty("articleId", id_index);
                jsonObject.addProperty("title", "abc");

                comment_et.setText("");
                onResume();
                Toast.makeText(this, comment, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
