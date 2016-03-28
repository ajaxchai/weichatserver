package com.control.util;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class AppTokenUtil {
	private static String logTag = "AppTokenUtil";

	private static String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static String getAccessToken(String appid, String appsecret) {  
    	String accessToken = null;  
      
        String requestUrl = accessTokenUrl.replace("APPID", appid).replace("APPSECRET", appsecret);  
        JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {  
            try {  
            	accessToken = jsonObject.getString("access_token");
            } catch (JSONException e) {  
                accessToken = null;   
                Log.e(logTag, "get token error errcode:" + jsonObject.getInt("errcode") + "errmsg:" + jsonObject.getString("errmsg"));  
            }
        }  
        return accessToken;  
    }  
	
	public static String getAccessToken() {
		return getAccessToken("wx5ca5a605d0d6b7e1","9616e8c75f0ee4822862dba501398e89");
	}
	
}
