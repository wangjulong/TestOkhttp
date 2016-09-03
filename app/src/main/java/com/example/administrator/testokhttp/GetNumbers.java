package com.example.administrator.testokhttp;


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/3.
 */

class GetNumbers {
    private OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
//            byte[] b = response.body().bytes();
//            return new String(b, "GBK");
        }
        return null;
    }
}
