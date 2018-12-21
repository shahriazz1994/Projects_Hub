package com.sm.shahriaz.smartmenu;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FoodListActivity extends AppCompatActivity {

    private static final String URL_DATA = "http://192.168.43.205:8000/api/Food%20List/?format=json";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listItems = new ArrayList<>();

        loadRecyclerViewData();

    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("fooddetails");

                            for(int i = 0; i<array.length();i++){
                                JSONObject object = array.getJSONObject(i);
                                ListItem item = new ListItem(
                                        object.getString("foodname"),
                                        object.getString("fooddetails"),
                                        object.getString("foodimage"),
                                        object.getString("armodel"),
                                        object.getString("fromcategory")
                                );
                                Bundle extras = getIntent().getExtras();
                                String CategoryId = null;
                                if (extras != null) {
                                    CategoryId = extras.getString("id");
                                }

                                if(Objects.equals(CategoryId,item.getFromcategory())) {
                                    listItems.add(item);
                                }
                                else {
                                    Toast.makeText(FoodListActivity.this, "Another index triggered", Toast.LENGTH_LONG).show();
                                }
                            }

                            adapter = new ListAdapter(listItems,getApplicationContext());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(FoodListActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}