package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * 项目名称：noplayer
 * 类描述： 入口分类信息
 * 创建人：伍跃武
 * 创建时间：2016/11/14 10:24
 */
public class SubIcon implements Serializable {
    //    -- -- -- sub_icon	object	分类图片信息
    //    src	String	分类图标链接地址
    //    height	String	图片的宽
    //    width	String	图片的高
    /**
     * 图片链接地址
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
    @Expose
    protected int width;

    public String getSrc() {
        return src;
    }

    public SubIcon setSrc(String src) {
        this.src = src;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public SubIcon setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public SubIcon setWidth(int width) {
        this.width = width;
        return this;
    }

    @Override
    public String toString() {
        return "SubIcon{" +
                "src='" + src + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
