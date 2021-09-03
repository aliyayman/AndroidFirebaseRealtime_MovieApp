package com.aliyayman.FilmlerAppFirebase;

import java.io.Serializable;

public class Filmler implements Serializable {
    private String film_id;
    private String film_ad;
    private int film_yil;
    private String film_resim;
    private String kategori_ad;
    private String yonetmen_ad;

    public Filmler() {
    }

    public Filmler(String film_id, String film_ad, int film_yil, String film_resim, String kategori_ad, String yonetmen_ad) {
        this.film_id = film_id;
        this.film_ad = film_ad;
        this.film_yil = film_yil;
        this.film_resim = film_resim;
        this.kategori_ad = kategori_ad;
        this.yonetmen_ad = yonetmen_ad;
    }

    public String getFilm_id() {
        return film_id;
    }

    public void setFilm_id(String film_id) {
        this.film_id = film_id;
    }

    public String getFilm_ad() {
        return film_ad;
    }

    public void setFilm_ad(String film_ad) {
        this.film_ad = film_ad;
    }

    public int getFilm_yil() {
        return film_yil;
    }

    public void setFilm_yil(int film_yil) {
        this.film_yil = film_yil;
    }

    public String getFilm_resim() {
        return film_resim;
    }

    public void setFilm_resim(String film_resim) {
        this.film_resim = film_resim;
    }

    public String getKategori_ad() {
        return kategori_ad;
    }

    public void setKategori_ad(String kategori_ad) {
        this.kategori_ad = kategori_ad;
    }

    public String getYonetmen_ad() {
        return yonetmen_ad;
    }

    public void setYonetmen_ad(String yonetmen_ad) {
        this.yonetmen_ad = yonetmen_ad;
    }
}
