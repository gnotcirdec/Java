package lab2;

public class Task {

	static int numberOfTasksCreated = 0;

	int id;
	String details;
	boolean isDone;

	public Task(String details) {
		this.id = numberOfTasksCreated++;
		this.details = details;
		this.isDone = false;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

}
