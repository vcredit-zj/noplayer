package com.vcredit.zj.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密算法类
 */
public class EncryptUtils {

    /**
     * 32位MD5加密
     * @param paramString
     * @return
     */
    public static String md5(String paramString) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramString.getBytes());
            return toHexString(localMessageDigest.digest());
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
        return paramString;
    }

    /**
     * 16位MD5加密
     * @param paramString
     * @return
     */
    public static String md5_16(String paramString) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramString.getBytes());
            return toHexString(localMessageDigest.digest()).substring(8, 24);
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
        return paramString;
    }

    private static final char[] HEX_DIGITS = {48, 49, 50, 51, 52, 53, 54, 55,
            56, 57, 97, 98, 99, 100, 101, 102};

    private static String toHexString(byte[] paramArrayOfByte) {
        int length = paramArrayOfByte.length;
        StringBuilder localStringBuilder = new StringBuilder(2 * length);
        for (int i = 0; ; ++i) {
            if (i >= length)
                return localStringBuilder.toString().toUpperCase();
            localStringBuilder
                    .append(HEX_DIGITS[((0xF0 & paramArrayOfByte[i]) >>> 4)]);
            localStringBuilder.append(HEX_DIGITS[(0xF & paramArrayOfByte[i])]);
        }
    }
    /**
     * 对文件全文生成MD5摘要
     *@param file 要加密的文件
     * @return MD5摘要码
     */
    public static String fileMD5(File file) {

        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            //32位加密
            byte[] b = md.digest();
            return toHexString(b);
            // 16位加密
            // return buf.toString().substring(8, 24);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        finally {
            try {
                if(fis!=null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
