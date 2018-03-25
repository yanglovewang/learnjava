package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns="/AServlet")
@MultipartConfig //这个注解加上才支持上传组件
public class AServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		/*
		 * 1. getParameter()方法可以使用了！！！
		 */
		String username = req.getParameter("username");//可以使用了！！！
		/*
		 * 2. 获取文件表单字段，对应的Part对象
		 */
		Part part = req.getPart("resume");
		
		/*
		 * 3. 从Part中获取需要的数据
		 */
		// 获取上传文件的MIME类型
		System.out.println(part.getContentType());
		// 获取上传文件的字节数
		System.out.println(part.getSize());
		// 获取文件字段名称
		System.out.println(part.getName());
		// 获取头，这个头中包含了上传文件的名称，然后可以自己去截取文件名
		System.out.println(part.getHeader("Content-Disposition"));
		// 保存上传文件
		part.write("C:/xxx.jpg");
		
		// 截取上传文件名称
		String filename = part.getHeader("Content-Disposition");
		int start = filename.lastIndexOf("filename=\"") + 10;
		int end = filename.length() - 1;
		filename = filename.substring(start, end);
		System.out.println(filename);
	}
}
