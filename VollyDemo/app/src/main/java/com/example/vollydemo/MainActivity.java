package com.example.vollydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest JSONObjectRequest = new JSONObject(Request.Method.GET , "https://jsonplaceholder.typicode.com/todos/1" , null ,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("myapp","the response is " + response.getString("title"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }               *** // ************************something is error in this program************
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
            Log.d("myapp","something went wrong");
            }
        });
         requestQueue.add(JSONobjectRequest);
    }
}