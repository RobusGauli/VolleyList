package com.bex.volleylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by Robus on 7/20/2015.
 */
public class MyAdapter extends BaseAdapter {

    ImageLoader imageLoader;

    Context context;
    List<Album> list;
    public MyAdapter(Context context,List<Album> list){
        this.context = context;
        this.list = list;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             view = inflater.inflate(R.layout.album_row, parent, false);
        }
        NetworkImageView albumImage = (NetworkImageView)view.findViewById(R.id.album_image);
        TextView albumName = (TextView)view.findViewById(R.id.album_name);
        TextView artistName = (TextView)view.findViewById(R.id.artist_name);


        Album album = list.get(position);

        String imageUrl = album.getAlbumPhotoFileName();

        albumName.setText(album.getAlbumName());
        artistName.setText(album.getAlbumReleaseYear());
        imageLoader = MySingleton.getInstance().getImageLoader();
        albumImage.setImageUrl(imageUrl,imageLoader);
        return view;

    }
}
