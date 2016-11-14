package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * 项目名称：noplayer
 * 类描述：直播信息数据封装类
 * 创建人：伍跃武
 * 创建时间：2016/11/14 10:29
 */
public class Live implements Serializable {

    //    accept_quality	int	展示的数量
    //    area	String	所属于区域
    //    area_id	int	所属于区域标识id
    //    broadcast_type	int	广播类型
    //    check_version	int	版本检查
    //    is_tv	int	是否为电视
    //    online	int	在线人数
    //    playurl	String	播放地址
    //    room_id	String	房间id地址
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
     * 展示的数量
     */
    @Expose
    protected int accept_quality;
    /**
     * 所属区域
     */
    @Expose
    protected String area;
    /**
     * 区域id
     */
    @Expose
    protected int area_id;
    /**
     * 广播类型
     */
    @Expose
    protected int broadcast_type;
    /**
     * 版本检查
     */
    @Expose
    protected int check_version;
    /**
     * 是否为电视类型
     */
    @Expose
    protected int is_tv;
    /**
     * 在线人数
     */
    @Expose
    protected int online;
    /**
     * 播放地址
     */
    @Expose
    protected String playurl;
    /**
     * 播放地址
     */
    @Expose
    protected int room_id;
    /**
     * 视频标题
     */
    @Expose
    protected String title;

    /**
     * 直播展示图信息
     */
    @Expose
    protected SubIcon cover;

    /**
     * 发布者信息
     */
    @Expose
    protected OwnerInfo owner;


    public int getAccept_quality() {
        return accept_quality;
    }

    public Live setAccept_quality(int accept_quality) {
        this.accept_quality = accept_quality;
        return this;
    }

    public String getArea() {
        return area;
    }

    public Live setArea(String area) {
        this.area = area;
        return this;
    }

    public int getArea_id() {
        return area_id;
    }

    public Live setArea_id(int area_id) {
        this.area_id = area_id;
        return this;
    }

    public int getBroadcast_type() {
        return broadcast_type;
    }

    public Live setBroadcast_type(int broadcast_type) {
        this.broadcast_type = broadcast_type;
        return this;
    }

    public int getCheck_version() {
        return check_version;
    }

    public Live setCheck_version(int check_version) {
        this.check_version = check_version;
        return this;
    }

    public int getIs_tv() {
        return is_tv;
    }

    public Live setIs_tv(int is_tv) {
        this.is_tv = is_tv;
        return this;
    }

    public int getOnline() {
        return online;
    }

    public Live setOnline(int online) {
        this.online = online;
        return this;
    }

    public String getPlayurl() {
        return playurl;
    }

    public Live setPlayurl(String playurl) {
        this.playurl = playurl;
        return this;
    }

    public int getRoom_id() {
        return room_id;
    }

    public Live setRoom_id(int room_id) {
        this.room_id = room_id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Live setTitle(String title) {
        this.title = title;
        return this;
    }

    public SubIcon getCover() {
        return cover;
    }

    public Live setCover(SubIcon cover) {
        this.cover = cover;
        return this;
    }

    public OwnerInfo getOwner() {
        return owner;
    }

    public Live setOwner(OwnerInfo owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public String toString() {
        return "Live{" +
                "accept_quality=" + accept_quality +
                ", area='" + area + '\'' +
                ", area_id=" + area_id +
                ", broadcast_type=" + broadcast_type +
                ", check_version=" + check_version +
                ", is_tv=" + is_tv +
                ", online=" + online +
                ", playurl='" + playurl + '\'' +
                ", room_id=" + room_id +
                ", title='" + title + '\'' +
                ", cover=" + cover +
                ", owner=" + owner +
                '}';
    }
}
