package dao;

import java.io.IOException;

import dto.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class MyLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Mydao dao = new Mydao();
		Customer customer = dao.fetchByEmail(email);
		if (customer == null) {
			resp.getWriter().print("<h1 style='color:red'>invalid email</h1>");
		} else {
			if (pass.equals(customer.getPassword())) {
				resp.getWriter().print("<h1 style='color:red'>Login Successs</h1>");
			} else {
				resp.getWriter().print("<h1 style='color:red'>Invalid Password</h1>");

			}
		}
	}
}
