package com.bex.volleylist;

import android.app.DownloadManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Robus on 7/20/2015.
 */
public class Requester {

    public static JSONArray getAlbumJsonResponse( RequestQueue requestQueue,String url){
        JSONArray jsonArray = null;
        RequestFuture<JSONArray> requestFuture = RequestFuture.newFuture();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url,
                null,requestFuture);

                requestQueue.add(request);

            try {
                jsonArray = requestFuture.get(30000,TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }



         return  jsonArray;
    }
}


/*

    public static JSONObject sendRequestBoxOfficeMovies(RequestQueue requestQueue, String url) {
        JSONObject response = null;
        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url,
                null, requestFuture, requestFuture);

        requestQueue.add(request);
        try {
            response = requestFuture.get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            L.m(e + "");
        } catch (ExecutionException e) {
            L.m(e + "");
        } catch (TimeoutException e) {
            L.m(e + "");
        }
        return response;
    }*/
