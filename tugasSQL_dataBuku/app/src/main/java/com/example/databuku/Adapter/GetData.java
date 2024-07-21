package com.example.databuku.Adapter;

public class GetData {

    String id = "";
    String judul = "";
    String penulis = "";
    String tahun = "";

    public GetData(String id, String judul, String penulis, String tahun) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
