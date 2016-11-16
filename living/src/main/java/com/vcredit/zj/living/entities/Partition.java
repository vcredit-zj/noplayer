package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * 项目名称：noplayer
 * 类描述：模块分类信息
 * 创建人：伍跃武
 * 创建时间：2016/11/14 10:15
 */
public class Partition implements Serializable {
//    -- -- partition	object	单个的模块信息
//    id	String	地域id
//    area	String	所属区域标识
//    name	String	所属区域名称
//    img	String	图片链接地址
//    count	int	在线人数
//    -- -- lives	object	直播信息详情

    /**
     * 地域id
     */
    @Expose
    protected int id;
    /**
     * 所属区域标识
     */
    @Expose
    protected String area;
    /**
     * 所属区域名称
     */
    @Expose
    protected String name;
    /**
     * 图片链接地址
     */
    @Expose
    protected String img;
    /**
     * 在线人数
     */
    @Expose
    protected int count;

    /**
     * 分类图片信息
     */
    @Expose
    protected SubIcon sub_icon;

    /**
     * 直播信息
     */
    @Expose
    protected List<Live> lives;
}
