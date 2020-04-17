package lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lab2/ClearCompleted")
public class ClearCompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClearCompleted() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Task> tasks = (ArrayList<Task>) getServletContext().getAttribute("tasks");
		for (Task task : tasks) {
			if (task.isDone == true) {
				tasks.remove(task);
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
