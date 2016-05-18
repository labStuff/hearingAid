package com.yylx.hearingaid.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yylx.hearingaid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoiseReFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoiseReFragment extends Fragment {


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NoiseReFragment.
     */
    public static NoiseReFragment newInstance() {
        NoiseReFragment fragment = new NoiseReFragment();
        return fragment;
    }

    public NoiseReFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_noise_reduction, container, false);
    }


}
