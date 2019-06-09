package com.example.fragmenttest;

import android.app.Activity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BoardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
    }

    private String SendByHttp(String msg) {

        if (msg == null)
            msg = "";

        String URL = "http://0.0.0.0:8080/MyServer/JSONServer.jsp";
        return null;
    }
}
