package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultFragment extends Fragment {
    TextView txtresult;

    public ResultFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_result, container, false);
        txtresult=(TextView) v.findViewById(R.id.txtResult);
        return v;
    }
    public void setResult(String value){
        if (txtresult != null) {
            txtresult.setText(value);
        }
    }
}