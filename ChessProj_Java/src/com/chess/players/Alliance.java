/*	
 * Type-Safe to generate two instances of player type
 */

package com.chess.players;

public enum Alliance {
	WHITE {
		@Override
		public int getDirection() {
			return 1;
		}
	},	
	BLACK {
		@Override
		public int getDirection() {
			return -1;
		}
	};	
	
	//Abstract method to capture pawn's directionality
	//white go up the board, black go down the board
	public abstract int getDirection();
}
