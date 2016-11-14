package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * 项目名称：noplayer
 * 类描述：直播登录首页信息
 * 创建人：伍跃武
 * 创建时间：2016/11/14 9:48
 */
public class HomePageInfo implements Serializable {
//    -- banner	object	滚动条信息

//    -- entranceIcons	object	全部入口分类信息

//    -- partitions	object	全部模块分类信息
//    -- -- partition	object	单个的模块信息
//    id	String	标题
//    area	String	所属区域标识
//    name	String	所属区域名称
//    img	String	图片链接地址
//    count	int	在线人数
//    -- -- -- sub_icon	object	分类图片信息
//    src	String	分类图标链接地址
//    height	String	图片的宽
//    width	String	图片的高
//    -- -- lives	object	直播信息详情
//    accept_quality	int	展示的数量
//    area	String	所属于区域
//    area_id	int	所属于区域标识id
//    broadcast_type	int	广播类型
//    check_version	int	版本检查
//    is_tv	int	是否为电视
//    online	int	在线人数
//    playurl	String	播放地址
//    room_id	String	房间地址
//    title	String	视频标题
//    -- -- -- cover	object	视频展示图信息
//    height	int	展示图的高度
//    width	int	展示图的宽度
//    src	String	展示图的的链接
//    -- -- -- owner	object	发布者信息
//    face	String	发布者头像图片链接
//    mid	int	发布者id信息
//    name	String	发布者注册姓名

    /**
     * 滚动条信息
     */
    @Expose
    protected List<Banner> banner;
    /**
     * 全部入口分类信息
     */
    @Expose
    protected List<EntranceIcons> entranceIcons;
    /**
     * 全部模块分类信息
     */
    @Expose
    protected List<Partition> partitions;

    public List<Banner> getBanner() {
        return banner;
    }

    public HomePageInfo setBanner(List<Banner> banner) {
        this.banner = banner;
        return this;
    }

    public List<EntranceIcons> getEntranceIcons() {
        return entranceIcons;
    }

    public HomePageInfo setEntranceIcons(List<EntranceIcons> entranceIcons) {
        this.entranceIcons = entranceIcons;
        return this;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public HomePageInfo setPartitions(List<Partition> partitions) {
        this.partitions = partitions;
        return this;
    }

    @Override
    public String toString() {
        return "HomePageInfo{" +
                "banner=" + banner +
                ", entranceIcons=" + entranceIcons +
                ", partitions=" + partitions +
                '}';
    }
}
