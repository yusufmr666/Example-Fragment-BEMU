package com.example.projek7.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.projek7.BemActivity;
import com.example.projek7.ListActivity;
import com.example.projek7.NavigationActivity;
import com.example.projek7.ProfilActivity;
import com.example.projek7.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnList, btnProfil, btnGrid;

        btnList = view.findViewById(R.id.img_list);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        btnProfil = view.findViewById(R.id.img_profil);
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more = new Intent(getContext(), ProfilActivity.class);
                startActivity(more);
            }
        });

        btnGrid = view.findViewById(R.id.btn_login);
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more = new Intent(getContext(), BemActivity.class);
                startActivity(more);
            }
        });

    }
}
