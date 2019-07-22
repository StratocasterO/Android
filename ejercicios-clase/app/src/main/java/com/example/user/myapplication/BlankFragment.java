package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        TextView tv = getView().findViewById(R.id.elTextViewDelFragment);
        tv.setText("Esto es un fragment");
    }
}
