package com.example.haritmoolphunt.spannedgridlayouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.haritmoolphunt.spannedgridlayouttest.LayoutManager.SpannedGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageViewAdapter imageViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        SpannedGridLayoutManager manager = new SpannedGridLayoutManager(
                new SpannedGridLayoutManager.GridSpanLookup() {
                    @Override
                    public SpannedGridLayoutManager.SpanInfo getSpanInfo(int position) {
                        // Conditions for 2x2 items
                        if (position % 6 == 0 || position % 6 == 4) {
                            return new SpannedGridLayoutManager.SpanInfo(2, 2);
                        } else {
                            return new SpannedGridLayoutManager.SpanInfo(1, 1);
                        }
                    }
                },
                3, // number of columns
                1f // how big is default item
        );

        imageViewAdapter = new ImageViewAdapter();

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(imageViewAdapter);
        imageViewAdapter.notifyDataSetChanged();

    }
}
