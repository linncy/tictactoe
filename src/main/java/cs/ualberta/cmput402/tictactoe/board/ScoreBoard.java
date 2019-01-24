package cs.ualberta.cmput402.tictactoe.board;

public class ScoreBoard {
	private int xWin;
	private int oWin;
	private int tie;
	
	public ScoreBoard() {
		xWin = 0;
		oWin = 0;
		tie = 0;
	}
	
	public void setXWin() {
		xWin++;
	}
	
	public void setOWin() {
		oWin++;
	}
	
	public void setTie() {
		tie++;
	}
	
	public void printScoreBoard() {
		System.out.println("*****************************************************");
		System.out.printf("Player X won: %d games, lost %d games\n",xWin, oWin);
		System.out.printf("Player O won: %d games, lost %d games\n",oWin, xWin);
		System.out.printf("Number of ties: %d\n", tie);
		System.out.println("*****************************************************");
	}
}
