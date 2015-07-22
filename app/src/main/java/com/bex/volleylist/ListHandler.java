package com.bex.volleylist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robus on 7/20/2015.
 */
public class ListHandler  {

    public static List<Album> getList(JSONArray jsonArray){
            ArrayList<Album> list = new ArrayList<>();
        if(jsonArray != null){
           for (int i = 0;i<jsonArray.length();i++){
               try {
                   JSONObject o = jsonArray.getJSONObject(i);
                   Album album = new Album(o.getInt("albumid"),o.getString("albumname"),o.getString("albumdescription"),o.getString("albumreleaseyear"),o.getString("albumphotofilename"));
                   list.add(album);


               } catch (JSONException e) {
                   e.printStackTrace();
               }


            }
        }


        return list;
    }



}
