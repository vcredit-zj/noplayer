package com.vcredit.zj.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * @ClassName: ToastUtil
 * @Description: Toast工具类
 * @author shibenli
 * @date 2016-3-29 下午10:26:25
 * @Version 1.0
 */
final class ToastUtil {

    private static Handler ToastHandler = new Handler(Looper.getMainLooper()){
        public void handleMessage(android.os.Message msg) {
            currentToast.show();
        }
    };

    public static Toast initToast(Context context) {
        if (context != null && currentToast == null) {
            currentToast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
            currentToast.setGravity(Gravity.CENTER, 0, -100);
        }

        return currentToast;
    }

    public static void showToast(Context context, CharSequence  msg, int duration) {
        showToast(context, msg, duration, 0);
    }
    
    /**
     * 发送延时Toast
     * @param context
     * @param msg
     * @param duration
     * @param delay
     */
    public static void showToast(Context context, CharSequence  msg, int duration, long delay) {
        if (currentToast == null) {
            currentToast = makeText(context, msg, duration);
        } else {
            currentToast.setText(msg);
            currentToast.setDuration(duration);
        }
        delay = 0 > delay ? 0 : (delay > 1000 ? 100 : delay);
        ToastHandler.sendEmptyMessageDelayed(0, delay);
    }

    public static void showToast(Context context, CharSequence  msg) {
        try {
            if (context != null) {
                showToast(context, msg, 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void showToast(Context context, int id) {
        try {
            if (context != null) {
                showToast(context, context.getResources().getString(id), 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Toast currentToast;

    private static View toastView;

    /**
     * 使用同1个toast,避免多toast重复问题
     * 
     * @param context
     * @param text
     * @param duration
     * @return
     */
    public static Toast makeText(Context context, CharSequence text, int duration) {
        if (currentToast == null && context != null) {
            currentToast = initToast(context);
        } 
        
        toastView = currentToast.getView();
        
        if (toastView != null) {
            currentToast.setView(toastView);
            currentToast.setText(text);
            currentToast.setDuration(duration);
        }
        return currentToast;
    }

    public static void cancelAll() {
        if (currentToast!=null) {
            try {
                currentToast.cancel();
            } catch (Exception e) {
            }
        }
    }
}

