package com.vcredit.zj.living.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * 项目名称：noplayer
 * 类描述：全部入口分类信息
 * 创建人：伍跃武
 * 创建时间：2016/11/14 9:57
 */
public class EntranceIcons implements Serializable {
    //    id	int	入口分类标识
    //    name	String	入口名称
    //    -- -- entrance_icon	object	入口图片信息
    /**
     * 入口id
     */
    @Expose
    protected String id;
    /**
     * 入口名称
     */
    @Expose
    protected String name;

    /**
     * 入口图片信息
     */
    @Expose
    protected EntranceIcon entrance_icon;

    public String getId() {
        return id;
    }

    public EntranceIcons setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EntranceIcons setName(String name) {
        this.name = name;
        return this;
    }

    public EntranceIcon getEntrance_icon() {
        return entrance_icon;
    }

    public EntranceIcons setEntrance_icon(EntranceIcon entrance_icon) {
        this.entrance_icon = entrance_icon;
        return this;
    }

    @Override
    public String toString() {
        return "EntranceIcons{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", entrance_icon=" + entrance_icon +
                '}';
    }
}
