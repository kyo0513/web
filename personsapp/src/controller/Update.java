package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonsDAO;
import model.Persons;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id=request.getParameter("id");
		if(s_id==null) {
			response.sendRedirect("/personsapp/Read");
		}else {
			PersonsDAO dao =new PersonsDAO();
			Persons persons=dao.findOne(Integer.parseInt(s_id));
			request.setAttribute("persons", persons);
			request.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		Persons persons=new Persons(Integer.parseInt(id),name,Integer.parseInt(age));
		PersonsDAO dao=new PersonsDAO();
		dao.updateOne(persons);
		response.sendRedirect("/personsapp/Read");


	}

}

