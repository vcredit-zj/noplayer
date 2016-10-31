package com.vcredit.zj.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具类
 * Created by zhuofeng on 2015/4/10.
 */
public class VerifyUtils {

    /**
     * 简单手机正则校验
     *
     * @param MobileNo 手机号
     * @return
     */
    public static boolean isValidMobileNo(@NonNull String MobileNo) {

        String regPattern = "^1[3-9]\\d{9}$";
        return Pattern.matches(regPattern, MobileNo);

    }

    /**
     * 8-12位数字密码正则校验
     *
     * @param Pwd 密码
     * @return
     */
    public static boolean isValidPwd(@NonNull String Pwd) {

       /* Pattern pat = Pattern.compile("[\\da-zA-Z]{8,12}");
        Pattern patno = Pattern.compile(".*\\d.*");
        Pattern paten = Pattern.compile(".*[a-zA-Z].*");
        Matcher mat = pat.matcher(Pwd);
        Matcher matno = patno.matcher(Pwd);
        Matcher maten = paten.matcher(Pwd);
        return (matno.matches() && maten.matches() && mat.matches());*/
        //Pattern patno = Pattern.compile(".*\\d.*");
        //Pattern paten = Pattern.compile(".*[a-zA-Z].*");
        //Matcher matno = patno.matcher(Pwd);
        //Matcher maten = paten.matcher(Pwd);
        //6到16位任意密码
        Pattern pat = Pattern.compile("^[0-9a-zA-Z_#]{6,16}$");
        //只能为数字
        //  Pattern pat = Pattern.compile("[\\d]{8,12}");
        Matcher mat = pat.matcher(Pwd);
        return mat.matches();
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(@NonNull String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
    /**
     * 判断字符串是否为包含中文
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 登录密码的校验,只校验密码的长度
     *
     * @param Pwd 登录密码
     * @return
     */
    public static boolean logonisValidPwd(@NonNull String Pwd) {

       /* Pattern pat = Pattern.compile("[\\da-zA-Z]{8,12}");
        Pattern patno = Pattern.compile(".*\\d.*");
        Pattern paten = Pattern.compile(".*[a-zA-Z].*");
        Matcher mat = pat.matcher(Pwd);
        Matcher matno = patno.matcher(Pwd);
        Matcher maten = paten.matcher(Pwd);
        return (matno.matches() && maten.matches() && mat.matches());*/
        //Pattern patno = Pattern.compile(".*\\d.*");
        //Pattern paten = Pattern.compile(".*[a-zA-Z].*");
        //Matcher matno = patno.matcher(Pwd);
        //Matcher maten = paten.matcher(Pwd);
        //数字和字母的组合密码
        // Pattern pat = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,12}$");
        //只能为数字
        Pattern pat = Pattern.compile("^.{8,12}$");
        Matcher mat = pat.matcher(Pwd);
        return mat.matches();
    }

    /**
     * 密码长度校验,默认不忽略最大长度
     *
     * @param pwd
     * @return
     */
    public static boolean isValidServicePwd(@NonNull String pwd) {
        return isValidServicePwd(pwd, false);
    }

    /**
     * 密码长度校验
     *
     * @param pwd
     * @param ignoreMax, 是否忽略最大长度
     * @return
     */
    public static boolean isValidServicePwd(@NonNull String pwd, boolean ignoreMax) {
        return pwd.length() > 5 && (ignoreMax || pwd.length() < 13);
    }

    /**
     * 判断邮箱格式是否正确：
     */
    public static boolean isValidEmail(@NonNull String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * Luhn算法验证银行卡卡号是否有效
     */
    public static boolean isBankcardNo(String number) {
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for (int i = 0; i < reverse.length(); i++) {
            int digit = Character.digit(reverse.charAt(i), 10);
            if (i % 2 == 0) {//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            } else {//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if (digit >= 5) {
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }

    /**
     * 判断是否是姓名
     *
     * @param name
     * @return
     */
    public static boolean isUserName(CharSequence name) {
        return !TextUtils.isEmpty(name);
    }

    /**
     * 判断是否是身份证号码
     *
     * @param code
     * @return
     */
    public static boolean isIdCode(String code) {
        return IdcardUtils.validateCard(code);
    }

    /**
     * 验证码校验
     *
     * @param code
     * @return
     */
    public static boolean isServiceCode(@NonNull String code) {
        return code.length() > 0 && code.length() < 10;
    }

    /**
     * URL检查<br>
     * <br>
     *
     * @param pInput 要检查的字符串<br>
     * @return boolean   返回检查结果<br>
     */
    public static boolean isUrl(String pInput) {
        if (pInput == null) {
            return false;
        }
        String regEx = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(pInput);
        return matcher.matches();
    }

    /**
     * 校验邀请码
     *
     * @param pInput
     * @return
     */
    public static boolean isInviteCode(String pInput) {
        if (pInput == null) {
            return false;
        }
        String regEx = "[A-Za-z0-9]{6}";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(pInput);
        return matcher.matches();
    }

    /**
     * 校验我们发出的验证码
     *
     * @param pInput
     * @return
     */
    public static boolean isVerifyCode(String pInput) {
        if (pInput == null) {
            return false;
        }
        String regEx = "[0-9]{4}";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(pInput);
        return matcher.matches();
    }

    /**
     * 判断用户的手机号的运营商
     *
     * @param number 要判断的电话号码
     * @return 运营商编号 0---未知运营商 1---移动，2---联通， 3---电信
     */
    public static int PhoneNumKind(String number) {
        // 移动
        String telcomPatternY = "^134[0-8]\\d{7}$|^(?:13[5-9]|147|15[0-27-9]|178|18[2-478])\\d{8}$";
        // 联通
        String telcomPatternU = "^(?:13[0-2]|145|15[56]|176|18[56])\\d{8}";
        //电信
        String telcomPatternD = "^(?:133|153|177|18[019])\\d{8}$";
        if (number.matches(telcomPatternY)) { //移动用户
            return 1;
        } else if (number.matches(telcomPatternU)) { //联通用户
            return 2;
        } else if (number.matches(telcomPatternD)) { //电信用户
            return 3;
        } else //未知用户
            return 0;

    }
}
