package com.atomicobject.othello;

import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.Arrays;
import java.util.ListIterator;

public class AI {
	
	ListIterator<int[]> moveList;

	//max priority queue to keep track of best valid move
	PriorityQueue<LineInfo> maxPriorityQueue = new PriorityQueue<>(new Comparator<LineInfo>() {
		@Override
		public int compare(LineInfo a, LineInfo b) {
			return Integer.compare(b.length, a.length);
		}
	});

	public AI() {
		System.out.println("AI has begun..");

	}

	public int[] computeMove(GameState state) {
		int[][] currBoard = state.getBoard();

		
		//check whether board has any valid moves

		//iterate through all the rows / cols
		for (int i=0; i< 8 ; i++) {
			for(int j=0 ; j< 8 ; j++){
				//if the item inside cell is 1 - begin search
				if(currBoard[i][j] == 1){
					//check all sides
					//N
					if ((i-1)>=0  && currBoard[i-1][j] == 2){
						int count = 0;
						while((i-1-count)>=0 && currBoard[i-1-count][j] == 2){
							count++;
						}
						if((i-1-count)>=0 && count>0 && currBoard[i-count-1][j] == 0){	
							LineInfo addLine = new LineInfo(count, i-count-1, j);
							maxPriorityQueue.add(addLine);
						}
					}

					//NE
					if ((i-1)>=0 && (j+1)<=7 && currBoard[i-1][j+1] == 2 ){
						int count = 0;
						while((i-1-count)>=0 && (j+1+count)<=7 && currBoard[i-1-count][j+1+count] == 2){
							count++;
						}
						if((i-1-count)>=0 && (j+1+count)<=7 && count>0 && currBoard[i-count-1][j+1+count] == 0){	
							LineInfo addLine = new LineInfo(count, i-count-1, j+1+count);
							maxPriorityQueue.add(addLine);
						}
					}

					//E
					if ((j+1)<=7 && currBoard[i][j+1] == 2 ){
						int count = 0;
						while((j+1+count)<=7 && currBoard[i][j+1+count] == 2){
							count++;
						}
						if((j+1+count)<=7 && count>0 && currBoard[i][j+1+count] == 0){	
							LineInfo addLine = new LineInfo(count, i, j+1+count);
							maxPriorityQueue.add(addLine);
						}
					}
					//SE
					if ((i+1)<=7 && (j+1)<=7 && currBoard[i+1][j+1] == 2){
						int count = 0;
						while((i+1+count)<=7 && (j+1+count)<=7 && currBoard[i+1+count][j+1+count] == 2){
							count++;
						}
						if((i+1+count)<=7 && (j+1+count)<=7 && count>0 && currBoard[i+1+count][j+1+count] == 0){	
							LineInfo addLine = new LineInfo(count, i+1+count, j+1+count);
							maxPriorityQueue.add(addLine);
						}
					}
					//S
					if ((i+1)<=7 && currBoard[i+1][j] == 2){
						int count = 0;
						while((i+1+count)<=7 && currBoard[i+1+count][j] == 2){
							count++;
						}
						if((i+1+count)<=7 && count>0 && currBoard[i+1+count][j] == 0){	
							LineInfo addLine = new LineInfo(count, i+1+count, j);
							maxPriorityQueue.add(addLine);
						}
					}
					//SW
					if ((i+1)<=7 && (j-1)>=0 && currBoard[i+1][j-1] == 2){
						int count = 0;
						while((i+1+count)<=7 && (j-1-count)>=0 && currBoard[i+1+count][j-1-count] == 2){
							count++;
						}
						if((i+1+count)<=7 && (j-1-count)>=0 && count>0 && currBoard[i+1+count][j-1-count] == 0){	
							LineInfo addLine = new LineInfo(count, i+1+count, j-1-count);
							maxPriorityQueue.add(addLine);
						}
					}
					//W
					if ((j-1)>=0 && currBoard[i][j-1] == 2){
						int count = 0;
						while((j-1-count)>=0 && currBoard[i][j-1-count] == 2){
							count++;
						}
						if((j-1-count)>=0 && count>0 && currBoard[i][j-1-count] == 0){	
							LineInfo addLine = new LineInfo(count, i, j-1-count);
							maxPriorityQueue.add(addLine);
						}	
					}
					//NW
					if ((j-1)>=0 && (i-1)>=0 && currBoard[i-1][j-1] == 2){
						int count = 0;
						while((i-1-count)>=0 && (j-1-count)>=0 && currBoard[i-1-count][j-1-count] == 2){
							count++;
						}
						if((i-1-count)>=0 && (j-1-count)>=0 && count>0 && currBoard[i-1-count][j-1-count] == 0){	
							LineInfo addLine = new LineInfo(count, i-1-count, j-1-count);
							maxPriorityQueue.add(addLine);
						}
					}

				}

			}


		}
		//pop from stack
		LineInfo returnLine = maxPriorityQueue.poll();
		//clear the queue
		maxPriorityQueue.clear();
		//pull coordinates
		int[] returnCoords = {returnLine.row, returnLine.col};
		return returnCoords;

	}

	//for Maxpriority Queue
	class LineInfo {
		int length;
		int row;
		int col;
	
			public LineInfo(int length, int row, int col) {
				this.length = length;
				this.row = row;
				this.col = col;
			}
		}





}
