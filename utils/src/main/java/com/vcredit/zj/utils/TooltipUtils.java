package com.vcredit.zj.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

/**
 * Created by wangzhengji on 2015/8/25.
 */
public class TooltipUtils {
    /**
     * 通用创建无message的dialog，默认支持点击外部取消、支持按返回取消
     *
     * @param context
     * @param title            弹框的标题
     * @param positiveListener 确定按钮的实例化监听
     * @param negativeListener 取消按钮的实例化监听
     * @param positiveText     确定按钮的文字显示
     * @param negativeText     取消按钮的文字显示
     * @return                 返回对话框实例
     */
    public synchronized static AlertDialog showDialog(Context context, String title,
                                  DialogInterface.OnClickListener positiveListener,
                                  DialogInterface.OnClickListener negativeListener,
                                  String positiveText, String negativeText) {
        return showDialog(context, title, positiveListener, negativeListener, positiveText, negativeText, true);
    }

    /**
     * 通用创建dialog，默认支持点击外部取消、支持按返回取消
     *
     * @param context
     * @param title            弹框的标题
     * @param message          弹框的内容
     * @param positiveListener 确定按钮的实例化监听
     * @param negativeListener 取消按钮的实例化监听
     * @param positiveText     确定按钮的文字显示
     * @param negativeText     取消按钮的文字显示
     * @return                 返回对话框实例
     */
    public synchronized static AlertDialog showDialog(Context context, String title, String message,
                                  DialogInterface.OnClickListener positiveListener,
                                  DialogInterface.OnClickListener negativeListener,
                                  String positiveText, String negativeText) {
        return showDialog(context, title, message, positiveListener, negativeListener ,positiveText, negativeText, true);
    }

    /**
     * 通用创建无message的dialog，默认支持按返回取消
     *
     * @param context
     * @param title            弹框的标题
     * @param positiveListener 确定按钮的实例化监听
     * @param negativeListener 取消按钮的实例化监听
     * @param positiveText     确定按钮的文字显示
     * @param negativeText     取消按钮的文字显示
     * @param touchOutside     是否支持点击外部取消
     * @return                 返回对话框实例
     */
    public synchronized static AlertDialog showDialog(Context context, String title,
                                  DialogInterface.OnClickListener positiveListener,
                                  DialogInterface.OnClickListener negativeListener,
                                  String positiveText, String negativeText, boolean touchOutside) {
        return showDialog(context, title, null, positiveListener, negativeListener, positiveText, negativeText, touchOutside);
    }

    /**
     * 通用创建dialog，默认支持按返回取消
     * @param context
     * @param title            弹框的标题
     * @param message          弹框的内容
     * @param positiveListener 确定按钮的实例化监听
     * @param negativeListener 取消按钮的实例化监听
     * @param positiveText     确定按钮的文字显示
     * @param negativeText     取消按钮的文字显示
     * @param touchOutside     是否支持点击外部取消
     * @return                 返回对话框实例
     */
    public synchronized static AlertDialog showDialog(Context context, String title, String message,
                                  DialogInterface.OnClickListener positiveListener,
                                  DialogInterface.OnClickListener negativeListener,
                                  String positiveText, String negativeText, boolean touchOutside) {
        return showDialog(context, title, message, positiveListener, negativeListener, positiveText, negativeText, touchOutside, true);
    }

    /**
     * 通用创建dialog
     * @param context
     * @param title            弹框的标题
     * @param message          弹框的内容
     * @param positiveListener 确定按钮的实例化监听
     * @param negativeListener 取消按钮的实例化监听
     * @param positiveText     确定按钮的文字显示
     * @param negativeText     取消按钮的文字显示
     * @param touchOutside     是否支持点击外部取消
     * @param cancelable       是否支持按返回取消
     * @return                 返回对话框实例
     */
    public synchronized static AlertDialog showDialog(Context context, String title, String message,
                                               DialogInterface.OnClickListener positiveListener,
                                               DialogInterface.OnClickListener negativeListener,
                                               String positiveText, String negativeText, boolean touchOutside, boolean cancelable) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setPositiveButton(positiveText, positiveListener);
        alertDialog.setNegativeButton(negativeText, negativeListener);

        // 是否包含标题，设置Title
        boolean hasTitle = !TextUtils.isEmpty(title);
        if (hasTitle) {
            alertDialog.setTitle(title);
        }

        // 包含内容的时候，设置Message
        boolean hasMsg = !TextUtils.isEmpty(message);
        if (hasMsg){
            alertDialog.setMessage(message);
        }

        // 只要标题和内容有一个不是空就显示Dialog
        if (hasTitle || hasMsg){
            AlertDialog dialog = alertDialog.create();
            dialog.setCanceledOnTouchOutside(touchOutside);
            dialog.setCancelable(cancelable);
            dialog.show();

            return dialog;
        }

        return null;
    }

    /**
     * 短时间显示Toast消息，并保证运行在UI线程中
     *
     * @param activity Activity
     * @param message  消息内容
     */
    public static void showToastS(final Context activity, final String message) {
        showToast(activity, message, 1500, 50);
    }

    /**
     * 延时Toast，延时单位毫秒
     * @param activity
     * @param message
     * @param delay
     */
    public static void showToastS(final Context activity, final String message, int delay) {
        showToast(activity, message, 1500, delay);
    }

    /**
     * 长时间显示Toast消息，并保证运行在UI线程中
     *
     * @param activity Activity
     * @param message  消息内容
     */
    public static void showToastL(final Context activity, final String message) {
        showToast(activity, message, 3000);
    }

    /**
     * 延时Toast，延时单位毫秒
     * @param activity
     * @param message
     * @param delay
     */
    public static void showToastL(final Context activity, final String message, int delay) {
        showToast(activity, message, 3000, delay);
    }

    public interface MessageFilter {
        String filter(String msg);
    }

    public static MessageFilter msgFilter;

    /**
     * Toast消息
     *
     * @param activity
     * @param message  消息内容
     * @param time     显示时间
     */
    public static void showToast(final Context activity, final String message, final int time) {
        showToast(activity, message, time, 0);
    }

    /**
     * 延时Toast，延时单位毫秒
     * @param activity
     * @param message
     * @param time
     * @param delay
     */
    public static void showToast(final Context activity, final String message, final int time, long delay) {
        final String msg = msgFilter != null ? msgFilter.filter(message) : message;

        ToastUtil.showToast(activity, msg, time, delay);
    }

    /**
     * 关闭Toast
     */
    public static void cancelAllToast(){
        try {
            ToastUtil.cancelAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
