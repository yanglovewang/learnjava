package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import util.ResponseUtil;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("modifyPwd")) {
			try {
				modifyPwd(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String reNewPwd = request.getParameter("reNewPwd");
		JSONObject jsonObject = new JSONObject();
		if(!oldPwd.equals("123456")) {
			jsonObject.put("message", "密码输入出错");
		} else {
			jsonObject.put("message", "密码修改成功");
		}
		
		ResponseUtil.write(response, jsonObject);
	}

}
