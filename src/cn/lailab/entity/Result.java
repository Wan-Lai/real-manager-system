package cn.lailab.entity;

public class Result {
	// 返回代码
	int code;
	// 返回值
	String message;

	public Result() {
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "{code=" + code + ", message=" + message + "}";
	}
}
