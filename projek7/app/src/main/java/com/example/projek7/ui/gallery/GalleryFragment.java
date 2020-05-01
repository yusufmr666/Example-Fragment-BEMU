package com.example.projek7.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projek7.R;

import java.util.ArrayList;

import dataadapter.Bem;
import dataadapter.BemData;
import dataadapter.CardViewAdapter;
import dataadapter.GridAdapter;

public class GalleryFragment extends Fragment {
    private RecyclerView rvGrid;
    private ArrayList<Bem> list = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvGrid = view.findViewById(R.id.rv_gallery);
        list.addAll(BemData.getListData());
        showGrid();
    }

    private void showGrid() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvGrid.setLayoutManager(layoutManager);
       CardViewAdapter cardviewAdapter = new CardViewAdapter(list);
        rvGrid.setAdapter(cardviewAdapter);
    }

}
