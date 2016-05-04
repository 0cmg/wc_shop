package com.lichking.pojo.web;

public class OverviewDataVO {

	//今日营业额
	private double today_turnover;
	
	//相比昨天营业额
	private double tt_c;
	
	//本周营业额
	private double thisweek_turnover;
	
	//相比上周营业额
	private double twt_c;
	
	//今日订单数
	private Integer today_on;
	
	//相比昨天订单数
	private double to_c;
	
	//本周订单数
	private Integer thisweek_on;
	
	//相比上周订单数
	private double two_c;
	
	//今日访问量
	private Integer vn;
	
	//相比昨天访问量
	private double vn_c;
	

	public double getToday_turnover() {
		return today_turnover;
	}

	public void setToday_turnover(double today_turnover) {
		this.today_turnover = today_turnover;
	}

	public double getTt_c() {
		return tt_c;
	}

	public void setTt_c(double tt_c) {
		this.tt_c = tt_c;
	}

	public double getThisweek_turnover() {
		return thisweek_turnover;
	}

	public void setThisweek_turnover(double thisweek_turnover) {
		this.thisweek_turnover = thisweek_turnover;
	}

	public double getTwt_c() {
		return twt_c;
	}

	public void setTwt_c(double twt_c) {
		this.twt_c = twt_c;
	}

	public Integer getToday_on() {
		return today_on;
	}

	public void setToday_on(Integer today_on) {
		this.today_on = today_on;
	}

	public double getTo_c() {
		return to_c;
	}

	public void setTo_c(double to_c) {
		this.to_c = to_c;
	}

	public Integer getThisweek_on() {
		return thisweek_on;
	}

	public void setThisweek_on(Integer thisweek_on) {
		this.thisweek_on = thisweek_on;
	}

	public double getTwo_c() {
		return two_c;
	}

	public void setTwo_c(double two_c) {
		this.two_c = two_c;
	}

	public Integer getVn() {
		return vn;
	}

	public void setVn(Integer vn) {
		this.vn = vn;
	}

	public double getVn_c() {
		return vn_c;
	}

	public void setVn_c(double vn_c) {
		this.vn_c = vn_c;
	}
	
	
	
}
