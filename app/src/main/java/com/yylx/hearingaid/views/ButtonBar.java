package com.yylx.hearingaid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yylx.hearingaid.R;

/**
 * Created by zqj on 2016/5/18 14:17.
 */
public class ButtonBar extends LinearLayout implements View.OnClickListener {

    public interface ButtonBarClickListener {
        void loudComClicked();

        void howlSupClicked();

        void noiseReClicked();
    }

    public ButtonBar(Context context) {
        super(context);
        init();
    }

    public ButtonBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.comm_bottom_bar, this);
        initView();
    }

    FrameLayout frameLayoutLoudCom;
    FrameLayout frameLayoutHowlSup;
    FrameLayout frameLayoutNoiseRe;

    TextView txvLoudCom;
    TextView txvHowlSup;
    TextView txvNoiseRe;

    private ButtonBarClickListener mListener;

    private void initView() {
        frameLayoutLoudCom = (FrameLayout) findViewById(R.id.frameLayout_loudness_compensation);
        frameLayoutLoudCom.setOnClickListener(this);

        frameLayoutHowlSup = (FrameLayout) findViewById(R.id.frameLayout_howling_suppression);
        frameLayoutHowlSup.setOnClickListener(this);

        frameLayoutNoiseRe = (FrameLayout) findViewById(R.id.frameLayout_noise_reduction);
        frameLayoutNoiseRe.setOnClickListener(this);

        txvLoudCom = (TextView) findViewById(R.id.textView_loudness_compensation);
        txvHowlSup = (TextView) findViewById(R.id.textView_howling_suppression);
        txvNoiseRe = (TextView) findViewById(R.id.textView_noise_reduction);

        invalidateBtnState();
    }

    public void setBtnItemClickListener(ButtonBarClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frameLayout_loudness_compensation:
                if (mClickIndex == INDEX_L_C)
                    return;
                mClickIndex = INDEX_L_C;
                if (null != mListener) {
                    mListener.loudComClicked();
                }
                break;
            case R.id.frameLayout_howling_suppression:
                if (mClickIndex == INDEX_H_S)
                    return;
                mClickIndex = INDEX_H_S;
                if (null != mListener) {
                    mListener.howlSupClicked();
                }
                break;
            case R.id.frameLayout_noise_reduction:
                if (mClickIndex == INDEX_N_R)
                    return;
                mClickIndex = INDEX_N_R;
                if (null != mListener) {
                    mListener.noiseReClicked();
                }
                break;
            default:
                break;
        }
        invalidateBtnState();
    }

    private final int INDEX_L_C = 0;
    private final int INDEX_H_S = 1;
    private final int INDEX_N_R = 2;
    private int mClickIndex = INDEX_L_C;

    private final int checkedColor = getResources().getColor(R.color.black_700);
    private final int uncheckedColor = getResources().getColor(R.color.black_400);

    private void invalidateBtnState() {
        txvLoudCom.setTextColor(uncheckedColor);
        txvHowlSup.setTextColor(uncheckedColor);
        txvNoiseRe.setTextColor(uncheckedColor);
        switch (mClickIndex) {
            case INDEX_H_S:
                txvHowlSup.setTextColor(checkedColor);
                break;
            case INDEX_N_R:
                txvNoiseRe.setTextColor(checkedColor);
                break;
            default:
                txvLoudCom.setTextColor(checkedColor);
                break;
        }
    }
}
