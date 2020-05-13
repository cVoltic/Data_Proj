package com.chess.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.board.Board;
import com.chess.board.BoardUtils;
import com.chess.board.Move;
import com.chess.players.Alliance;

public class Pawn extends Piece{

	//at pawn position +8 move it up one square
	private final static int[] CANDIDATE_MOVE_COORDINATES = {8};

	
	Pawn(int piecePosition, Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		
		//Loop through candidate move coordinates
		//Apply the offset to the piece position
		for(final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
			final int candidateDestinationCoordinate = this.piecePosition + (this.getPieceAlliance().getDirection() * currentCandidateOffset);
			
			//check if the tile is valid
			//TODO: implement me
			if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				continue;
			}
			
			//move one tile forward, and the tile isn't occupied -> then it is a legal move
			//TODO: implement me more
			if(currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
				legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
			}
		}
		
		return legalMoves;
	}

}
