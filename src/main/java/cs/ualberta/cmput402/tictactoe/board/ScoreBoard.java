package cs.ualberta.cmput402.tictactoe.board;

/**
 * ScoreBoard class which displays the amount of wins losses and ties
 */
public class ScoreBoard {
	private int xWin;
	private int oWin;
	private int tie;
	
	public ScoreBoard() {
		xWin = 0;
		oWin = 0;
		tie = 0;
	}
	
	//setter for score of X when X wins
	public void setXWin() {
		xWin++;
	}
	
	//setter for score of O when O wins
	public void setOWin() {
		oWin++;
	}
	
	//setter for tie
	public void setTie() {
		tie++;
	}
	
	//display the score board
	public void printScoreBoard() {
		System.out.println("*****************************************************");
		System.out.printf("Player X won: %d games, lost %d games\n",xWin, oWin);
		System.out.printf("Player O won: %d games, lost %d games\n",oWin, xWin);
		System.out.printf("Number of ties: %d\n", tie);
		System.out.println("*****************************************************");
	}
}
