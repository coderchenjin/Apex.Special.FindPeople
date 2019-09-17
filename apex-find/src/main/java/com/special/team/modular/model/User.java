package com.special.team.modular.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 账号
     */
    @NotBlank(message = "account require")
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * md5密码盐
     */
    private String salt;
    /**
     * 名字
     */
    private String name;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     * 角色id
     */
    private String roleid;
    /**
     * 部门id
     */
    private Integer deptid;

    /**
     * 公司id
     */
    private Integer companyId;

    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 保留字段
     */
    private Integer version;

    /**
     * 是否经理0不是1是
     */
    private Integer ismanager;

    /**
     * 是否经理0不是1是
     */
    private String fngroup;

    @TableField(exist=false)
    private String type="1";//1 apex  2truck

    @TableField("hp_type")
    private String hpType;

    @TableField("hp_consignee_name")
    private String hpConsigneeName;

    public String getHpType() {
        return hpType;
    }

    public void setHpType(String hpType) {
        this.hpType = hpType;
    }

    public String getHpConsigneeName() {
        return hpConsigneeName;
    }

    public void setHpConsigneeName(String hpConsigneeName) {
        this.hpConsigneeName = hpConsigneeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }




    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }


    public Integer getIsmanager() {
        return ismanager;
    }

    public void setIsmanager(Integer ismanager) {
        this.ismanager = ismanager;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }




    public String getFngroup() {
        return fngroup;
    }

    public void setFngroup(String fngroup) {
        this.fngroup = fngroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatar=" + avatar +
                ", account=" + account +
                ", password=" + password +
                ", salt=" + salt +
                ", name=" + name +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", email=" + email +
                ", phone=" + phone +
                ", roleid=" + roleid +
                ", deptid=" + deptid +
                ", status=" + status +
                ", createtime=" + createtime +
                ", version=" + version +
                "}";
    }
}

