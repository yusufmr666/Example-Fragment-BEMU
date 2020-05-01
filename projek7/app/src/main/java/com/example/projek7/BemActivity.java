package com.example.projek7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import dataadapter.Bem;
import dataadapter.BemData;
import dataadapter.GridAdapter;

public class BemActivity extends AppCompatActivity {
    RecyclerView rvGrid;
    ArrayList<Bem> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem);

        rvGrid = findViewById(R.id.rv_Grid);
        list.addAll(BemData.getListData());
        showGridView();
    }

    private void showGridView() {
        rvGrid.setLayoutManager(new GridLayoutManager(getApplicationContext() ,2));
        GridAdapter gridMovieAdapter = new GridAdapter(list);
        rvGrid.setAdapter(gridMovieAdapter);

        gridMovieAdapter.setOnItemClickCallback(new GridAdapter.OnItemClickCallback() {
            public void onItemClicked (Bem bem) {
                Toast.makeText(getApplicationContext(), "Kamu memilih " + bem.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
