package com.atomicobject.othello;

import java.util.Arrays;
import java.util.ListIterator;

public class AI {
	
	ListIterator<int[]> moveList;

	public AI() {
		//moveList = Arrays.asList(moves).listIterator();
		System.out.println("AI has begun..");

	}

	public int[] computeMove(GameState state) {
		System.out.println("AI is gonna return canned move for game state - " + state);
		//return moveList.next();
		int[] returnMove = {5,4};
		return returnMove;
		//return a hardcoded array ie - [0,0]
		//check whether board has any valid moves

		//iterate through all the rows / cols

		

		//place valid move

		
	}



}
