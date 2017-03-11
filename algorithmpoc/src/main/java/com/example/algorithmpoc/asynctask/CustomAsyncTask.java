package com.example.algorithmpoc.asynctask;

import android.os.AsyncTask;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Cyho on 19/02/2017.
 */

public class CustomAsyncTask extends AsyncTask<String, String, String> {
    private final ICallback callback;

    public CustomAsyncTask (ICallback callback)  {
        this.callback =  callback;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        //blah blah blah
        OkHttpClient client= new OkHttpClient();

        String body ="";

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), body);

        Request request1 = new Request.Builder().url("").post(requestBody).build();
        Request request2 = new Request.Builder().url("").get().build();


        try {
            Response response = client.newCall(request2).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            response.body().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        callback.onCallback(result);
    }
}
