package com.example.e_learningapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class contentFragment extends Fragment {
    String content;
    public contentFragment(String content){
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conten_view, container, false);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(content);
        return view;
    }
}
