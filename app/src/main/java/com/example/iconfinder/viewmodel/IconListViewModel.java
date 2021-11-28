package com.example.iconfinder.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.iconfinder.models.IconModel;
import com.example.iconfinder.repo.MainIconRepo;

import java.util.List;

public class IconListViewModel extends ViewModel {

    private final MutableLiveData<List<IconModel>> iconData;
    private final MainIconRepo iconFinderRepo;

    public IconListViewModel() {
        iconFinderRepo = new MainIconRepo();
        this.iconData = iconFinderRepo.getMainIcons();
    }

    public MutableLiveData<List<IconModel>> getIconData() {
        return iconData;
    }
}
