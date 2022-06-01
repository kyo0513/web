package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp");
		dr.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");

		Health health=new Health();

		if(weight==null || weight.length()==0) {
			health.setWeight(0);
		}else {
		    health.setWeight(Double.parseDouble(weight));
		}

		if(height==null || height.length()==0) {
			health.setHeight(0);
		}else {
		    health.setHeight(Double.parseDouble(height));
		}

		//health.setHeight(Double.parseDouble(height));
		//health.setWeight(Double.parseDouble(weight));

		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
        healthCheckLogic.execute(health);

		request.setAttribute("health",health);

		RequestDispatcher dr =request.getRequestDispatcher("/WEB-INF/jsp/healthCheckResult.jsp");
		dr.forward(request, response);
	}

}
