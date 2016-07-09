package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dataobject.Direction;

public class Board implements Cloneable {

	public static final Integer BOARD_SIZE = 4;
	private static final int TARGET_POINTS = 2048;
	private static final int MINIMUM_WIN_SCORE = 18432;
	private int[][] boardArray;
	private final Random randomGenerator;
	private int cache_emptyCells =(Integer) null;
	private int score=0;
	
	public Board(){
		boardArray =new int[BOARD_SIZE][BOARD_SIZE];
		randomGenerator =new Random(System.currentTimeMillis());
		addRandomCell();
		addRandomCell();
	}

	private boolean addRandomCell() {
		// TODO Auto-generated method stub
		List<Integer> emptyCells =getEmptyCellIds();
		int listSize =emptyCells.size();
		if(listSize==0){
			return false;
		}
		
		int randomCellId =emptyCells.get(randomGenerator.nextInt(listSize));
		int randomValue=(randomGenerator.nextDouble()<0.9)?2:4;
		int i=randomCellId/BOARD_SIZE;
		int j=randomCellId%BOARD_SIZE;
		setEmptyCell(i,j,randomValue);
		return true;
		
		
	}
	
	public int getScore(){
		return score;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		Board copy= (Board)super.clone();
		copy.boardArray =clone2dArray(boardArray);
		return copy;
		
	}
	
	private int[][] clone2dArray(int[][] currboardArray) {
		int[][] copy =new int[currboardArray.length][];
		for(int i=0;i<currboardArray.length;i++){
			copy[i]=currboardArray[i].clone();
		}
		return copy;
		
		// TODO Auto-generated method stub
		
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
		if(score <MINIMUM_WIN_SCORE){
			return false;
		}
		for(int i=0;i<BOARD_SIZE;i++){
			for(int j=0;j<BOARD_SIZE;j++){
				if(boardArray[i][j]>=TARGET_POINTS){
					return true;
				}
			}
		}
		// TODO Auto-generated method stub
		return false;
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
		int point=0;
		if(direction==Direction.UP){
			rotateLeft();
			
		}
		else if(direction==Direction.RIGHT){
			rotateLeft();
			rotateLeft();
		}
		else if(direction==Direction.DOWN){
			rotateRight();
			
		}
		
		// TODO Auto-generated method stub
		return 0;
	}

	private void rotateRight() {
		// TODO Auto-generated method stub
		
	}

	private void rotateLeft() {
		// TODO Auto-generated method stub
		
	}

	public boolean isEqual(int[][] currboardArray, int[][] newboardArray) {
		
		Boolean equal =true;
		
		for(int i=0;i<currboardArray.length;i++){
			for(int j=0;j<newboardArray.length;j++){
				if(currboardArray[i][j]!=newboardArray[i][j]){
					equal=false;
					return equal;
				}
			}
		}
		// TODO Auto-generated method stub
		return equal;
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

	public void setEmptyCell(int i, int j, int value){
		if (boardArray[i][j]==0){
			boardArray[i][j]=value;
			cache_emptyCells=(Integer) null;
		}
		// TODO Auto-generated method stub
	}

	public Random getRandomGenerator() {
		return randomGenerator;
	}
	

}
