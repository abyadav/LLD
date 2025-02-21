package tictactoe;

import java.util.Scanner;

public class TicTacToe {
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the tic tac toe game");
		
		Game game=new Game();
		
		scanner=new Scanner(System.in);
		
		try {
			
			while(true) {
				
				if(!game.isBoardPlayable()) {
					System.out.println("Game Over.");
				}
				
				Player currPlayer = game.getNextPlayer();
				
				System.out.println("Your turn player "+currPlayer.getId());
				
				playTurnForCurrPlayer(currPlayer, game);
				
				game.movePlayerToLast(currPlayer);

				game.printBoard();

				if(game.hasPlayerWon(currPlayer)) {
					System.out.println("Congrats, You have won...");
					break;
				}

				System.out.println();
			}
		}  finally {
			scanner.close();
		}
	}

	private static void playTurnForCurrPlayer(Player currPlayer, Game game) {
		while(true) {
			
			System.out.println("Please enter position");
			int xPos=scanner.nextInt();
			int yPos=scanner.nextInt();
			
			if(!game.isPositionPlayable(xPos, yPos)) {
				System.out.println("Invalid Position.");
				continue;
			}
			
			game.markPositionForPlayer(xPos, yPos, currPlayer);			
			
			return;
		}
		
	}
}
