package com.example.projek7.ui.Grid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projek7.R;

import java.util.ArrayList;

import dataadapter.Bem;
import dataadapter.BemData;
import dataadapter.GridAdapter;
import dataadapter.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {
    private RecyclerView rvgridd;
    private ArrayList<Bem> list = new ArrayList<>();
    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvgridd = view.findViewById(R.id.rv_gridd);
        list.addAll(BemData.getListData());
        showList();
    }


    private void showList() {
        rvgridd.setLayoutManager(new LinearLayoutManager(getContext()));
        GridAdapter gridAdapter = new GridAdapter(list);
        rvgridd.setAdapter(gridAdapter);

        gridAdapter.setOnItemClickCallback(new GridAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bem bem) {
                Toast.makeText(getContext(), "Kamu memilih " + bem.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
