package com.example.galuh.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListCoffeActivity extends AppCompatActivity {

    public static final String[] menu = new String[] { "Moccacino", "Coffe Latte",
            "Chocolate", "Sweet Tea", "Donut" };

    public static final String[] harga = new String[] {
            "50000",
            "32000", "25000",
            "15000","10000" };

    public static final Integer[] images = { R.drawable.moccacino,
            R.drawable.coffelatte, R.drawable.chocolate, R.drawable.tea, R.drawable.donut };

    ListView listView;
    List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coffe);

        listItems = new ArrayList<ListItem>();
        for (int i = 0; i < menu.length; i++) {
            ListItem item = new ListItem(images[i], menu[i], harga[i]);
            listItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        ListAdapter adapter = new ListAdapter(this, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListCoffeActivity.this,MainActivity.class);
                i.putExtra("JUDUL", menu);
                i.putExtra("HARGA", harga);
                i.putExtra("POSITION", position);
                startActivity(i);
            }
        });

    }
}
