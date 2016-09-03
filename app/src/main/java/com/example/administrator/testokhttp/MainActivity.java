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
        String strUrl = "http://chart.cp.360.cn/zst/ln11/?span=100";
//        String strUrl = "http://www.52cp.cn/bull/index.php/Index/list_ln11";
//        String strUrl = "http:////zs.cailele.com//ln11x5//baseTrend.php?t=100";
//        String strUrl = "http://trend.caipiao.163.com/ln11xuan5/?periodNumber=100";

        task.execute(strUrl);
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

            //s 网页内容
//            String sep = "<td class='tdbg_1'>";
//            String[] str = s.split(sep);

            System.out.print(s);

        }
    }
}

