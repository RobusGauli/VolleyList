package com.bex.volleylist;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Robus on 7/21/2015.
 */
public class JsonParser {

    static ArrayList<Album> albumList;
    public static ArrayList<Album> parseJsonResponse(JSONArray response) {

         albumList = new ArrayList<>();
        if (response != null && response.length() > 0) {

            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    Album album = new Album(jsonObject.getInt("albumid"), jsonObject.getString("albumname"), jsonObject.getString("albumdescription"), jsonObject.getString("albumreleaseyear"), jsonObject.getString("albumphotofilename"));
                    albumList.add(album);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }

        return albumList;


    }
}
