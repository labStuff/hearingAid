package com.yylx.hearingaid.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.yylx.hearingaid.R;
import com.yylx.hearingaid.fragments.FragmentUtils;
import com.yylx.hearingaid.fragments.HowlSupFragment;
import com.yylx.hearingaid.fragments.LoudComFragment;
import com.yylx.hearingaid.fragments.NoiseReFragment;
import com.yylx.hearingaid.views.ButtonBar;

public class MainActivity extends AppCompatActivity implements ButtonBar.ButtonBarClickListener {


    ButtonBar mButtonBar;

    FragmentManager mFragManager;

    Fragment loudComFragment;
    Fragment howlSupFragment;
    Fragment noiseReFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        loudComClicked();
    }

    private void initView() {
        mButtonBar = (ButtonBar) findViewById(R.id.layout_bottom);
        mButtonBar.setBtnItemClickListener(this);

    }

    private void initData() {
        mFragManager = getSupportFragmentManager();
    }

    @Override
    public void loudComClicked() {
        loudComFragment = showOrInitFragment(loudComFragment, LoudComFragment.class);
    }

    @Override
    public void howlSupClicked() {
        howlSupFragment = showOrInitFragment(howlSupFragment, HowlSupFragment.class);
    }

    @Override
    public void noiseReClicked() {
        noiseReFragment = showOrInitFragment(noiseReFragment, NoiseReFragment.class);

    }

    /**
     * hide all fragments and return transaction obj to listener
     *
     * @return
     */
    private FragmentTransaction fragmentTranBegin() {
        FragmentTransaction transaction = mFragManager.beginTransaction();
        if (null != loudComFragment) {
            transaction.hide(loudComFragment);
        }
        if (null != howlSupFragment) {
            transaction.hide(howlSupFragment);
        }
        if (null != noiseReFragment) {
            transaction.hide(noiseReFragment);
        }
        return transaction;
    }

    private Fragment showOrInitFragment(Fragment fragment, Class<? extends Fragment> cls) {
        if (null == fragment) {
            fragment = FragmentUtils.newInstance(cls);
            if (null == fragment) {
                throw new RuntimeException("fragment: " + cls.getName() + " init error!");
            }
            fragmentTranBegin().add(R.id.fragment_content, fragment)
                    .show(fragment).commit();
        } else {
            fragmentTranBegin().show(fragment).commit();
        }
        return fragment;
    }
}
