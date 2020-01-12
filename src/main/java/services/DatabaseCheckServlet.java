package services;

import services.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DatabaseCheckServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("/home/viacheslav/test.txt");

		try (FileWriter fileWriter = new FileWriter(file, true)) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if (!Database.doesExist(username, password, file)) {
				fileWriter.append(request.getParameter("username") + "," + request.getParameter("password") + "\n");
				getServletContext().getRequestDispatcher("/registered.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/signed-in.jsp").forward(request, response);
			}

		} catch (Exception e) {
			response.sendRedirect("/error.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
