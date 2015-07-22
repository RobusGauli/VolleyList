package com.bex.volleylist;

import android.app.ProgressDialog;
import android.location.GpsStatus;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    RequestQueue requestQueue;
    JsonArrayRequest jsonArrayRequest;
    public static final String URL = "http://192.168.1.6/musicstore/webapi/albums";
    ListView listView;
    ArrayList<Album> albumList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        requestQueue = MySingleton.getInstance().getRequestQueue();
        jsonArrayRequest = new JsonArrayRequest(URL,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Album> list= new ArrayList<>();

                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject o = response.getJSONObject(i);
                        Album album = new Album(o.getInt("albumid"),o.getString("albumname"),o.getString("albumdescription"),o.getString("albumreleaseyear"),o.getString("albumphotofilename"));
                        list.add(album);
                        listView.setAdapter(new MyAdapter(MainActivity.this,list));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"coudltn fetch the data",Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);




    }


////    public List<Album> getAlbumList(){
////        List<Album> list = new ArrayList<>();
////        list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));
////        list.add(new Album(1,"he","come","there","you"));
////        return list;
////
//
//    }




}
