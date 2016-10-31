package com.vcredit.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhengji on 2015/8/25.
 */
public class ConvertUtils {

    /**
     * 将String转化成Double类型，同时可设置Double类型保留小数位数，四舍五入后返回
     * @param input
     * @param decimals
     * @return
     */
    public  static Double tryParseDouble(String input, int decimals){
        Double d = 0d;
        try {
            if (TextUtils.isEmpty(input)) {
                return round(d, decimals);
            }
            return round(Double.parseDouble(input), decimals);
        }catch (Exception e){
            return d;
        }
    }

    /**
     * 设置Double与保留小数位数，四舍五入后返回
     * @param d
     * @param decimals
     * @return
     */
    public static Double round(Double d, int decimals){
        if(decimals < 0) {
            return (double)Math.round(d);
        }
        double multiple = Math.pow(10, decimals);
        double result = Math.round(d * multiple);
        return  result / multiple;
    }

    /**
     * Float
     *
     * @param input string
     * @return
     */
    public static float tryParseFloat(String input) {
        float f = 0f;
        try {
            if (TextUtils.isEmpty(input)) {
                return f;
            }
            f = Float.parseFloat(input);
            return f;
        } catch (Exception e) {
            return f;
        }
    }

    /**
     * 将String转化为int类型
     *
     * @param input string
     * @return
     */
    public static int tryParseInt(String input) {
        int i = 0;
        try {
            if (TextUtils.isEmpty(input)) {
                return i;
            }
            i = Integer.parseInt(input);
            return i;
        } catch (Exception e) {
            return i;
        }
    }

    /**
     * 时间差格式化 HH:mm:ss
     *
     * @param l
     * @return
     */
    public static String formatLongToTimeStr(Long l) {
        int hour = 0;
        int minute = 0;
        int second;

        second = l.intValue() / 1000;

        if (second >= 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute >= 60) {
            hour = minute / 60;
            minute = minute % 60;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(getTwoLength(hour));
        sb.append(":");
        sb.append(getTwoLength(minute));
        sb.append(":");
        sb.append(getTwoLength(second));

        return sb.toString();
    }

    /**
     * 为个位数前面添加0补齐
     *
     * @param data
     * @return
     */
    public static String getTwoLength(int data) {
        if (data < 10) {
            return "0" + data;
        } else {
            return "" + data;
        }
    }

    /**
     * 时间差格式化 HH:mm:ss
     *
     * @param l
     * @return
     */
    public static List<Integer> formatLongToTimelist(Long l) {
        List<Integer> list = new ArrayList<Integer>();
        int day = 0;
        int hour = 0;
        int minute = 0;
        int second;
        second = l.intValue() / 1000;

        if (second >= 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute >= 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        if (hour >= 24) {
            day = hour / 24;
            hour = hour % 24;
        }
        list.add((day / 10) % 10);
        list.add(day % 10);
        list.add((hour / 10) % 10);
        list.add(hour % 10);
        list.add((minute / 10) % 10);
        list.add(minute % 10);
        return list;
    }
}
