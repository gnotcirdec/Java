package lab2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Lab2/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTask() {
		super();

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ArrayList<Task> task = (ArrayList<Task>) getServletContext().getAttribute("tasks");
		String details = (String) session.getAttribute("details");
		if (details == null) {
			details = request.getParameter("details");
			// save in session
			session.setAttribute("task", details);
		}
		Task tasks = new Task(details);
		task.add(tasks);
		Task.numberOfTasksCreated++;
		
		response.sendRedirect("/cs320stu25/Lab2/MyTasks");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
