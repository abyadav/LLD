package tictactoe;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
	private Board board;
	Deque<Player> playersQueue;

	public Game() {
		initializeGame();
	}

	private void initializeGame() {

		this.board = new Board(3);
		playersQueue = new ArrayDeque<Player>();

		Player player1 = new Player(1, MarkEnum.X);
		Player player2 = new Player(0, MarkEnum.O);

		playersQueue.addLast(player2);
		playersQueue.addLast(player1);

	}

	public Player getNextPlayer() {
		Player nextPlayer = playersQueue.removeFirst();
		return nextPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Deque<Player> getPlayersQueue() {
		return playersQueue;
	}

	public void setPlayersQueue(Deque<Player> playersQueue) {
		this.playersQueue = playersQueue;
	}

	public boolean isPositionPlayable(int xPos, int yPos) {
		if (xPos < 0 || yPos < 0 || xPos >= board.getSize() || yPos >= board.getSize()) {
			return false;
		}

		if (board.isPositionAlreadyPlayed(xPos, yPos)) {
			return false;
		}

		return true;
	}

	public void markPositionForPlayer(int xPos, int yPos, Player currPlayer) {
		board.markPositionForPlayer(xPos, yPos, currPlayer.getAssignedMark());

	}

	public void printBoard() {

		for (int i = 0; i < board.getSize(); i++) {
			for (int j = 0; j < board.getSize(); j++) {
				if (board.getBoardGrid()[i][j] == null) {
					System.out.print(" ");
				} else {
					System.out.print(board.getBoardGrid()[i][j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}

	public boolean hasPlayerWon(Player currPlayer) {
		for (int i = 0; i < board.getSize(); i++) {
			if (isColumnMarkedWith(i, currPlayer.getAssignedMark())) {
				return true;
			}
		}
		for (int i = 0; i < board.getSize(); i++) {
			if (isRowMarkedWith(i, currPlayer.getAssignedMark())) {
				return true;
			}
		}

		if (isLeftToRightDiagonalMarkedWith(currPlayer.getAssignedMark())) {
			return true;
		}

		if (isRightToLeftDiagonalMarkedWith(currPlayer.getAssignedMark())) {
			return true;
		}

		return false;

	}

	private boolean isColumnMarkedWith(int col, MarkEnum mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[i][col] == null || board.getBoardGrid()[i][col] != mark) {
				return false;
			}
		}

		return true;
	}

	private boolean isRowMarkedWith(int row, MarkEnum mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[row][i] == null || board.getBoardGrid()[row][i] != mark) {
				return false;
			}
		}

		return true;
	}

	private boolean isLeftToRightDiagonalMarkedWith(MarkEnum mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[i][i] == null || board.getBoardGrid()[i][i] != mark) {
				return false;
			}
		}
		return true;
	}

	private boolean isRightToLeftDiagonalMarkedWith(MarkEnum mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[i][board.getSize() - i - 1] == null
					|| board.getBoardGrid()[i][board.getSize() - i - 1] != mark) {
				return false;
			}
		}
		return true;
	}

	public void movePlayerToLast(Player currPlayer) {
		playersQueue.addLast(currPlayer);

	}

	public boolean isBoardPlayable() {
		if(board.getPositionsTaken()==board.getSize()*board.getSize()) {
			return false;
		}
		
		return true;
	}

}
