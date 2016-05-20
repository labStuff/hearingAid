package com.yylx.hearingaid.listener;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;


/**
 * 
 * @className: DelayClickListener
 * @description: implement View.OnClickListener, consider twice click time diff to avoid multi click
 *               once, delay for show button click animation if execute doClick()
 * @author: wanghang
 * @date: 2015-5-1 下午12:47:38
 */
public abstract class DelayClickListener implements OnClickListener {

    public static final long DELAY_PAPER_BUTTON = 350; // default delay time for PaperButton's
                                                       // animation

    private long mLastClickTime = 0; // according last & this click time to detect if execute
                                     // doClick()

    private long mDelayTime = 0; // if execute doClick(), delay mDelayTime for show complete
                                 // animation

    /**
     * 
     * @param delayTime, delay time before execute doClick
     */
    public DelayClickListener(long delayTime) {
        mDelayTime = delayTime;
    }

    public abstract void doClick(View v);

    @Override
    public void onClick(final View v) {
        // if currentTime - mLastClickTime < 800, we don't execute doClick(), avoid multi click once
        long currentTime = System.currentTimeMillis();
        if (currentTime - mLastClickTime < 800) {
            return;
        }
        mLastClickTime = currentTime;
        // delay for show complete click animation
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doClick(v);
            }
        }, mDelayTime);
//        doClick(v);
    }
}
