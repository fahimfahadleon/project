package com.example.bs23androidtask102.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.bs23androidtask102.Adapter.MainAdapter;
import com.example.bs23androidtask102.Listener.MainAdapterItemClickListener;

public class ContainerViewModel extends ViewModel {
    public MainAdapter adapter = new MainAdapter();
    public MainAdapterItemClickListener listener;

    public void initLister() {
        adapter.setItemClickListener(listener);
    }

}
