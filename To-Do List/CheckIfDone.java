package lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lab2/CheckIfDone")
public class CheckIfDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckIfDone() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		ArrayList<Task> tasks = (ArrayList<Task>) getServletContext().getAttribute("tasks");
		int id = Integer.parseInt(request.getParameter("id"));
		for (Task task : tasks) {
			if (task.getId() == id) {
					task.isDone = true;
					break;
			}
		}
		response.sendRedirect("/cs320stu25/Lab2/MyTasks");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
