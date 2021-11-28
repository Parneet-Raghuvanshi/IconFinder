package com.example.iconfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;

import com.example.iconfinder.models.IconModel;
import com.example.iconfinder.repo.IconFinderRepo;
import com.example.iconfinder.retrofit.RetrofitClient;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        MutableLiveData<List<IconModel>> temp = new MutableLiveData<>();
        IconFinderRepo iconFinderRepo = new IconFinderRepo();

        temp = iconFinderRepo.getMainIcons();
    }
}