package com.example.emili.udacity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by emili on 18/07/2017.
 */

class RequestContact {
    Context context;
    RequestContact(Context context){
        this.context = context;

    }


    public void makeVolleyRequest(final List<Contact> contactList, final RecyclerView recyclerView, final String url){

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        //int socketTimeout = 60000;//30 seconds - change to what you want

        //RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {

                handleResponse(context,contactList, recyclerView, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);


    }

    private void handleResponse(Context context, List<Contact> contactList, RecyclerView recyclerView, String response) {

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
            ContactAdapter contactAdapter = new ContactAdapter(context, contactList);
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
}