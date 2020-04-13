package com.chess.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.board.Board;
import com.chess.board.BoardUtils;
import com.chess.board.Move;
import com.chess.board.Tile;
import com.chess.players.Alliance;

import static com.chess.board.Move.*;

import com.google.common.collect.ImmutableList;

public class Knight extends Piece{

	//From the starting position, how can a knight move
	//Each knight on anywhere can have a maximum of 8 possible moves
	private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};
	
	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		
		final List<Move> legalMoves = new ArrayList<>();
		for(final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
			
			//get the new coordinate of the piece
			final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
		
			if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				if(isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) ||
						isSecondColumnExclusion(this.piecePosition, currentCandidateOffset) ||
						isSeventhColumnExclusion(this.piecePosition, currentCandidateOffset) ||
						isEighthColumnExclusion(this.piecePosition, currentCandidateOffset)) {
					continue;
				}
				
				
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
				//Check to see if the tile is already occupied
				if(!candidateDestinationTile.isTileOccupied()) {
					//if not occupied -> then this is a legal move
					legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
				} else {
					//if occupied, check to see the piece alliance and capture if necessary
					final Piece pieceAtDestination = candidateDestinationTile.getPiece();
					final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
					
					// if not alliance -> you can take it
					if (this.pieceAlliance != pieceAlliance) {
						//Note: this should be an attacking move, allow user to take the piece off the board
						legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}
	
	//Edge Cases for the knight
	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		//return an array of boolean
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10 || 
				candidateOffset == 6 || candidateOffset == 15);
		
	}
	//Near Edge Cases for the knight
	private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
		//return an array of boolean
		return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
		
	}
	//Near Edge Cases for the knight
	private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
		//return an array of boolean
		return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
		
	}
	//Edge Cases for the knight
	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		//return an array of boolean
		return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6 ||
				candidateOffset == 10 || candidateOffset == -15);
		
	}


		

}
