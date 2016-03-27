package com.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.meta.WeixinUser;
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
	
    	String ACCESS_TOKEN = AppTokenUtil.getAccessToken("wx5ca5a605d0d6b7e1","9616e8c75f0ee4822862dba501398e89");
    	UserService.sendTextMessagetoUser(ACCESS_TOKEN, "oNKqBswH0ghOvrFRMZqeW2mQp9SU", "TestServlet Send Text Message");
    	WeixinUser user = UserService.getWeixinUserInfo(ACCESS_TOKEN, "oNKqBswH0ghOvrFRMZqeW2mQp9SU");
    	
    	JSONObject userObj = JSONObject.fromObject(user);
    	Log.d(logTag, userObj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
