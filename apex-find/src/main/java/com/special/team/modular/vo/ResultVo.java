package com.special.team.modular.vo;

public class ResultVo {

    private String id;
    private String name;
    private String nameEn;
    private String tel;
    private String email;
    private String company;
    private String position;
    private String hobby;
    private String status;
    private String project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", hobby='" + hobby + '\'' +
                ", status='" + status + '\'' +
                ", project='" + project + '\'' +
                '}';
    }
}
