package com.lichking.logicalprocessor;

import java.io.IOException;
import java.util.Date;



import org.apache.http.ParseException;

import net.sf.json.JSONObject;

import com.lichking.pojo.dic.KeyDic;
import com.lichking.pojo.dic.MenuDic;
import com.lichking.pojo.dic.UrlDic;
import com.lichking.pojo.wechat.Menu;
import com.lichking.pojo.wechat.button.Button;
import com.lichking.pojo.wechat.button.ClickButton;
import com.lichking.pojo.wechat.button.ViewButton;
import com.lichking.util.wcapi.AccessTokenI;
import com.lichking.util.wcapi.MenuOptionI;

/**
 * 菜单处理器
 * @author LichKing
 *
 */
public class MenuProcessor {

	
	public static void doMenuProcess(){
		try {
			String token = AccessTokenI.getAccessToken().getToken();
			JSONObject jsonObject = null;
			jsonObject = MenuOptionI.queryMenu(token);
			create(jsonObject,token);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void create(JSONObject jsonObject,String token){
		System.out.println(jsonObject.get("menu").toString());
		if(jsonObject == null || jsonObject.get("menu") == null ){
			//System.out.println("--------");
			Menu menu = new Menu();
			
			ViewButton button1 = new ViewButton();
			button1.setType(MenuOptionI.VIEW);
			button1.setName(MenuDic.SHOP_INDEX_NAME);
			button1.setUrl(UrlDic.SHOP_INDEX_URL);
			
			ClickButton button21 = new ClickButton();
			button21.setType(MenuOptionI.CLICK);
			button21.setName(MenuDic.ODER_QUERY);
			button21.setKey(KeyDic.ODER_QUERY_KEY);
			
			ClickButton button22 = new ClickButton();
			button22.setType(MenuOptionI.CLICK);
			button22.setName(MenuDic.EXPRESS_QUERY);
			button22.setKey(KeyDic.EXPRESS_QUERY_KEY);
			
			ViewButton button23 = new ViewButton();
			button23.setType(MenuOptionI.VIEW);
			button23.setName(MenuDic.ADDRESS_MANAGE);
			button23.setUrl(UrlDic.ADDRESS_MANAGE_URL);
			
			Button button2 = new Button();
			button2.setName(MenuDic.MENU_1);
			button2.setSub_button(new Button[]{button21,button22,button23});
			
			menu.setButton(new Button[]{button1,button2});
			
			int errcode = 0;
			try {
				errcode = MenuOptionI.createMenu(token, menu);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(errcode);
			if(errcode == 0){
				System.out.println(new Date()+"  创建菜单成功");
			}else{
				System.out.println(new Date()+"  创建菜单失败");
			}
		}
	}
}
