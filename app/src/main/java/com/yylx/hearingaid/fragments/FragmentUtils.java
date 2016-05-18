package com.yylx.hearingaid.fragments;

import android.support.v4.app.Fragment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zqj on 2016/5/18 15:45.
 */
public class FragmentUtils {
    public static Fragment newInstance(Class<? extends Fragment> cls) {
        Fragment fragment = null;
        try {
            Method method = cls.getMethod("newInstance");
            fragment = (Fragment) method.invoke(null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;
    }
}
