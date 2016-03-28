package com.control.service;

import com.control.util.HttpUtil;
import com.control.util.Log;

import net.sf.json.JSONObject;

public class MenuService {

	private static String logTag = "MenuService";
	
	public static void createMenu(String accessToken) {
		String requestURL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		requestURL = requestURL.replace("ACCESS_TOKEN", accessToken);
		
		String str = "{\"button\":[{\"name\":\"扫码\",\"sub_button\":[{\"type\":\"scancode_waitmsg\",\"name\":\"扫码带提示\",\"key\":\"rselfmenu_0_0\",\"sub_button\":[]},{\"type\":\"scancode_push\",\"name\":\"扫码推事件\",\"key\":\"rselfmenu_0_1\",\"sub_button\":[]}]},{\"name\":\"发图\",\"sub_button\":[{\"type\":\"pic_sysphoto\",\"name\":\"系统拍照发图\",\"key\":\"rselfmenu_1_0\",\"sub_button\":[]},{\"type\":\"pic_photo_or_album\",\"name\":\"拍照或者相册发图\",\"key\":\"rselfmenu_1_1\",\"sub_button\":[]},{\"type\":\"pic_weixin\",\"name\":\"微信相册发图\",\"key\":\"rselfmenu_1_2\",\"sub_button\":[]}]},{\"name\":\"发送位置\",\"type\":\"location_select\",\"key\":\"rselfmenu_2_0\"}]}";
		
    	JSONObject jsonObject = HttpUtil.httpsRequest(requestURL,"POST",str);
    	
    	Log.d(logTag,"errmsg="+jsonObject.get("errmsg"));
    	Log.d(logTag,"errcode="+jsonObject.get("errcode"));
	}
}
