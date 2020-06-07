package com.example.postapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<dathang> listdh;
    Button btnclickme;
    TextView txtJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnclickme=findViewById(R.id.btn_clickme);
        txtJson=findViewById(R.id.txtjson);
        listdh=new ArrayList<>();
        dathang dh1=new dathang(1,1,5,1000,1000);
        dathang dh2=new dathang(1,1,5,999,999);
        listdh.add(dh1);
        listdh.add(dh2);
        btnclickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new postCTToServer().execute("http://localhost:8080/api/dathangchitiet1");
                new getURL().execute("http://35.198.237.116/coffeshop/api/hoadons");
            }
        });

    }
    class postCTToServer extends AsyncTask<String,Void,String>
    {
        OkHttpClient client=new OkHttpClient.Builder().build();
        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            Log.d("AAA","Tạo thanh công");
            ObjectMapper objectMapper = new ObjectMapper();
            String json;
            //json=objectMapper.writeValueAsString();
            //RequestBody body = RequestBody.create(mediaType, "{\r\n\t\t\t\"idhoadon\": "+idhd+",\r\n            \"idmathang\": "+idhangcart+",\r\n            \"soluong\":"+ soluongcart+",\r\n            \"giatienhientai\": "+giagiahientaicart+",\r\n            \"thanhtien\": "+thanhtiencart+"\r\n}");
            json=new Gson().toJson(listdh);
            //RequestBody body = RequestBody.create(mediaType,json);
            RequestBody body = RequestBody.create(mediaType, "[{\r\n\t\t\t\"idhoadon\": 1,\r\n            \"idmathang\": 10,\r\n            \"soluong\": 1,\r\n            \"giatienhientai\": 9999,\r\n            \"thanhtien\": 9999\r\n},\r\n{\r\n\t\t\"idhoadon\": 1,\r\n            \"idmathang\": 11,\r\n            \"soluong\": 1,\r\n            \"giatienhientai\": 9999,\r\n            \"thanhtien\": 9999\r\n}\r\n\r\n]");
            Request request = new Request.Builder()
                    .url("http://localhost:8080/api/dathangchitiet1")
                    .method("POST", body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return  response.body().string();
            } catch (IOException ex) {
                ex.printStackTrace();
            }




            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            txtJson.setText(s);
            super.onPostExecute(s);
        }
    }
    class getURL extends AsyncTask<String,Void,String>
    {
        OkHttpClient client=new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        @Override
        protected String doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);
            Request request=builder.build();
            try {
                Response response= client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if(!s.equals(""))
            {
                txtJson.setText(s);

            }

            super.onPostExecute(s);
        }
    }

}


