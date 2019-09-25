package com.special.team.modular.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

public class UserProject extends Model<UserProject> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一号
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private String Id;
    private String UserId;
    private String ProjectId;
    private String RoleType;
    private Date CreateTime;
    private Date UpdateTime;
    private String CreateBy;
    private String UpdateBy;


    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getProjectId() {
        return ProjectId;
    }

    public void setProjectId(String ProjectId) {
        this.ProjectId = ProjectId;
    }

    public String getRoleType() {
        return RoleType;
    }

    public void setRoleType(String RoleType) {
        this.RoleType = RoleType;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date CreateTime) {
        this.CreateTime = CreateTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String CreateBy) {
        this.CreateBy = CreateBy;
    }

    public String getUpdateBy() {
        return UpdateBy;
    }

    public void setUpdateBy(String UpdateBy) {
        this.UpdateBy = UpdateBy;
    }

    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

    @Override
    public String toString() {
        return "SUserproject{" +
                "Id=" + Id +
                ", UserId=" + UserId +
                ", ProjectId=" + ProjectId +
                ", RoleType=" + RoleType +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", CreateBy=" + CreateBy +
                ", UpdateBy=" + UpdateBy +
                "}";
    }
}
