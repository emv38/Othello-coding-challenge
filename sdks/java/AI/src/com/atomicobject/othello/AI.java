package com.atomicobject.othello;

import java.util.Arrays;
import java.util.ListIterator;

public class AI {
	
	ListIterator<int[]> moveList;

	public AI(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		System.out.println("AI is gonna return canned move for game state - " + state);
		return moveList.next();
		
		//return a hardcoded array ie - [0,0]
		//check whether board has any valid moves

		

		//place valid move

		
	}



}
