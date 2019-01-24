package cs.ualberta.cmput402.tictactoe;

import cs.ualberta.cmput402.tictactoe.board.Board;
import cs.ualberta.cmput402.tictactoe.board.Board.Player;
import cs.ualberta.cmput402.tictactoe.board.ScoreBoard;
import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;

import java.util.Scanner;

/**
 * Created by snadi on 2018-07-18.
 */
public class TicTacToeGame {

    private Board board;
    private ScoreBoard scoreBoard;

    public TicTacToeGame(){
        board = new Board();
        scoreBoard = new ScoreBoard();
    }

    public void promptNextPlayer(){
        switch(board.getCurrentPlayer()){
            case X:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;
            case O:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;

        }
    }

    public void playGame(){
        Scanner keyboardScanner = new Scanner(System.in);
        boolean shouldContinue = true;
        
        while (shouldContinue) {
	        while (board.getWinner() == null && board.maxTurns() == false){
	            board.printBoard();
	            promptNextPlayer();
	            String line = keyboardScanner.nextLine();
	            String input[] = line.split(",");
	            try {
	                board.playMove(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
	            } catch (InvalidMoveException e) {
	                System.out.println("Invalid coordinates. Try again");
	                promptNextPlayer();
	            }
	        }

	        board.printBoard();
	        if (board.getWinner() != null) {
	        	System.out.println("Player " + board.getWinner() + " has won the game!");	
	        	
	        	if(Player.X == board.getWinner()) {
	        		scoreBoard.setXWin();
	        	} else if (Player.O == board.getWinner()) {
	        		scoreBoard.setOWin();
	        	}
	        }
	        else {
	        	System.out.println("The game has ended in a tie.");
	        	scoreBoard.setTie();
	        }
	        scoreBoard.printScoreBoard();
	        System.out.println("Do you want to play another game? (Types yes to play or anything else to exit)");
	        String userInput = keyboardScanner.nextLine();
	        
	        if(userInput.equals("yes")) {
	        	board.resetGame();
	        } else {
	        	shouldContinue = false;
	        	System.out.println("See you next time!");
	        	System.exit(0);
	        }
        }
    }

    public static void main(String args[]){
        TicTacToeGame game = new TicTacToeGame();
        game.playGame();
    }
}
