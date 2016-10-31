package com.vcredit.zj.utils.security;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * RSA工具类对外接口
 */
public class RSAHelper {

    private static RSAHelper instance;


    private static String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvy/nXti2Jn/EjIKo/UFmSqPus" +
            "kIpUlP8+a/VXjmim8hn6ckNf+hYEa+PHNgA8bckO8a66yOoS9Q3e9YoX8gxnjOKi" +
            "wfoopnf+nHgwVKG2pDo+OWUx4z/xskt4TygwDjl7suncRU79/SQJHVf9t2LTqss3" +
            "Bwn86r2ZLHxPlNN4vwIDAQAB";

    public static synchronized RSAHelper getInstance() {
        if (instance == null) {
            instance = new RSAHelper();
        }

        return instance;
    }

    public static synchronized RSAHelper getDefault() {
        getInstance();
        instance.initWithBase64(publicKeyStr, null);

        return instance;
    }

    private PublicKey publicKey;

    private PrivateKey privateKey;

    private RSAHelper() {

    }

    /**
     * 直接指通过公钥、私钥初始化
     */
    public RSAHelper init(PublicKey publicKey, PrivateKey privateKey) {
        return setPublicKey(publicKey).setPrivateKey(privateKey);
    }

    /**
     * 通过公钥、私钥的二进制初始化
     */
    public RSAHelper init(byte[] publicKeyBytes, byte[] privateKeyBytes) {
        PublicKey publicKey = null;
        try {
            publicKey = RSAUtils.getPublicKey(publicKeyBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrivateKey privateKey = null;
        try {
            privateKey = RSAUtils.getPrivateKey(privateKeyBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return init(publicKey, privateKey);
    }

    /**
     * 通过公钥、私钥的十六进制字符初始化
     */
    public RSAHelper initWithHex(String publicKeyStr, String privateKeyStr) {
        PublicKey publicKey = null;
        try {
            publicKey = RSAUtils.loadPublicKey(publicKeyStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrivateKey privateKey = null;
        try {
            privateKey = RSAUtils.loadPrivateKey(privateKeyStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return init(publicKey, privateKey);
    }

    /**
     * 通过公钥、私钥的Base64字符串初始化
     */
    public RSAHelper initWithBase64(String publicKeyStr, String privateKeyStr) {
        byte[] publicKeyBytes = null;
        try {
            publicKeyBytes = Base64.decode(publicKeyStr, Base64.DEFAULT);
        } catch (Exception e) {
        }

        byte[] privateKeyBytes = null;
        try {
            privateKeyBytes = Base64.decode(privateKeyStr, Base64.DEFAULT);
        } catch (Exception e) {
        }

        return init(publicKeyBytes, privateKeyBytes);
    }

    public RSAHelper setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public RSAHelper setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    /**
     * 用公钥加密 <br>
     * 每次加密的字节数，不能超过密钥的长度值减去11
     *
     * @param data 需加密数据的byte数据
     * @return 加密后的byte型数据
     */
    public byte[] encryptData(byte[] data) {
        return RSAUtils.encryptData(data, publicKey);
    }

    /**
     * 用公钥加密 <br>
     * 每次加密的字节数，不能超过密钥的长度值减去11
     *
     * @param data 需加密数据的byte数据
     * @return 加密后的byte型数据
     */
    public String encryptData(String data) {
        try {
            return Base64.encodeToString(encryptData(data.getBytes("utf-8")), Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 用私钥解密
     *
     * @param encryptedData 经过encryptedData()加密返回的byte数据
     */
    public byte[] decryptData(byte[] encryptedData) {
        return RSAUtils.decryptData(encryptedData, privateKey);
    }

    /**
     * 二行制转字符串
     */
    public static String byte2hex(byte[] b) {
        return RSAUtils.byte2hex(b);
    }

    public static byte[] hex2byte(String hexString) {
        return RSAUtils.hex2byte(hexString);
    }
}
