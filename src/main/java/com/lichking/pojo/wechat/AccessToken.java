package com.lichking.pojo.wechat;

/**
 * 保存AccessToken的数据类型
 * AccessToken是调用微信接口的凭证
 * @author LichKing
 *
 */
public class AccessToken {

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	private String token;
	private int expiresIn;
	
	
}
