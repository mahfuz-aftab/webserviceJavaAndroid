package com.example.webserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.BreakIterator;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

   TextView textView;
   Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.Button);
    }

    public void onClick(View view) {

        String url = "https://jsonplaceholder.typicode.com/posts/1";//URL USED
        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str= new String(responseBody);
            textView.setText(str);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                textView.setText("Error in calling api");
            }
        });
    }
}