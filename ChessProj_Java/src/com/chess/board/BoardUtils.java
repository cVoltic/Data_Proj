package com.chess.board;

public class BoardUtils {
	
	//Instantiate an array of boolean corresponding to the first column of the chess board
	//True if in first column -> false otherwise
	public static final boolean[] FIRST_COLUMN = initColumn(0);
	public static final boolean[] SECOND_COLUMN = initColumn(1);
	public static final boolean[] SEVENTH_COLUMN = initColumn(6);
	public static final boolean[] EIGHTH_COLUMN = initColumn(7);
	
	

	public static final int NUM_TILES = 64;
	public static final int NUM_TILES_PER_ROW = 8;
	
	
	
	//class constructor
	private BoardUtils() {
		throw new RuntimeException("Class Cannot be instantiated");
	}
	
	private static boolean[] initColumn(int columnNumber){
		final boolean[] column = new boolean[NUM_TILES];
		for (int i = 0; i < NUM_TILES_PER_ROW;i++) {
			column[i*NUM_TILES_PER_ROW+columnNumber] = true;
		}
		return column;
	}

	//generic class use to build an entire column
	//Logic:
	//start from one index and add 8 until end of board is reach

	
	//making sure we are in bound to the chess board
	public static boolean isValidTileCoordinate(final int coordinate) {
		return coordinate >=0 && coordinate <64;
	}

}
