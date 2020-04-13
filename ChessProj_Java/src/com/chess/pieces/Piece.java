/*
 *	Class use to generate pieces on chess board
 *	Each Piece is an extension of this class that has a set of legal move
 */

package com.chess.pieces;

import java.util.Collection;

import com.chess.board.Board;
import com.chess.board.Move;
import com.chess.players.Alliance;

public abstract class Piece {
	//Declare Fields
	protected final int piecePosition;
	protected final Alliance pieceAlliance;		//Java Enum -> collection of constances
	
	//Class Constructor
	Piece(final int piecePosition, final Alliance pieceAlliance){
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = piecePosition;
	}
	
	public Alliance getPieceAlliance() {
		return this.pieceAlliance;
	}

	
	//Method that is responsible to calculate the legal moves of a piece
	//Caller of this method is unspecified -> could be ordered or unordered
	public abstract Collection<Move> calculateLegalMoves(final Board board);

}
