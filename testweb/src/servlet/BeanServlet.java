package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BeanServlet() {
        super();
        
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		super.service(request, response);
		/*
		 * 利用反射来调用方法
		 * 判断传参
		 */
		String methodName = request.getParameter("method");
		if(methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("你没有传入参数 , 或者参数值不是method");
		}
		/*
		 * 判断方法
		 */
		Class c = this.getClass();
		Method method = null;
		try {
			method = c.getMethod(methodName, 
					HttpServletRequest.class , HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("你查找的方法不存在");
		} 
		
		/*
		 * 反射调用调用方法
		 */
		
		try {
			method.invoke(this, request , response);
		} catch (Exception e) {
			System.out.println("你调用的方法内部出现异常");
			throw new RuntimeException(e);
			
		} 
 
	}
	/*
	 * 通过传参数调用方法
	 */
	protected void function1(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("this is function1");

	}
	
	protected void function2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("this is function1");

	}
}




