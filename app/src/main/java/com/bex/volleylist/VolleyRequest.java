package com.bex.volleylist;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

/**
 * Created by Robus on 7/21/2015.
 */
public class VolleyRequest {
    private static RequestQueue requestQueue;
    public static JSONArray jsonArrayResponse;
    public  static JsonArrayRequest jsonArrayRequest;

;

    public static JSONArray getJSONResponse(String url){

        requestQueue = MySingleton.getInstance().getRequestQueue();
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                jsonArrayResponse = response;
                Toast.makeText(MyApplicationContext.getAppContext(),response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonArrayRequest);

        return jsonArrayResponse;


    }


}
