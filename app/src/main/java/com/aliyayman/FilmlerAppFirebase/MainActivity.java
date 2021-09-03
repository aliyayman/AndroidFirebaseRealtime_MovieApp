package com.aliyayman.FilmlerAppFirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rvkategori;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        rvkategori=findViewById(R.id.rvkategori);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("kategoriler");


        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        rvkategori.setHasFixedSize(true);
        rvkategori.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList=new ArrayList<>();
        adapter=new KategoriAdapter(MainActivity.this,kategorilerArrayList);
        rvkategori.setAdapter(adapter);
        tumKategoriler();


    }
    public void tumKategoriler(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                kategorilerArrayList.clear();
                for(DataSnapshot d:snapshot.getChildren() ){
                    Kategoriler kategori=d.getValue(Kategoriler.class);
                    kategori.setKategori_id(d.getKey());

                    kategorilerArrayList.add(kategori);


                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}