package com.example.suneh.sqlitelab7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

import android.view.View;
import android.view.ViewGroup;

import java.util.*;

/**
 * Created by suneh on 4/8/2018.
 */

public class ListAdapter extends ArrayAdapter<String> {

    private final Activity Context;

    private final java.util.List<Book> books;

    public ListAdapter(Activity context, List book) {

        super(context, R.layout.list, (java.util.List<String>) book ); this.Context = context;
        this.books = (java.util.List<Book>) book;


    }
    public View getView(int position, View view, ViewGroup parent) {

        int iconColor = android.graphics.Color.RED;
        LayoutInflater inflater = Context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.list, null, true);
        TextView ListViewid = (TextView) listview.findViewById(R.id.id);
        TextView ListViewItems = (TextView) listview.findViewById(R.id.title);
        TextView ListViewInfos = (TextView) listview.findViewById(R.id.author);

        ListViewid.setText(String.valueOf(books.get( position ).id));
        ListViewItems.setText(books.get( position ).title);
        ListViewInfos.setText(books.get( position ).author);


        if(books.get(position).id==0){



        }else if(books.get(position).id==1){
            ImageView ListViewImage = (ImageView) listview.findViewById(R.id.star1);
            ListViewImage.setColorFilter(Color.rgb(255, 0, 0));
        }else if(books.get(position).id==2){
            ImageView ListViewImage = (ImageView) listview.findViewById(R.id.star1);
            ListViewImage.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage2 = (ImageView) listview.findViewById(R.id.star2);
            ListViewImage2.setColorFilter(Color.rgb(255, 0, 0));

        }else if(books.get(position).id==3){
            ImageView ListViewImage = (ImageView) listview.findViewById(R.id.star1);
            ListViewImage.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage2 = (ImageView) listview.findViewById(R.id.star2);
            ListViewImage2.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage3 = (ImageView) listview.findViewById(R.id.star3);
            ListViewImage3.setColorFilter(Color.rgb(255, 0, 0));
        }else if(books.get(position).id==4){
            ImageView ListViewImage = (ImageView) listview.findViewById(R.id.star1);
            ListViewImage.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage2 = (ImageView) listview.findViewById(R.id.star2);
            ListViewImage2.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage3 = (ImageView) listview.findViewById(R.id.star3);
            ListViewImage3.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage4 = (ImageView) listview.findViewById(R.id.star4);
            ListViewImage4.setColorFilter(Color.rgb(255, 0, 0));
        }else if(books.get(position).id==5){
            ImageView ListViewImage = (ImageView) listview.findViewById(R.id.star1);
            ListViewImage.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage2 = (ImageView) listview.findViewById(R.id.star2);
            ListViewImage2.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage3 = (ImageView) listview.findViewById(R.id.star3);
            ListViewImage3.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage4 = (ImageView) listview.findViewById(R.id.star4);
            ListViewImage4.setColorFilter(Color.rgb(255, 0, 0));
            ImageView ListViewImage5 = (ImageView) listview.findViewById(R.id.star5);
            ListViewImage4.setColorFilter(Color.rgb(255, 0, 0));

        }
  return listview;
    };


}
