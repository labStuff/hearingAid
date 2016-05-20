package com.yylx.hearingaid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.yylx.hearingaid.R;
import com.yylx.hearingaid.views.checkbox.CheckBox;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link LoudComFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoudComFragment extends Fragment implements OnClickListener {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoudComFragment.
     */
    public static LoudComFragment newInstance() {
        LoudComFragment fragment = new LoudComFragment();
        return fragment;
    }

    public LoudComFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loudness_compensation, container, false);
    }

    CheckBox[] checkboxs = new CheckBox[16];
    Button btnOpenAll;
    Button btnCloseAll;

    TextView loudComHint;
    Switch loudComSwitch;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkboxs[0] = (CheckBox) view.findViewById(R.id.checkBox_1);
        checkboxs[1] = (CheckBox) view.findViewById(R.id.checkBox_2);
        checkboxs[2] = (CheckBox) view.findViewById(R.id.checkBox_3);
        checkboxs[3] = (CheckBox) view.findViewById(R.id.checkBox_4);
        checkboxs[4] = (CheckBox) view.findViewById(R.id.checkBox_5);
        checkboxs[5] = (CheckBox) view.findViewById(R.id.checkBox_6);
        checkboxs[6] = (CheckBox) view.findViewById(R.id.checkBox_7);
        checkboxs[7] = (CheckBox) view.findViewById(R.id.checkBox_8);
        checkboxs[8] = (CheckBox) view.findViewById(R.id.checkBox_9);
        checkboxs[9] = (CheckBox) view.findViewById(R.id.checkBox_10);
        checkboxs[10] = (CheckBox) view.findViewById(R.id.checkBox_11);
        checkboxs[11] = (CheckBox) view.findViewById(R.id.checkBox_12);
        checkboxs[12] = (CheckBox) view.findViewById(R.id.checkBox_13);
        checkboxs[13] = (CheckBox) view.findViewById(R.id.checkBox_14);
        checkboxs[14] = (CheckBox) view.findViewById(R.id.checkBox_15);
        checkboxs[15] = (CheckBox) view.findViewById(R.id.checkBox_16);

        btnOpenAll = (Button) view.findViewById(R.id.button_open_all);
        btnOpenAll.setOnClickListener(this);
        btnCloseAll = (Button) view.findViewById(R.id.button_close_all);
        btnCloseAll.setOnClickListener(this);

        loudComHint = (TextView) view.findViewById(R.id.textView_switchHint);
        loudComSwitch = (Switch) view.findViewById(R.id.switch_loudness_compensation);
        loudComSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    loudComHint.setText(R.string.open_loudness_compensation);
                } else {
                    loudComHint.setText(R.string.close_loudness_compensation);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == btnOpenAll) {
            openAllCheckBox();
        } else if (v == btnCloseAll) {
            closeAllCheckBox();
        }
    }

    private void openAllCheckBox() {
        for (CheckBox checkBox : checkboxs) {
            checkBox.setChecked(true);
        }
    }

    private void closeAllCheckBox() {
        for (CheckBox checkBox : checkboxs) {
            checkBox.setChecked(false);
        }
    }
}
