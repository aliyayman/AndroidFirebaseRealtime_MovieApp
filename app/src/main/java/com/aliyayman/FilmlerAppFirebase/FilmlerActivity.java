package com.aliyayman.FilmlerAppFirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private RecyclerView rvfilmler;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    private Kategoriler kategori;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);
        toolbar2=findViewById(R.id.toolbar2);
        rvfilmler=findViewById(R.id.rvfilmler);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("filmler");



        kategori= (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

        toolbar2.setTitle(kategori.getKategori_ad());
        setSupportActionBar(toolbar2);




        rvfilmler.setHasFixedSize(true);
        rvfilmler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        filmlerArrayList=new ArrayList<>();
        adapter=new FilmlerAdapter(FilmlerActivity.this,filmlerArrayList);
        rvfilmler.setAdapter(adapter);
        filmGetirByKategoriAd();



    }
    public void filmGetirByKategoriAd(){

        Query query=myRef.orderByChild("kategori_ad").equalTo(kategori.getKategori_ad());

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                filmlerArrayList.clear();
                for(DataSnapshot d:snapshot.getChildren() ){
                    Filmler film=d.getValue(Filmler.class);
                    film.setFilm_id(d.getKey());

                    filmlerArrayList.add(film);


                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    }
