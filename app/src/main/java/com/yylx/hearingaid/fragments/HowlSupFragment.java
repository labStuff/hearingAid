package com.yylx.hearingaid.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yylx.hearingaid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HowlSupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HowlSupFragment extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HowlSupFragment.
     */
    public static HowlSupFragment newInstance() {
        HowlSupFragment fragment = new HowlSupFragment();
        return fragment;
    }

    public HowlSupFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_howl_suppression, container, false);
    }


}
