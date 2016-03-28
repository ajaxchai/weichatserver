package com.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.meta.WeixinUser;
import com.control.service.MenuService;
import com.control.service.UserService;
import com.control.util.AppTokenUtil;
import com.control.util.Log;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String logTag = "TestServlet";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String ACCESS_TOKEN = AppTokenUtil.getAccessToken();
    	
    	//send text message to user
    	UserService.sendTextMessagetoUser(ACCESS_TOKEN, "oNKqBswH0ghOvrFRMZqeW2mQp9SU", "TestServlet Send Text Message");
    	//get user information
    	WeixinUser user = UserService.getWeixinUserInfo(ACCESS_TOKEN, "oNKqBswH0ghOvrFRMZqeW2mQp9SU");
    	JSONObject userObj = JSONObject.fromObject(user);
    	Log.d(logTag, userObj.toString());
    	
    	//get users list
    	List<String> userOpenIdList = UserService.getWeixinUserList(ACCESS_TOKEN);
    	
    	for(String openId: userOpenIdList) {
    		WeixinUser tmpUser = UserService.getWeixinUserInfo(ACCESS_TOKEN, openId);
    		JSONObject tmpUserObj = JSONObject.fromObject(tmpUser);
    		Log.d(logTag, tmpUserObj.toString());
    		//UserService.sendTextMessagetoUser(ACCESS_TOKEN, openId, "机器人在和你说话");
    	}
    	
    	MenuService.createMenu(ACCESS_TOKEN);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
