package com.example.galuh.justjava;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btntambah;
    private Button btnkurang;
    private Button btnhitung;
    private Button btnpesan;

    private TextView harga;
    private TextView kalkulasiawal;
    private TextView Total;
    private TextView judul;

    private EditText name;

    private CheckBox chckboxsusu;

    int kalkulasi = 0;
    String[] menu;
    String[] hargamenu;
    int position;

    String hargakopi;
    int harganya;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        menu = i.getStringArrayExtra("JUDUL");
        hargamenu = i.getStringArrayExtra("HARGA");
        position = i.getExtras().getInt("POSITION");

        btntambah = (Button) findViewById(R.id.btntambah);
        btnkurang = (Button) findViewById(R.id.btnkurang);
        btnhitung = (Button) findViewById(R.id.btnhitung);
        btnpesan = (Button) findViewById(R.id.btnpesan);

        name = (EditText) findViewById(R.id.name);

        chckboxsusu = (CheckBox) findViewById(R.id.chckboxsusu);

        harga = (TextView) findViewById(R.id.harga);
        kalkulasiawal = (TextView) findViewById(R.id.kalkulasiawal);
        Total = (TextView) findViewById(R.id.total);

        harga = (TextView) findViewById(R.id.harga);
        judul = (TextView) findViewById(R.id.judul);

        judul.setText(menu[position]);
        harga.setText(hargamenu[position]);

        hargakopi = hargamenu[position].toString();
        harganya = Integer.parseInt(hargakopi);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    tambahKalkulasi(kalkulasi);
                    Hasil(kalkulasi);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    kurangKalkulasi(kalkulasi);
                    Hasil(kalkulasi);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung(harganya);
                Total(harganya);
            }
        });

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total > 0 && name.getText().toString().length() > 0){
                    String nameuser = name.getText().toString();
                    String judulmenu = menu[position];
                    String ordertext = "Hi "+nameuser+", Your Order is :<br>Menu : "+judulmenu+"<br>Harga : Rp."+total+"<br>Thanks for order!";
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/hmtl");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "ghalpris.rs@gmail.com"  });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "[Your Order] Galuh Coffe");
                    intent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(ordertext));
                    startActivity(Intent.createChooser(intent, "Send Email"));
                }else{
                    if (name.getText().toString().equals("")){
                        name.setError("Masukan Nama Anda");
                    }else{
                        Toast.makeText(getApplicationContext(), "Mohon Tambahkan Jumlah pesanan Anda", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void tambahKalkulasi(int number) {
        kalkulasi = kalkulasi + 1;
    }

    private void kurangKalkulasi(int number) {
        kalkulasi = kalkulasi - 1;
    }

    private void hitung(int number) {total = kalkulasi * harganya;}

    private void Hasil (int number) {kalkulasiawal.setText("" + number);}

    private void Total(int number) {
        Total.setText("Total Harga : Rp." + number);

        if (chckboxsusu.isChecked() == true){
            total = 3000 + total;
            Total.setText("Total Harga : Rp." + total);
        }
        else{
            Total.setText("Total Harga : Rp." + total);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
