package com.control.service;

import java.util.List;

import com.control.meta.WeixinUser;
import com.control.util.AppTokenUtil;
import com.control.util.HttpUtil;
import com.control.util.Log;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserService {
	private static String logTag = "UserService";
	
	public static void sendTextMessagetoUser(String accessToken, String userOpenID, String textContent) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    	
    	url = url.replace("ACCESS_TOKEN", accessToken);
    	String str = "{ \"touser\": \"" + userOpenID +"\", \"msgtype\": \"text\", \"text\": { \"content\": \"" + textContent + "\" } }";
    	JSONObject jsonObject = HttpUtil.httpsRequest(url,"POST",str);
    	
    	Log.d(logTag,"errmsg="+jsonObject.get("errmsg"));
    	Log.d(logTag,"errcode="+jsonObject.get("errcode"));
	}
	
	public static WeixinUser getWeixinUserInfo(String accessToken, String openId) {
		WeixinUser userInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通过网页授权获取用户信息
		JSONObject jsonObject = HttpUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				userInfo = new WeixinUser();
				userInfo.setSubscribe(jsonObject.getInt("subscribe"));
				userInfo.setOpenid(jsonObject.getString("openid"));
				userInfo.setNickname(jsonObject.getString("nickname"));
				// 性别（1是男性，2是女性，0是未知）
				userInfo.setSex(jsonObject.getInt("sex"));
				userInfo.setLanguage(jsonObject.getString("language"));
				// 昵称
				userInfo.setCity(jsonObject.getString("city"));
				// 用户所在省份
				userInfo.setProvince(jsonObject.getString("province"));
				// 用户所在国家
				userInfo.setCountry(jsonObject.getString("country"));
				// 用户头像
				userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
				userInfo.setSubscribe_time(jsonObject.getString("subscribe_time"));
				userInfo.setUnionid(jsonObject.getString("unionid"));
				userInfo.setRemark(jsonObject.getString("remark"));
				userInfo.setGroupid(jsonObject.getString("groupid"));

			} catch (Exception e) {
				userInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				Log.e(logTag, "get user information error, errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		return userInfo;
	}
	
}
