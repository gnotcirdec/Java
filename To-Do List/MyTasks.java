package lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.examples.GuestBookEntry;

@WebServlet("/Lab2/MyTasks")
public class MyTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyTasks() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// create some test data for display
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("hello"));
		tasks.add(new Task("hi"));

		Task.numberOfTasksCreated = 2;

		// stored the data somewhere that can be accessed by this servlet
		// and other servlets.
		getServletContext().setAttribute("tasks", tasks);
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data
		ArrayList<Task> tasks = (ArrayList<Task>) getServletContext().getAttribute("tasks");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>To-Do List</title>" + "<meta charset=\"UTF-8\">"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">"
				+ "</head><body>");
		out.println("<div class=\"container\">");
		out.println("<h1>To Do <small>CS 320</small></h1>");
		out.println("<table class=\"table table-striped table-bordered\">" + "		<tr>");
		out.println("	<th>Name</th>" + "		<th>Actions</th>" + "		</tr>");
		// Create tables through data entry
		for (Task task : tasks) {
			if (task.isDone == false) {
				out.println("<tr>");
				out.println("<td>" + task.getDetails() + "</td>");
				out.println("	<td>");
				out.println("		<a href='CheckIfDone?id=" + task.getId() + "'>Mark as Done </a> ");
			} else {
				out.println("<tr><td><s> " + task.getDetails() + " </s></td> ");
				out.println("	<td><a href='ToggleCompletion?id=" + task.getId() + "'>Mark as NOT DONE </a>");
			}
			out.println("" + '|' + "");
			out.println("		<a href='DeleteTask?id=" + task.getId() + "'> Delete</a>");
			out.println("	</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<p class=\"text-right\">");
		out.println("		<a href='ClearCompleted'>Remove All Completed Tasks</a>");
		out.println("</p>");
		out.println("<hr /><h3>Add Task</h3>");
		out.println("<form method=\"post\" action=\"AddTask\">"
				+ "		<input class=\"form-control\"  type=\"text\" name=\"details\" placeholder=\"Enter task details\" />"
				+ "		<input class=\"btn btn-success\" type=\"submit\" value=\"Add Task\" />" + "</form>");
		out.println("</div>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
