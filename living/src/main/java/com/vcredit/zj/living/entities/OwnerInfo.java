package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * 项目名称：noplayer
 * 类描述：发布者信息
 * 创建人：伍跃武
 * 创建时间：2016/11/14 10:40
 */
public class OwnerInfo implements Serializable {
    //    face	String	发布者头像图片链接
    //    mid	int	发布者id信息
    //    	String	发布者注册姓名

    /**
     * 发布者头像图片链接
     */
    @Expose
    protected String face;

    /**
     * 发布者id信息
     */
    @Expose
    protected int mid;

    /**
     * 发布者注册姓名
     */

    @Expose
    protected String name;


    public String getName() {
        return name;
    }

    public OwnerInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getFace() {
        return face;
    }

    public OwnerInfo setFace(String face) {
        this.face = face;
        return this;
    }

    public int getMid() {
        return mid;
    }

    public OwnerInfo setMid(int mid) {
        this.mid = mid;
        return this;
    }

    @Override
    public String toString() {
        return "OwnerInfo{" +
                "face='" + face + '\'' +
                ", mid=" + mid +
                ", name='" + name + '\'' +
                '}';
    }
}
