package com.yylx.hearingaid.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

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

    TextView echoHint;
    Switch echoSwitch;

    TextView howlSupHint;
    Switch howlSupSwitch;

    TextView trapHint;
    Switch trapSwitch;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        echoHint = (TextView) view.findViewById(R.id.textView_switchHint_echo);
        echoSwitch = (Switch) view.findViewById(R.id.switch_echo_suppression);
        echoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    echoHint.setText(R.string.echo_suppression_opened);
                } else {
                    echoHint.setText(R.string.echo_suppression_closed);
                }
            }
        });

        howlSupHint = (TextView) view.findViewById(R.id.textView_switchHint_howl);
        howlSupSwitch = (Switch) view.findViewById(R.id.switch_howling_suppression);
        howlSupSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    howlSupHint.setText(R.string.howling_suppression_opened);
                } else {
                    howlSupHint.setText(R.string.howling_suppression_closed);
                }
            }
        });

        trapHint = (TextView) view.findViewById(R.id.textView_switchHint_trap);
        trapSwitch = (Switch) view.findViewById(R.id.switch_trap);
        trapSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    trapHint.setText(R.string.trap_opened);
                } else {
                    trapHint.setText(R.string.trap_closed);
                }
            }
        });
    }
}
