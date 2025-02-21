package tictactoe;

public class Board {
	private int size;
	private MarkEnum[][] boardGrid;
	private int positionsTaken;

	public Board(int size) {
		this.size = size;
		this.boardGrid = new MarkEnum[size][size];
		this.positionsTaken=0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public MarkEnum[][] getBoardGrid() {
		return boardGrid;
	}

	public void setBoardGrid(MarkEnum[][] boardGrid) {
		this.boardGrid = boardGrid;
	}

	public int getPositionsTaken() {
		return positionsTaken;
	}

	public void setPositionsTaken(int positionsTaken) {
		this.positionsTaken = positionsTaken;
	}

	public boolean isPositionAlreadyPlayed(int xPos, int yPos) {
		return boardGrid[xPos][yPos]!=null;
	}

	public void markPositionForPlayer(int xPos, int yPos, MarkEnum mark) {
		boardGrid[xPos][yPos]=mark;
		positionsTaken++;
	}

}
