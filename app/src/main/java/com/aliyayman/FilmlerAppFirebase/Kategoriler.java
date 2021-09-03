package com.aliyayman.FilmlerAppFirebase;

import java.io.Serializable;

public class Kategoriler implements Serializable {
    private String kategori_id;
    private String kategori_ad;

    public Kategoriler() {
    }

    public Kategoriler(String kategori_id, String kategori_ad) {
        this.kategori_id = kategori_id;
        this.kategori_ad = kategori_ad;
    }

    public String getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(String kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKategori_ad() {
        return kategori_ad;
    }

    public void setKategori_ad(String kategori_ad) {
        this.kategori_ad = kategori_ad;
    }
}
