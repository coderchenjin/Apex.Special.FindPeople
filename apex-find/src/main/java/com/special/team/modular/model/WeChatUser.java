package com.special.team.modular.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("wechat_user")
public class WeChatUser extends Model<WeChatUser> {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @TableField("open_id")
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
