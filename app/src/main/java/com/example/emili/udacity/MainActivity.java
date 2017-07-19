package com.example.emili.udacity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button next;
    Context context;
    List<Contact> contactList;
    RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    RecyclerView.LayoutManager layoutManager;
    String url = "https://api.androidhive.info/contacts/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // QuakeAsyncTask task = new QuakeAsyncTask();
        //task.execute(url);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //contactAdapter = new ContactAdapter(getApplicationContext(), list);
       // recyclerView.setAdapter(contactAdapter);
        contactList = new ArrayList<Contact>();
        //makeVolleyRequest(url);


        //MyRequest mr = new MyRequest(MainActivity.this);
        //mr.makeVolleyRequest(url);

//TODO 1er facon de faire avec la class RequestContact

        RequestContact requestContact = new RequestContact(MainActivity.this);
        requestContact.makeVolleyRequest(contactList, recyclerView, url);

        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
/*
//TODO 2 facon de faire
    private class QuakeAsyncTask extends AsyncTask<String,Void,List<Contact>>{

        @Override
        protected List<Contact> doInBackground(String... strings) {
            List<Contact> result = VolleyRequest.fetchContactData(url);
            return result;
        }

        @Override
        protected void onPostExecute(List<Contact> data) {
            txt.setText(String.valueOf(data.size()));

            if (data != null && !data.isEmpty()){
                contactAdapter.ajouterTous(data);
            }
        }
    }*/
/*

//TODO 3ème facon de faire


    class MyRequest{
        Context context;
        MyRequest(Context context){
            this.context = context;

        }

        public void makeVolleyRequest(String url){

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            //int socketTimeout = 60000;//30 seconds - change to what you want

            //RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


                @Override
                public void onResponse(String response) {

                    handleResponse(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            requestQueue.add(stringRequest);


        }

        private void handleResponse(String response) {

            try {
                JSONObject mainObject = new JSONObject(response);
                JSONArray contacts = mainObject.getJSONArray("contacts");

                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject contact = contacts.getJSONObject(i);
                    String nom = contact.getString("name");
                    String email = contact.getString("email");
                    String genre = contact.getString("gender");
                    Contact contactSolo = new Contact(nom, email, genre);
                    contactList.add(contactSolo);
                }
                contactAdapter = new ContactAdapter(getApplicationContext(), contactList);
                recyclerView.setAdapter(contactAdapter);

                // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
                // build up a list of Earthquake objects with the corresponding data.

            } catch (JSONException e) {
                // If an error is thrown when executing any of the above statements in the "try" block,
                // catch the exception here, so the app doesn't crash. Print a log message
                // with the message from the exception.
                Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
            }

        }
    }*/

}

