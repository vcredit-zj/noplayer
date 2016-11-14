package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * 项目名称：noplayer
 * 类描述： 滚动条信息
 * 创建人：伍跃武
 * 创建时间：2016/11/14 9:51
 */
public class Banner implements Serializable {
//    title	String	标题
//    img	String	图片链接地址
//    remark	String	描述
//    link	String	详情链接地址

    /**
     * 标题
     */
    @Expose
    protected String title;

    /**
     * 图片链接地址
     */
    @Expose
    protected String img;
    /**
     * 描述
     */
    @Expose
    protected String remark;
    /**
     * 详情链接地址
     */
    @Expose
    protected String link;

    public String getLink() {
        return link;
    }

    public Banner setLink(String link) {
        this.link = link;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Banner setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImg() {
        return img;
    }

    public Banner setImg(String img) {
        this.img = img;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Banner setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", remark='" + remark + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
