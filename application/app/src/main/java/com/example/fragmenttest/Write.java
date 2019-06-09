package com.example.fragmenttest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Write extends AppCompatActivity {

    EditText title;
    EditText content;
    Button write;
    Button btn_to_client;
//    TextView result;
    TextView tv_json;
    TextView tv_parsing;
    StringBuffer sb = new StringBuffer();
    ArrayList<String> titleList = new ArrayList<>();
    ArrayList<String> contentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);

        title = (EditText) findViewById(R.id.edit_title);
        content = (EditText) findViewById(R.id.edit_text);
        write = (Button) findViewById(R.id.write_btn);
        btn_to_client = (Button) findViewById(R.id.btn_to_client);
        tv_json = (TextView) findViewById(R.id.tv);
        tv_parsing = (TextView) findViewById(R.id.tv_parsing);

        write.setOnClickListener(myClickListener);
        btn_to_client.setOnClickListener(myClickListener);
    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.write_btn:
                    write();
                    String startJson = "[";
                    String endJson = "]";

                    if (!sb.toString().equals("")) {
                        sb.append(",");
                    }
                    String temp = "{\"title\"" + ":" + "\"" + title.getText().toString() + "\"" + ","
                            + "\"content\"" + ":" + "\"" + content.getText().toString() + "\"" + "}";
                    sb.append(temp);
                    tv_json.setText(startJson + sb + endJson);
                    break;

                case R.id.btn_to_client:
                    try {
                        JSONArray jsonArray = new JSONArray(tv_json.getText().toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            titleList.add(jsonObject.getString("title"));
                            contentList.add(jsonObject.getString("content"));
                        }
                        tv_parsing.setText("" + titleList + "\n" + "" + contentList);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };

    private void write() {
        String titleString = title.getText().toString();
        String contentString = content.getText().toString();
        new WriteTask(titleString, contentString).execute();

    }

    public class WriteTask extends AsyncTask<Void, Void, Void> {
        private final String url;
        private String title, content;

        public WriteTask(String title, String content) {
            this.url = "http://172.19.15.10:8080/content";
            this.title = title;
            this.content = content;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Charset", "UTF-8");
                connection.setDoInput(false);
                connection.setDoOutput(true);
                connection.setUseCaches(false);


                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", title);
                jsonObject.put("content", content);
                System.out.println(jsonObject.toString());
                OutputStream os = connection.getOutputStream();
                os.write(jsonObject.toString().getBytes("UTF-8"));
                os.flush();
                os.close();

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
