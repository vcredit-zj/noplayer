package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * 项目名称：noplayer
 * 类描述：入口信息数据封装类
 * 创建人：伍跃武
 * 创建时间：2016/11/14 10:10
 */
public class EntranceIcon implements Serializable {
    //    src	String	入口图标链接地址
    //    height	String	图片的宽
    //    width	String	图片的高

    /**
     * 入口图标链接地址
     */
    @Expose
    protected String src;
    /**
     * 图片的宽
     */
    @Expose
    protected int height;
    /**
     * 图片的高
     */
    protected int width;

    public String getSrc() {
        return src;
    }

    public EntranceIcon setSrc(String src) {
        this.src = src;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public EntranceIcon setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public EntranceIcon setWidth(int width) {
        this.width = width;
        return this;
    }

    @Override
    public String toString() {
        return "EntranceIcon{" +
                "src='" + src + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
