package AIsolver;

import game.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataobject.Direction;

public class AI_solver {
	public enum Player{
		COMPUTER,
		USER
	}
	public static Direction findBestMove(Board theBoard,int depth) throws CloneNotSupportedException{
		Map<String ,Object> result =minimax(theBoard,depth,Player.USER);
		return (Direction)result.get("Direction");
		
	}
	private static Map<String, Object> minimax(Board theBoard, int depth,Player player) throws CloneNotSupportedException{
		Map<String ,Object> result =new HashMap<>();
		Direction bestDirection=null;
		int bestScore;
		
		if(depth ==0|| theBoard.isGameTerminated()){
			bestScore=heuristicScore( theBoard.getScore(),theBoard.getNumberOfEmptyCells(),calculateClusteringScore(theBoard.getBoardArray()));
		}
		else{
			if(player ==Player.USER){
				bestScore=Integer.MIN_VALUE;
				
				for(Direction direction :Direction.values()){
					Board newBoard =(Board) theBoard.clone();
					int points =newBoard.move(direction);
					if (points==0 && newBoard.isEqual(theBoard.getBoardArray(), newBoard.getBoardArray())){
						continue;
					}
					
					
					Map<String ,Object> currentResult =minimax(newBoard ,depth-1 , Player.COMPUTER);
					int currentScore=((Number)currentResult.get("Score")).intValue();
					
					if(currentScore>bestScore){
						bestScore=currentScore;
						bestDirection=direction ;
					}
				}
			}
			else{
				bestScore =Integer.MAX_VALUE;
				
				List<Integer > moves =theBoard.getEmptyCellIds();
				if (moves.isEmpty()){
					bestScore=0;
				}
				int[] possibleValues ={2,4};
				int i,j;
				int [][] boardArray;
				for(Integer cellId : moves){
					i=cellId/Board.BOARD_SIZE;
					j=cellId%Board.BOARD_SIZE;
					
					
					for(int value : possibleValues){
						Board newBoard =(Board) theBoard.clone();
						newBoard.setEmptyCell(i,j,value);
						Map<String , Object > currentResult = minimax(newBoard, depth-1,Player.USER);
						int currentScore=((Number)currentResult.get("Score")).intValue();
						
						if(currentScore>bestScore){
							bestScore=currentScore;
						}
					}
				}
			}
		}
		result.put("Score",bestScore);
		result.put("Direction",bestDirection);
		// TODO Auto-generated method stub
		return result;
	}
	private static int heuristicScore(Object score, Object numberOfEmptyCells, Object calculateClusteringScore) {
		// TODO Auto-generated method stub
		return 0;
	}
	private static Object calculateClusteringScore(Object boardArray) {
		// TODO Auto-generated method stub
		return null;
	}

}


	