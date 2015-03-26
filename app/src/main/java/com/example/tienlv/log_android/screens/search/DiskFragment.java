package com.example.tienlv.log_android.screens.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tienlv.log_android.R;


public class DiskFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_disk_tab, container,false);

        return rootView;
    }

    public void clickMe(View v){
        Toast.makeText(getActivity(), "test on fragment", Toast.LENGTH_LONG).show();
    }
}
