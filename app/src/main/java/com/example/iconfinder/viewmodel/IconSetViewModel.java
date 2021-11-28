package com.example.iconfinder.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.iconfinder.models.IconSetModel;
import com.example.iconfinder.repo.IconSetRepo;

import java.util.List;

public class IconSetViewModel extends ViewModel {

    private final MutableLiveData<List<IconSetModel>> iconSets;
    private final IconSetRepo iconSetRepo;

    public IconSetViewModel() {
        iconSetRepo = new IconSetRepo();
        this.iconSets = iconSetRepo.getIconSets();
    }

    public MutableLiveData<List<IconSetModel>> getIconSets() {
        return iconSets;
    }
}
