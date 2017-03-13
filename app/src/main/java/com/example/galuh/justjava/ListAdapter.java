package com.example.galuh.justjava;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    Context context;
    List<ListItem> listItem;

    public ListAdapter(Context context, List<ListItem> items) {
        this.context = context;
        this.listItem = items;
    }
    
    private class ViewHolder {
        ImageView imageView;
        TextView judul;
        TextView harga;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.harga = (TextView) convertView.findViewById(R.id.harga);
            holder.judul = (TextView) convertView.findViewById(R.id.judul);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListItem listItems = (ListItem) getItem(position);

        holder.harga.setText("Harga : "+listItems.getharga());
        holder.judul.setText(listItems.getjudul());
        holder.imageView.setImageResource(listItems.getimage());

        return convertView;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listItem.indexOf(getItem(position));
    }
}
