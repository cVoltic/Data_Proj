/*
 *	Class use to give chess pieces the ability to move
 *	Each Piece is an extension of this class that can move according to their piece type
 */

package com.chess.board;
import com.chess.pieces.Piece;

public abstract class Move {
	final Board board;
	final Piece movedPiece;
	final int destinationCoordinate;
	
	//We are keeping track of the board, the moved piece and where it move to
	//Class Constructor
	private Move(final Board board,
		 final Piece movedPiece,
		 final int destinationCoordinate) {
		this.board = board;
		this.movedPiece = movedPiece;
		this.destinationCoordinate = destinationCoordinate;
	}
	
	//need to distinguish b/t normal move, attacking, and non-attacking
	
	public static final class MajorMove extends Move{

		public MajorMove(final Board board, 
				  final Piece movedPiece, 
				  final int destinationCoordinate) {
			super(board, movedPiece, destinationCoordinate);
		}
		
	}
	public static final class AttackMove extends Move{
		
		//The piece is being attacked
		final Piece attackedPiece;
		
		public AttackMove(final Board board, 
				   final Piece movedPiece, 
				   final int destinationCoordinate,
				   final Piece attackedPiece) {
			super(board, movedPiece, destinationCoordinate);
			this.attackedPiece = attackedPiece;
		}
		
	}
}
