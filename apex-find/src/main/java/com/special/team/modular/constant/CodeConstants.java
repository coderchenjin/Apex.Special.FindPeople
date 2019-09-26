package com.special.team.modular.constant;

/**
 * 页面返回常亮状态
 */
public enum CodeConstants {

  
    
    SUCCESS(100,"操作成功"),
    LOGIN_ERROR(112,"登陆用户名或密码错误"),
	PARAM_ERROR(108,"参数错误"),
	NO_AUTH(112,"没有权限"),
	DATA_ERROR(113,"提交数据错误"),
	SERVICE_ERROR(999,"系统错误"),
	NO_LOGIN(111,"未登陆"),
	
	USEREXITS(405,"用户名存在"),
	USERNULL(404,"用户名或密码为空"),
	USERNAME(406,"用户名不合理，必须为4-12位数字或者字母"),
	PASSWORD(406,"密码不合理，必须为6-12位数字或者字母"),
	COMPANY_YES(406,"该公司已经注册"),
	/**
	 * 其他
	 */
	WRITE_ERROR(502,"渲染界面错误"),
	ERROR_WRAPPER_FIELD(501,"包装字典属性失败"),
	UPLOAD_ERROR(500,"上传失败"),
	UPLOAD_SIZEERROR(500,"上传文件过大,请上传1M以内的图片"),
    DECLARECHANGE_ERROR(114,"不能变更"),
    DECLAREUPDATE_ERROR(114,"不能修改"),
    ALREADYDECLARE(115,"已申报,不要重复申报"),
   
    DECLAREDELETE_ERROR(114,"不能删除"),
    CHANGE_SUCCESS(101,"变更成功"),
    HANDLE_ERROR(111,"不能新增,请修改变更"),
    DECLARE_ERROR(500,"申报失败"),
    DECLARE_LOADINGERROR(116,"您有数据正在审核中"),
    VEHICLEDECLARE_LOADINGERROR(116,"该车辆正在备案审核中或备案成功"),
    HSCODE_ILLEGAL(201,"非法的HSCODE错误"),
    CHECK_SUCCESS(114,"该数据已审核过"),
    VEHICLE_SUCCESS(114,"该车辆已经备案成功,不能重复备案该车辆"), 
    UPLOADTYPE_ERROR(500,"请上传jpg,png,gif类型图片"),
    
    GATEAPPLY_ALREADY(301,"不要重复提交申报"),
    GATEAPPLY_DELETED(302,"已经申报的数据不能删除"),
    GATECHECK_REPEAT(303,"当前预约已经审核"),
    
    GATEOUT_FAIL(401,"出卡失败"),
    GATEOUT_INFO(402,"出卡信息错误，未扫描到车辆出卡信息"),
    GATEOUT_ENTRY(403,"请将卡车入卡"),
    

	/**
	 * 文件上传
	 */
	FILE_READING_ERROR(401,"FILE_READING_ERROR!"),
	FILE_NOT_FOUND(400,"FILE_NOT_FOUND!");
	
    public Integer code;
    public String body;
    
    CodeConstants(Integer code,String body) {
    	this.code=code;
    	this.body=body;
    }
    
    
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
    
    
    
    
    
}
