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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action.equals("modifyUser")) {
			modifyUser(request, response);
		} else if(action.equals("saveUser")) {
			try {
				saveUser(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		JSONObject o = new JSONObject();
		if(userName != null) {
			o.put("message", "success");
			o.put("userName", userName);
		} else {
			o.put("message", "error");
		}
		ResponseUtil.write(response, o);
		
	}


	private void modifyUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("modify");
		
	}

}
