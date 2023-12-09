package week06;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	private final int BOARD_SIZE = 9;
	private List<String> board = new ArrayList<>();
	private String winnerText = "";

	public GameBoard() {
		initializeGame();
	}

	public void initializeGame() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			board.add(String.valueOf(i + 1));
		}
	}

	public String displayGameBoard() {
		String border = "     +---+---+---+\n";
		StringBuilder display = new StringBuilder();
		display.append(border);
		display.append("     | " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " |\n");
		display.append(border);
		display.append("     | " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " |\n");
		display.append(border);
		display.append("     | " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " |\n");
		display.append(border);
		return display.toString();

	}

	public boolean isValidMove(int selection) {
		if (selection < 1 || selection > BOARD_SIZE) {
			return false;
		} else if (board.get(selection - 1) == "X" || board.get(selection - 1) == "O") {
			return false;
		}
		return true;
	}

	public boolean hasPlayerWon(String player) {
		boolean isWinner = false;
		// check for horizontal win
		if ((board.get(0) == player && board.get(1) == player && board.get(2) == player)
				|| (board.get(3) == player && board.get(4) == player && board.get(5) == player)
				|| (board.get(6) == player && board.get(7) == player && board.get(8) == player)) {
			setWinnerText("     " + player + " wins the game!");
			isWinner = true;
		}

		// check for vertical win
		if ((board.get(0) == player && board.get(3) == player && board.get(6) == player)
				|| (board.get(1) == player && board.get(4) == player && board.get(7) == player)
				|| (board.get(2) == player && board.get(5) == player && board.get(8) == player)) {
			setWinnerText("     " + player + " wins the game!");
			isWinner = true;
		}

		// check for diagonal win
		if ((board.get(0) == player && board.get(4) == player && board.get(8) == player)
				|| (board.get(2) == player && board.get(4) == player && board.get(6) == player)) {
			setWinnerText("     " + player + " wins the game!");
			isWinner = true;
		}
		return isWinner;
	}

	public boolean isTieGame() {
		boolean hasEmptySquares = false;
		for (String square : board) {
			if (!(square == "X" || square == "O")) {
				hasEmptySquares = true;
			}
		}
		if (!hasEmptySquares) {
			setWinnerText("     The game is a Draw!");
		}
		return !hasEmptySquares;
	}

	public String getWinnerText() {
		return winnerText;
	}

	private void setWinnerText(String winnerText) {
		this.winnerText = winnerText;
	}

	public void set(int position, String player) {
		board.set(position, player);

	}
}
