package com.example.galuh.justjava;

public class ListItem {
    private int image;
    private String judul;
    private String harga;

    public ListItem(int image, String judul, String harga) {
        this.image = image;
        this.judul = judul;
        this.harga = harga;
    }
    public int getimage() {
        return image;
    }
    public void setimage(int image) {
        this.image = image;
    }
    public String getharga() {
        return harga;
    }
    public void setharga(String harga) {
        this.harga = harga;
    }
    public String getjudul() {
        return judul;
    }
    public void setjudul(String judul) {
        this.judul = judul;
    }
}
