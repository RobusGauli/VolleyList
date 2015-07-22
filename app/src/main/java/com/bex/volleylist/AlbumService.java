package com.bex.volleylist;

import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


public class AlbumService {
    JSONArray jsonArray;
    List<Album> albumList;
    public static final String URL = "http://192.168.1.6/musicstore/webapi/albums";
    public  List<Album> getAlbumList(){
        albumList = new ArrayList<>();

        jsonArray = VolleyRequest.getJSONResponse(URL);


        albumList = JsonParser.parseJsonResponse(jsonArray);
        return albumList;


    }
}
