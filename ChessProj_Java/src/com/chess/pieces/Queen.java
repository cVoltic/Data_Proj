package com.chess.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.board.Board;
import com.chess.board.BoardUtils;
import com.chess.board.Move;
import com.chess.board.Tile;
import com.chess.board.Move.AttackMove;
import com.chess.board.Move.MajorMove;
import com.chess.players.Alliance;
import com.google.common.collect.ImmutableList;

public class Queen extends Piece{
	private final static int[] CANDIATE_MOVE_VECTOR_COORDINATES = { -9, -8, -7, -1, 1, 7, 8, 9 };

	Queen(int piecePosition, Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {
		// TODO Auto-generated method stub
		final List<Move> legalMoves = new ArrayList<>();
		
		//loop through the vector list in the four direction that the bishop can move
		for(final int candidateCoordinateOffset: CANDIATE_MOVE_VECTOR_COORDINATES) {
			
			//Start with the current position,
			//while we are in the direction of the vector component, are we off the board?
			int candidateDestinationCoordinate = this.piecePosition;
			while(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				
				//Check for edge cases
				if(isFirstColumnExclusion(candidateDestinationCoordinate , candidateCoordinateOffset) || 
						isEightColumnExclusion(candidateDestinationCoordinate , candidateCoordinateOffset)) {
					break;
				}				
				
				
				//Apply the new move if it is a valid coordinate
				candidateDestinationCoordinate += candidateCoordinateOffset;
				
				if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
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
						break;
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}
	//Implement the check for edge cases
	//Edge Cases for the knight
	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		//return an array of boolean
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -9 || candidateOffset == 7 || candidateOffset == -1 );
		
	}
	private static boolean isEightColumnExclusion(final int currentPosition, final int candidateOffset) {
		//return an array of boolean
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == 9 || candidateOffset == -7 || candidateOffset == 1 );
		
	}
}
