package com.lichking.util.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.lichking.pojo.wechat.NewsMessage;
import com.lichking.pojo.wechat.TextMessage;
import com.lichking.pojo.wechat.co.NewsItem;
import com.thoughtworks.xstream.XStream;


/**
 * 用于和微信服务器传输的数据类型的转换生成操作操作
 * @author LichKing
 *
 */
public class MessageUtil {
	//消息类型常量
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_NEWS = "news";
	
	
	/**
	 * XML转成MAP集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> XmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	
	/**
	 * 文本消息转成XML
	 * @param text
	 * @return
	 */
	public static String TextMessageToXml(TextMessage text){
		XStream xstream  = new XStream();
		xstream.alias("xml", text.getClass());
		return xstream.toXML(text);
	}
	
	/**
	 * 生成文本消息的XML格式
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		long time = new Date().getTime();
		String strtime = String.valueOf(time);
		text.setCreateTime(strtime);
		text.setContent(content);
		return TextMessageToXml(text);
	}
	
	/**
	 * 图文消息转成XML
	 * @param news
	 * @return
	 */
	public static String NewsMessageToXml(NewsMessage news){
		XStream xstream  = new XStream();
		xstream.alias("xml", news.getClass());
		xstream.alias("item" , NewsItem.class );
		return xstream.toXML(news);
	}
	
	/**
	 * 生成图文消息的XML格式
	 * @param toUserName
	 * @param fromUserName
	 * @param l
	 * @return
	 */
	public static String initNews(String toUserName,String fromUserName,List<NewsItem> l){
		
		NewsMessage news = new NewsMessage();
		news.setFromUserName(toUserName);
		news.setToUserName(fromUserName);
		news.setMsgType(MESSAGE_NEWS);
		Date date = new Date();
		long time  = date.getTime();
		news.setCreateTime(String.valueOf(time));
		news.setArticleCount(l.size());
		news.setArticles(l);
		String result = NewsMessageToXml(news);
		
		return result;
	}
	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注...\n\n");
		//sb.append("1.机器人聊天\n");
		//sb.append("回复？调出此菜单\n");
		return sb.toString();
	}
}
