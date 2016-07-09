package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dataobject.Direction;

public class Board implements Cloneable {

	public static final Integer BOARD_SIZE = 4;
	private int[][] boardArray;
	private final Random randomGenerator;
	private int cache_emptyCells =(Integer) null;
	
	public Board(){
		boardArray =new int[BOARD_SIZE][BOARD_SIZE];
		randomGenerator =new Random(System.currentTimeMillis());
		addRandomCell();
		addRandomCell();
	}

	private void addRandomCell() {
		// TODO Auto-generated method stub
		
	}

	public Object clone() throws CloneNotSupportedException{
		Board copy= (Board)super.clone();
		copy.boardArray =clone2dArray(boardArray);
		return copy;
		
	}
	private int[][] clone2dArray(Object boardArray2) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isGameTerminated() throws CloneNotSupportedException {
		boolean terminated =false;
		if(hasWon()==true){
			terminated =true;
		}
		else{
			if(getNumberOfEmptyCells()==0){
				Board copyBoard=(Board) this.clone();
				if(copyBoard.move(Direction.UP)==0&&copyBoard.move(Direction.DOWN)==0&&copyBoard.move(Direction.LEFT)==0&&copyBoard.move(Direction.RIGHT)==0){
					terminated=true;
				}
			}
		}
		return terminated;
		
		
		// TODO Auto-generated method stub
		//return false;
	}

	public boolean hasWon() {
		
		// TODO Auto-generated method stub
		return false;
	}

	public Object getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumberOfEmptyCells() {
		if(cache_emptyCells==(Integer) null){
			cache_emptyCells=getEmptyCellIds().size();
		}
		return cache_emptyCells;
		// TODO Auto-generated method stub
		//return null;
	}

	public int[][] getBoardArray() {
		// TODO Auto-generated method stub
		return clone2dArray(boardArray);
		//return null;
	}

	public int move(Direction direction) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEqual(Object boardArray, Object boardArray2) {
		// TODO Auto-generated method stub
		return false;
	}

	public java.util.List<Integer> getEmptyCellIds() {
		List<Integer> cellList =new ArrayList<>();
		
		for(int i=0;i<BOARD_SIZE;i++){
			for(int j=0;j<BOARD_SIZE;j++){
				if(boardArray[i][j]==0){
					cellList.add(BOARD_SIZE*i+j);
				}
			}
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmptyCell(int i, int j, int value) {
		// TODO Auto-generated method stub
		
	}

	public Random getRandomGenerator() {
		return randomGenerator;
	}
	

}
