/*
 *	Class use to generate a tile on a chess board
 */
package com.chess.board;
import com.chess.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;


//Abstract class that can be use for polymorph
public abstract class Tile {
	
	//Introduce a member field that represent the tile number
	//Can only be able to use by sub classes and can never be reset after initialization 
	protected final int tileCoordinate;
	
	//Method to create all empty tiles that are valid up front (all 64) to be retrieve later
	//Utilize external library to prevent others from change
	//our initially created map of 64 empty tiles
	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		for(int i = 0; i<64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}		
		return ImmutableMap.copyOf(emptyTileMap);
	}

	//API usage allowed to create a tile
	//create a new OccupiedTile if not create otherwise return an empty tile from the HasMap
	public static Tile createTile(final int tileCoordinate,final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
	}
	
	
	//Class constructor - initialize a new tile when class is called
	private Tile(final int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}
	
	//Methods to check for empty tile
	public abstract boolean isTileOccupied();
	
	//Get a piece off a given tile
	public abstract Piece getPiece();
	
	//subclass that represent either an empty tile (cannot be extends)
	public static final class EmptyTile extends Tile {
		private EmptyTile(final int tileCoordinate) {
			super(tileCoordinate);
		}
		@Override
		public boolean isTileOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
	}
	
	//subclass that represent either an occupied tile (cannot be extends)
	public static final class OccupiedTile extends Tile {
		//Introduce a member field that represent the Piece
		//No way to access this variable outside of getPiece and can never be reset after initialization 
		//When occupied -> get the tile coordinate and remember the piece on tile		
		private final Piece pieceOnTile;
		private OccupiedTile(int tileCoordinate, final Piece pieceOnTile) {
			super(tileCoordinate);
			this.pieceOnTile = pieceOnTile;
		}
		@Override
		public boolean isTileOccupied() {
			return true;
		}
		
		@Override
		public Piece getPiece() {
			return this.pieceOnTile;
		}
	}
	
}
