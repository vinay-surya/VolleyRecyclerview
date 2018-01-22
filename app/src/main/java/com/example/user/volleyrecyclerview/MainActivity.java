package com.example.user.volleyrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String URL = "http://credibleminds.com/restretrive.php?";

    String ConsumerNAme, ConsumerGEnder, DealName, Comment;

    EditText edtCostumerId;
    String customerId;
    RecyclerView recyclerView;
    ArrayList FeedbackArrayList;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCostumerId = (EditText) findViewById(R.id.cusId);
        buttonRegister = (Button) findViewById(R.id.btn);
        recyclerView = (RecyclerView) findViewById(R.id.recy);

        buttonRegister.setOnClickListener(this);

    }

    private void registerUser() {

        customerId = edtCostumerId.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ResposneList(response);
                        Log.wtf("response", response);
                        Log.wtf("URL", URL);
                        //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        Log.wtf("ERR", error.toString());

                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("userId", customerId);
         /*       params.put(CusName, Cusname);
                params.put(phoneno, phonenoo);
                params.put(Doj, Dojj);
         */
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void onClick(View v) {
        if (v == buttonRegister) {
            registerUser();
        }
    }

    private void ResposneList(String results) {

        FeedbackArrayList = new ArrayList<>();
        if (results != null) {
            if (results == null || results.equals("")) {
                Toast.makeText(MainActivity.this, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                return;
            } else {

                try {
                    JSONObject reader = new JSONObject(results);
                    JSONArray deal = reader.getJSONArray("UserDetails");
                    for (int i = 0; i < deal.length(); i++) {
                        JSONObject location = deal.getJSONObject(i);


                        ConsumerNAme = location.getString("userName");
                        DealName = location.getString("userMobile");
                        ConsumerGEnder = location.getString("userEmail");
                        Comment = location.getString("userPassword");


                        //Add Loyalty List Group data to ArrayList
                        FeedbackArrayList.add(new ModuleClassfeedback(ConsumerNAme, ConsumerGEnder, Comment, DealName));

                        //Pass the parameters to the custom adapter LoyaltyListGroupAdapter
                        MyfeedbackAdapter adapter = new MyfeedbackAdapter(getApplicationContext(), FeedbackArrayList);


                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        //Set the adapter to the ListView
                        recyclerView.setAdapter(adapter);

                    }


                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
    }
}

