package com.example.administrator.testokhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateKJH(View view) {

        MyAsynctask task = new MyAsynctask();
        task.execute("http://www.baidu.com");
    }


    public class MyAsynctask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String url = params[0];
            GetNumbers getNumbers = new GetNumbers();
            try {
                return getNumbers.run(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            textView = (TextView) findViewById(R.id.textView);
            if (textView != null) {
                textView.setText(s);
            }
        }
    }
}

