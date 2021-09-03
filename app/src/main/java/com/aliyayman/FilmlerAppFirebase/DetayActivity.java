package com.aliyayman.FilmlerAppFirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetayActivity extends AppCompatActivity {
    private ImageView imageViewResim;
    private TextView textViewFilmAd;
    private TextView textViewYil;
    private TextView textViewYonetmen;

    private Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        imageViewResim=findViewById(R.id.imageViewResim);
        textViewFilmAd=findViewById(R.id.textViewFilmAd);
        textViewYil=findViewById(R.id.textViewYil);
        textViewYonetmen=findViewById(R.id.textViewYonetmen);

        film = (Filmler) getIntent().getSerializableExtra("nesne");

        textViewFilmAd.setText(film.getFilm_ad());
        textViewYil.setText(String.valueOf(film.getFilm_yil()));
        textViewYonetmen.setText(film.getYonetmen_ad());

        String url="http://www.byrmkus.tk/filmler/resimler/"+film.getFilm_resim();
        Picasso.get().load(url) .resize(400,600).into(imageViewResim);


    }
}