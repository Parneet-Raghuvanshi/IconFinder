package com.example.iconfinder.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.iconfinder.R;
import com.example.iconfinder.adapter.IconListAdapter;
import com.example.iconfinder.adapter.IconSetAdapter;
import com.example.iconfinder.custom.BucketRecyclerView;
import com.example.iconfinder.models.IconModel;
import com.example.iconfinder.models.IconSetModel;
import com.example.iconfinder.viewmodel.IconListViewModel;
import com.example.iconfinder.viewmodel.IconSetViewModel;

import java.util.List;

public class Dashboard extends AppCompatActivity {

    //private List<IconModel> icons;
    //private IconListAdapter iconListAdapter;
    private IconSetAdapter iconSetAdapter;
    //private IconListViewModel viewModel;
    private IconSetViewModel iconSetViewModel;
    private List<IconSetModel> iconSets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        BucketRecyclerView recyclerView = findViewById(R.id.rv_mainIcons);
//        LinearLayoutManager layoutManager = new GridLayoutManager(this,4);
//        recyclerView.setLayoutManager(layoutManager);
//        iconListAdapter = new IconListAdapter(this,icons);
//        recyclerView.setAdapter(iconListAdapter);
//
//        viewModel = new ViewModelProvider(this).get(IconListViewModel.class);
//
//        viewModel.getIconData().observe(this, new Observer<List<IconModel>>() {
//            @Override
//            public void onChanged(List<IconModel> iconModels) {
//                if (iconModels != null){
//                    icons = iconModels;
//                    iconListAdapter.setIconList(iconModels);
//                }
//            }
//        });

        BucketRecyclerView recyclerView = findViewById(R.id.rv_mainIcons);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        iconSetAdapter = new IconSetAdapter(this,iconSets);
        recyclerView.setAdapter(iconSetAdapter);

        iconSetViewModel = new ViewModelProvider(this).get(IconSetViewModel.class);

        iconSetViewModel.getIconSets().observe(this, new Observer<List<IconSetModel>>() {
            @Override
            public void onChanged(List<IconSetModel> iconSetModels) {
                if (iconSetModels != null){
                    iconSets = iconSetModels;
                    iconSetAdapter.setIconSetList(iconSetModels);
                }
            }
        });
    }
}