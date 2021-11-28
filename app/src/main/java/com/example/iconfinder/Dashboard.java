package com.example.iconfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.iconfinder.adapter.IconListAdapter;
import com.example.iconfinder.custom.BucketRecyclerView;
import com.example.iconfinder.models.IconModel;
import com.example.iconfinder.repo.IconFinderRepo;
import com.example.iconfinder.retrofit.RetrofitClient;
import com.example.iconfinder.viewmodel.IconListViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {

    private List<IconModel> icons;
    private IconListAdapter iconListAdapter;
    private IconListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BucketRecyclerView recyclerView = findViewById(R.id.rv_mainIcons);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);
        iconListAdapter = new IconListAdapter(this,icons);
        recyclerView.setAdapter(iconListAdapter);

        viewModel = new ViewModelProvider(this).get(IconListViewModel.class);

        viewModel.getIconData().observe(this, new Observer<List<IconModel>>() {
            @Override
            public void onChanged(List<IconModel> iconModels) {
                if (iconModels != null){
                    icons = iconModels;
                    iconListAdapter.setIconList(iconModels);
                }
            }
        });
    }
}