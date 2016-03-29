package com.lichking.pojo.wechat;

import java.util.List;

import com.lichking.pojo.wechat.co.NewsItem;
/**
 * 图文消息类型的数据结构  用来生成图文消息的xml格式
 * @author LichKing
 *
 */
public class NewsMessage {

	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<NewsItem> getArticles() {
		return Articles;
	}
	public void setArticles(List<NewsItem> articles) {
		Articles = articles;
	}
	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private int ArticleCount;
	private List<NewsItem> Articles;
	
	
}
