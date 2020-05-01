package com.example.projek7.ui.slideshow;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projek7.R;

import java.util.ArrayList;

import dataadapter.Bem;
import dataadapter.BemData;
import dataadapter.ListAdapter;

public class SlideshowFragment extends Fragment {

    private RecyclerView rvList;
    private ArrayList<Bem> list = new ArrayList<>();

    // Required empty public constructor


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slideshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvList = view.findViewById(R.id.rv_list);
        list.addAll(BemData.getListData());
        showList();
    }


    private void showList() {
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        ListAdapter listAdapter = new ListAdapter(list);
        rvList.setAdapter(listAdapter);

        listAdapter.setOnItemClickCallback(new ListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bem bem) {
                Toast.makeText(getContext(), "Kamu memilih " + bem.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
