package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String age  = request.getParameter("age");

		int result;
		if(age == null ||age.length() ==0) {
			result = 0;
		}else
			result = Integer.parseInt(age) *7;{
		}
		String msg = name+"("+age+"歳)は人間に換算すると" + result +"歳です。";

	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset=\"UTF-8\">");
	out.println("<title>ユーザー登録結果</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<p>" +msg+ "</p>");

	out.println("<a href='/dogAge/index.jsp'>戻る</a><br>");

	out.println("<form action = '/dogAge/index.jsp' method='get'>");
	out.println("<input type=\"submit\" value=\"戻る\">");
	out.println("</form>");

	out.println("</body>");
	out.println("</html>");

	}
}
