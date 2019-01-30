package com.octet.qbit.wallpaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
import java.util.List;
import adapters.WallpaperAdapter;

public class WallpaperActivity extends AppCompatActivity {

    private List<Wallpaper> wallpaperList;
    private RecyclerView recyclerView;
    private WallpaperAdapter adapter;

    private DatabaseReference dbRef;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        wallpaperList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WallpaperAdapter(this, wallpaperList);

        progressBar= findViewById(R.id.progressbar);

        Intent intent = getIntent();
        String cat = intent.getStringExtra("category");
    }
}

