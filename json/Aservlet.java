package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;



@WebServlet("/Aservlet")
public class Aservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = request.getParameter("data");
		JSONObject obj = JSONObject.fromObject(data);
		System.out.println(obj.get("name"));
		PrintWriter out = response.getWriter();
		JSONObject obj2 = new JSONObject();
		obj2.put("yang", "chengju");
		obj2.put("wang", "menwei");
		out.println(obj2);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
