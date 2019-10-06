package com.example.contactv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Contact> {

    private Context context; //what?
    private ArrayList<Contact> contacts;
    private int layoutResource; //trỏ đến layout muốn thêm vào view
    public CustomAdapter(Context context, int resource,ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.contacts=objects;
        this.layoutResource = resource;
    }
    @NonNull       //what?
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup){
        LayoutInflater inflater= LayoutInflater.from(context);
        view=inflater.inflate(layoutResource,null); //(xml) file chuyen doi qua view(java)
        TextView name = (TextView) view.findViewById(R.id.tv_namecontact);  //ánh xạ view và cập nhật dữ liệu của view
        name.setText(contacts.get(i).getName());
        return view;
    }
}