package tictactoe;

public class Player {
	private int id;
	private MarkEnum assignedMark;

	public Player(int id, MarkEnum assignedMark) {
		this.id = id;
		this.assignedMark = assignedMark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MarkEnum getAssignedMark() {
		return assignedMark;
	}

	public void setAssignedMark(MarkEnum assignedMark) {
		this.assignedMark = assignedMark;
	}

}
