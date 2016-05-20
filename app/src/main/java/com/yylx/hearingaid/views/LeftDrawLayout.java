package com.yylx.hearingaid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.yylx.hearingaid.R;

/**
 * Created by zqj on 2016/5/20 14:09.
 */
public class LeftDrawLayout extends LinearLayout {
    public LeftDrawLayout(Context context) {
        super(context);
        init();
    }

    public LeftDrawLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LeftDrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        inflate(getContext(), R.layout.comm_layout_left_draw, this);
        initView();
    }

    private void initView() {
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);
        return true;
    }
}
