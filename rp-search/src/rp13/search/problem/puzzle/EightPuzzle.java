package rp13.search.problem.puzzle;


import java.util.Arrays;
import java.util.Random;

/**
 * 
 * A class to represent a 3x3 sliding tile puzzle, such as:
 * 
 * 1 2 3 4 5 6 7 8 X
 * 
 * where the X represents the blank tile which can be slid around
 * 
 * @author Nick Hawes
 * 
 */
public class EightPuzzle {

	/**
	 * Explicit enumeration of moves the blank tile can take.
	 * 
	 * @author nah
	 * 
	 */
	public enum PuzzleMove {
		UP(-3), DOWN(3), LEFT(-1), RIGHT(1);

		private final int m_move;

		private PuzzleMove(int _move) {
			m_move = _move;
		}

		/**
		 * Cached result of values such that copy isn't done every time.
		 */
		private static final PuzzleMove[] VALUES = values();

		/***
		 * Count of values in list
		 */
		private static final int SIZE = VALUES.length;

		/**
		 * Random number generator
		 */
		private static final Random RANDOM = new Random();

		/**
		 * Returns a move selected at random.
		 * 
		 * @return
		 */
		public static PuzzleMove randomMove() {
			return VALUES[RANDOM.nextInt(SIZE)];
		}

	}

	/**
	 * The pieces in the puzzle, represented as an array.
	 */
	protected final int[] m_board;

	/**
	 * The value that represents the blank.
	 */
	protected final static int BLANK = 0;

	/**
	 * Width of the board
	 */
	protected final static int WIDTH = 3;

	/**
	 * Where the blank is currently located in the array
	 */
	private int m_blankPosition;

	/**
	 * Create an eight puzzle in its default configuration
	 */
	private EightPuzzle() {
		m_board = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, BLANK };
		m_blankPosition = m_board.length - 1;
	}

	/**
	 * Create a new eight puzzle by copying the given puzzle
	 * 
	 * @param _that
	 */
	public EightPuzzle(EightPuzzle _that) {
		m_board = Arrays.copyOf(_that.m_board, _that.m_board.length);
		m_blankPosition = _that.m_blankPosition;
	}

	/**
	 * Slide the blank tile randomly once.
	 */
	public void randomMove() {

		boolean moveMade = false;
		while (!moveMade) {
			PuzzleMove move = PuzzleMove.randomMove();
			moveMade = makeMove(move);
		}
	}

	/**
	 * Checks whether the given move is possible given the current blank
	 * position.
	 * 
	 * @param _move
	 *            The move to make.
	 * @return Returns true if the move is possible, else false.
	 */
	public boolean isPossibleMove(PuzzleMove _move) {
		int newBlankPosition = m_blankPosition + _move.m_move;

		// if move stays within board
		if (newBlankPosition >= 0 && newBlankPosition < m_board.length) {

			// check that it's not off the edges
			int currentRow = m_blankPosition / WIDTH;
			int newRow = newBlankPosition / WIDTH;

			// either the move stays on the same row, or it's a vertical move
			return (currentRow == newRow) || Math.abs(_move.m_move) > 1;

		}

		return false;
	}

	/**
	 * Attempts to move the blank by the given move.
	 * 
	 * @param _move
	 *            The move to make.
	 * @return Returns true if the move was possible, else false.
	 */
	public boolean makeMove(PuzzleMove _move) {
		if (isPossibleMove(_move)) {
			// where should the blank end up
			int newBlankPosition = m_blankPosition + _move.m_move;
			// get the piece that was in that position
			int toSwapWith = m_board[newBlankPosition];
			// then swap them around
			m_board[newBlankPosition] = BLANK;
			m_board[m_blankPosition] = toSwapWith;
			m_blankPosition = newBlankPosition;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {

		// use a string builder for efficiency
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m_board.length; i++) {
			sb.append("| ");
			if (m_board[i] == BLANK) {
				sb.append("X");
			} else {
				sb.append(m_board[i]);
			}
			sb.append(" ");

			// detect end of the board
			if ((i + 1) % WIDTH == 0) {
				sb.append("|\n");
			}

		}
		return sb.toString();

	}

	@Override
	public boolean equals(Object _that) {
		if (_that instanceof EightPuzzle) {
			EightPuzzle that = (EightPuzzle) _that;

			// cheapest comparison first
			if (this.m_blankPosition == that.m_blankPosition) {
				// compare both boards
				return Arrays.equals(this.m_board, that.m_board);
			}
		}

		return false;

	}

	/**
	 * Creates an eight puzzle with the pieces in the correct order
	 * 
	 * @return
	 */
	public static EightPuzzle orderedEightPuzzle() {
		return new EightPuzzle();
	}

	/**
	 * Creates a randomised eight puzzle using the given number of random moves.
	 * 
	 * @return
	 */
	public static EightPuzzle randomEightPuzzle(int _moves) {
		EightPuzzle puzzle = new EightPuzzle();
		for (int i = 0; i < _moves; i++) {
			puzzle.randomMove();
		}
		return puzzle;
	}

	/**
	 * Creates a randomised eight puzzle.
	 * 
	 * @return
	 */
	public static EightPuzzle randomEightPuzzle() {
		return randomEightPuzzle(WIDTH * WIDTH * WIDTH);
	}

	public static void main(String[] args) {
		
		EightPuzzle puzzle = EightPuzzle.orderedEightPuzzle();

		System.out.println(puzzle);

		for (PuzzleMove move : PuzzleMove.values()) {
			puzzle.makeMove(move);
			System.out.println(move);
			System.out.println(puzzle);
		}

	}

}
