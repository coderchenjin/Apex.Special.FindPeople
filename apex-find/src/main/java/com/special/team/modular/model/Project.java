package com.special.team.modular.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

public class Project extends Model<Project> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private String Id;
    /**
     * 项目名称
     */
    private String ProjectName;
    /**
     * 项目Code
     */
    private String PorjectCode;
    /**
     * 开始 时间
     */
    private Date BeginDate;
    /**
     * 结束时间
     */
    private Date EndDate;
    /**
     * 项目描述
     */
    private String ProjectDescribe;
    private String OpenedBy;
    private Date OpenedDate;
    private String OpenedVersion;
    private String ClosedBy;
    private Date ClosedDate;
    private String CanceledBy;
    private Date CanceledDate;
    private String ProjectStatus;
    @TableField("PO")
    private String po;
    @TableField("PM")
    private String pm;
    @TableField("QD")
    private String qd;
    @TableField("RD")
    private String rd;
    private String Team;


    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getPorjectCode() {
        return PorjectCode;
    }

    public void setPorjectCode(String PorjectCode) {
        this.PorjectCode = PorjectCode;
    }

    public Date getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(Date BeginDate) {
        this.BeginDate = BeginDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getProjectDescribe() {
        return ProjectDescribe;
    }

    public void setProjectDescribe(String ProjectDescribe) {
        this.ProjectDescribe = ProjectDescribe;
    }

    public String getOpenedBy() {
        return OpenedBy;
    }

    public void setOpenedBy(String OpenedBy) {
        this.OpenedBy = OpenedBy;
    }

    public Date getOpenedDate() {
        return OpenedDate;
    }

    public void setOpenedDate(Date OpenedDate) {
        this.OpenedDate = OpenedDate;
    }

    public String getOpenedVersion() {
        return OpenedVersion;
    }

    public void setOpenedVersion(String OpenedVersion) {
        this.OpenedVersion = OpenedVersion;
    }

    public String getClosedBy() {
        return ClosedBy;
    }

    public void setClosedBy(String ClosedBy) {
        this.ClosedBy = ClosedBy;
    }

    public Date getClosedDate() {
        return ClosedDate;
    }

    public void setClosedDate(Date ClosedDate) {
        this.ClosedDate = ClosedDate;
    }

    public String getCanceledBy() {
        return CanceledBy;
    }

    public void setCanceledBy(String CanceledBy) {
        this.CanceledBy = CanceledBy;
    }

    public Date getCanceledDate() {
        return CanceledDate;
    }

    public void setCanceledDate(Date CanceledDate) {
        this.CanceledDate = CanceledDate;
    }

    public String getProjectStatus() {
        return ProjectStatus;
    }

    public void setProjectStatus(String ProjectStatus) {
        this.ProjectStatus = ProjectStatus;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    @Override
    protected Serializable pkVal() {
        return this.Id;
    }

    @Override
    public String toString() {
        return "SProject{" +
                "Id=" + Id +
                ", ProjectName=" + ProjectName +
                ", PorjectCode=" + PorjectCode +
                ", BeginDate=" + BeginDate +
                ", EndDate=" + EndDate +
                ", ProjectDescribe=" + ProjectDescribe +
                ", OpenedBy=" + OpenedBy +
                ", OpenedDate=" + OpenedDate +
                ", OpenedVersion=" + OpenedVersion +
                ", ClosedBy=" + ClosedBy +
                ", ClosedDate=" + ClosedDate +
                ", CanceledBy=" + CanceledBy +
                ", CanceledDate=" + CanceledDate +
                ", ProjectStatus=" + ProjectStatus +
                ", po=" + po +
                ", pm=" + pm +
                ", qd=" + qd +
                ", rd=" + rd +
                ", Team=" + Team +
                "}";
    }

}
