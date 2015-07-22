package com.bex.volleylist;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Robus on 7/20/2015.
 */
public class AlbumUtil {

    public static ArrayList<Album> loadAlbums(RequestQueue requestQueue){


        JSONArray response = Requester.getAlbumJsonResponse(requestQueue,Endpoints.getAlbumUrl());
        ArrayList<Album> albumArrayList = Parser.parseJsonRespose(response);
        return albumArrayList;

    }

    /*public static ArrayList<Movie> loadBoxOfficeMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.sendRequestBoxOfficeMovies(requestQueue, Endpoints.getRequestUrl(30));
        ArrayList<Movie> listMovies = Parser.parseJSONResponse(response);
        MyApplication.getWritableDatabase().insertMoviesBoxOffice(listMovies, true);
        return listMovies;
    }*/
}


