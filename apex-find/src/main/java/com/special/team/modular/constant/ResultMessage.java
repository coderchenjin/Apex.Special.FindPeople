package com.special.team.modular.constant;

public class ResultMessage<T>{
	private int   code;
	private  T    body;
	private String message;
	
	private ResultMessage(T body) {  
        this.code = CodeConstants.SUCCESS.getCode();  
        this.message = CodeConstants.SUCCESS.getBody();  
        this.body = body;  
    }  
	
	
	private ResultMessage(CodeConstants codeCont) {
		if(codeCont == null) {
			return ;
		}
		 this.code = codeCont.getCode();
	     this.message = codeCont.getBody(); 
	}
	
	private ResultMessage(int code,String message) {
		 this.code = code;
	     this.message = message; 
	}
	
    /**  
     * 成功时候的调用  
     * 
     */  
    public static <T> ResultMessage<T> success(T body){  
        return new ResultMessage<T>(body);  
    }  
    
    /**  
     * 成功时候的调用  
     * 
     */  
    public static <T> ResultMessage<T> success(CodeConstants codeCont){  
        return new ResultMessage<T>(codeCont);  
    } 
    /**  
     * 成功，不需要传入参数  
     *  
     */  
    @SuppressWarnings("unchecked")  
    public static <T> ResultMessage<T> success(){  
        return (ResultMessage<T>) success("");  
    }  
    /**  
     * 失败时候的调用  
     *
     */  
    public static <T> ResultMessage<T> error(CodeConstants codeCont){  
        return new ResultMessage<T>(codeCont);  
    }  
    /**  
     * 失败时候的调用,扩展消息参数  
     * 
     */  
    public static <T> ResultMessage<T> error(CodeConstants codeCont,String msg){  
    	codeCont.setBody(msg);  
        return new ResultMessage<T>(codeCont);  
    }


    /**
     * 失败时候的调用,扩展消息参数   
     * @param code
     * @param msg
     * @return
     */
    public static <T> ResultMessage<T> error(int code,String msg){  
        return new ResultMessage<T>(code,msg);  
    }
    
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public T getBody() {
		return body;
	}


	public void setBody(T body) {
		this.body = body;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}  


}
