package com.special.team.modular.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@TableName("s_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一号
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private String Id;
    /**
     * 姓名
     */
    private String Name;
    /**
     * 英文名
     */
    private String NameEn;
    /**
     * 邮箱
     */
    private String Email;
    /**
     * 电话
     */
    private String Tel;
    /**
     * 公司
     */
    private String Company;
    /**
     * 部门
     */
    private String Department;
    /**
     * 二级部门
     */
    private String DepartmentBranch;
    /**
     * 职位
     */
    private String Position;
    /**
     * 工作地点
     */
    private String WorkingLocation;
    /**
     * 直线
     */
    private String DirectNumber;
    /**
     * 分机号
     */
    private String ExtensionNumber;
    /**
     * 简介
     */
    private String Introduction;
    /**
     * 0离职；1：在职
     */
    private Boolean Status;
    /**
     * 是否激活
     */
    private Boolean Activated;
    private String OpenId;


    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNameEn() {
        return NameEn;
    }

    public void setNameEn(String NameEn) {
        this.NameEn = NameEn;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getDepartmentBranch() {
        return DepartmentBranch;
    }

    public void setDepartmentBranch(String DepartmentBranch) {
        this.DepartmentBranch = DepartmentBranch;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getWorkingLocation() {
        return WorkingLocation;
    }

    public void setWorkingLocation(String WorkingLocation) {
        this.WorkingLocation = WorkingLocation;
    }

    public String getDirectNumber() {
        return DirectNumber;
    }

    public void setDirectNumber(String DirectNumber) {
        this.DirectNumber = DirectNumber;
    }

    public String getExtensionNumber() {
        return ExtensionNumber;
    }

    public void setExtensionNumber(String ExtensionNumber) {
        this.ExtensionNumber = ExtensionNumber;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public Boolean getActivated() {
        return Activated;
    }

    public void setActivated(Boolean Activated) {
        this.Activated = Activated;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String OpenId) {
        this.OpenId = OpenId;
    }

    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

    @Override
    public String toString() {
        return "SUser{" +
                "Id=" + Id +
                ", Name=" + Name +
                ", NameEn=" + NameEn +
                ", Email=" + Email +
                ", Tel=" + Tel +
                ", Company=" + Company +
                ", Department=" + Department +
                ", DepartmentBranch=" + DepartmentBranch +
                ", Position=" + Position +
                ", WorkingLocation=" + WorkingLocation +
                ", DirectNumber=" + DirectNumber +
                ", ExtensionNumber=" + ExtensionNumber +
                ", Introduction=" + Introduction +
                ", Status=" + Status +
                ", Activated=" + Activated +
                ", OpenId=" + OpenId +
                "}";
    }
}

