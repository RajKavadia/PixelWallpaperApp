package com.example.pixelwallpaperapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method.GET;

public class FIrstctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.rec);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        RequestQueue requestQueue = Volley.newRequestQueue(FIrstctivity.this);
        StringRequest stringRequest = new StringRequest(GET, "https://api.pexels.com/v1/curated?per_page=1000", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                CuratedImages curatedImages = gson.fromJson(response,CuratedImages.class);
                CuratedImagesAdapter adapter = new CuratedImagesAdapter(curatedImages,FIrstctivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers= new HashMap<String, String>();
                headers.put("Authorization","563492ad6f917000010000018a48454b8a0d42a4ad3b130d4c47c023");
                return headers;
            }
        };
        requestQueue.add(stringRequest);
        }

}