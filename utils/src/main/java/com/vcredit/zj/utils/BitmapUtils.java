package com.vcredit.zj.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Base64;

import com.vcredit.zj.utils.CommonUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by wangzhengji on 2015/4/10.
 */
public class BitmapUtils {
    /**
     * 设置图片路径，从文件流中读取图像数据并返回Bitmap对象
     *
     * @param filePath
     * @return
     */
    public static Bitmap pathToBitmap(String filePath) {
        BitmapFactory.Options bfOptions = new BitmapFactory.Options();
        bfOptions.inDither = false;
        bfOptions.inPurgeable = true;
        bfOptions.inTempStorage = new byte[12 * 1024];
        File file = new File(filePath);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFileDescriptor(fin.getFD(), null,
                    bfOptions);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bitmap;
    }

    /**
     * 将字符串转换成Bitmap类型
     *
     * @param string
     * @return
     */
    public static Bitmap base64ToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(string, Base64.NO_WRAP);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
                    bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 将Bitmap转换成字符串
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {
        String string = null;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
        byte[] bytes = bStream.toByteArray();
        string = Base64.encodeToString(bytes, Base64.NO_WRAP);
        return string;
    }

    /**
     * 设置图片路径，缩略图最大宽度，从文件中读取图像数据并返回Bitmap对象
     *
     * @param filePath
     * @param maxWeight
     * @return
     */
    public static Bitmap pathToBitmap(String filePath, int maxWeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
        float realWidth = options.outWidth;
        float realHeight = options.outHeight;
        float larger = (realWidth > realHeight) ? realWidth : realHeight;
        int scale = (int) (larger / maxWeight);
        if (scale <= 0) {
            scale = 1;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = scale;

        bitmap = BitmapFactory.decodeFile(filePath, options);
        return bitmap;
    }

    public static Bitmap resizeImage(Bitmap bitmap, int w, int h)
    {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int newWidth = w;
        int newHeight = h;

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // if you want to rotate the Bitmap
        // matrix.postRotate(45);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width,
                height, matrix, true);
        return resizedBitmap;
    }

    /**
     * 旋转和缩放图片到合适的模式，并转成Base64编码，以供上传服务器
     * @param imgPath 图片路径
     * @return base64编码的字符串
     */
    public static String imgToBase64WithRoteteAndScale(String imgPath) {
        byte [] b = CommonUtils.getByte(bitmapRoteteAndScale(imgPath));
        return Base64.encodeToString(b, Base64.NO_WRAP);
    }

    /**
     * 旋转和缩放图片
     * @param imgPath 图片路径
     * @return 旋转和缩放后的位图
     */
    public static Bitmap bitmapRoteteAndScale(String imgPath) {
        // 先判断图片旋转角度属性
        int rotationAngle = readPictureDegree(imgPath);
        //获取对应的bitmap
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        Bitmap bitmap  = BitmapFactory.decodeFile(imgPath, options);
        //如果图片旋转角度属性非0，对bitmap旋转相应角度
        if(0 != rotationAngle)
        {
            //进行旋转
            bitmap = rotatingBitmap(rotationAngle, bitmap);
        }

        //进行缩放
        Bitmap resizebitmap = reduceBitmap(bitmap, 720);

        return resizebitmap;
    }

    /**
     * 读取图片属性：旋转的角度
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
    public static int readPictureDegree(String path) {
        int degree  = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 旋转图片
     * @param angle
     * @param bitmap
     * @return Bitmap
     */
    public static Bitmap rotatingBitmap(int angle , Bitmap bitmap) {
        //旋转图片 动作
        Matrix matrix = new Matrix();;
        matrix.postRotate(angle);
        // 创建新的图片
        Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return rotatedBitmap;
    }

    public static Bitmap reduceBitmap(Bitmap bitmap, int maxWeight)
    {
        Matrix matrix = new Matrix();
        float realWidth = bitmap.getWidth();
        float realHeight = bitmap.getHeight();
        float larger = (realWidth > realHeight) ? realWidth : realHeight;
        float scale = maxWeight / larger;
        if (scale >= 1) {
            scale = 1;
        }
        matrix.postScale(scale, scale);

        Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        return resizeBmp;
    }
}
