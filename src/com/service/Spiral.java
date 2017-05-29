package com.service;

import java.util.Scanner;

public class Spiral {
	
	public static void goSpiral(int nrow, int ncol, int srow, int scol, int[][]mx){
		int count = 0;
		int moves = 1;
		int total = nrow*ncol;
		
		while(count<total){
			
			
			//go up
			for(int i=0; i<moves;i++){
			//	System.out.println("now = "+srow+","+scol);
				if(srow>=0 && srow<nrow && scol>=0 && scol<ncol){
					//valid location
					System.out.print(mx[srow][scol]+" ");
					count++;
					if(count==total)
						break;
				}
				srow--;
			}
			
			if(count==total)
				break;
			//go left
			for(int i=0; i<moves;i++){
			//	System.out.println("now = "+srow+","+scol);
				if(count<total){
					if(srow>=0 && srow<nrow && scol>=0 && scol<ncol){
						//valid location
						System.out.print(mx[srow][scol]+" ");
						count++;
					}
					scol--;
					if(count==total)
						break;
				}
			}
			if(count==total)
				break;
			//increment moves
			moves++;
			
			//go down
			for(int i=0; i<moves;i++){
			//	System.out.println("now = "+srow+","+scol);
				if(count<total){
					if(srow>=0 && srow<nrow && scol>=0 && scol<ncol){
						//valid location
						System.out.print(mx[srow][scol]+" ");
						count++;
					}
					srow++;
					if(count==total)
						break;
				}
			}
			
			if(count==total)
				break;
			
			//go right
			for(int i=0; i<moves;i++){
			//	System.out.println("now = "+srow+","+scol);
				if(count<total){
					if(srow>=0 && srow<nrow && scol>=0 && scol<ncol){
						//valid location
						System.out.print(mx[srow][scol]+" ");
						count++;
					}
					scol++;
					if(count==total)
						break;
				}
			}
			
			if(count==total)
				break;
			//increment moves
			moves++;
		}
		
	}
	
	/*public static int up(int row, int col, int count, int[][]mx){
		row--;
		if(row>=0 && col>=0){
			//valid location
			System.out.print(mx[row][col]+" ");
			count++;
		}
		return count;
	}*/
	
	public static void main(String[] args){
		Scanner user_input = new Scanner( System.in );
		String input = user_input.nextLine();
		user_input.close();
		String[] inpArr = (input.split(" "));
		try{
			int nrow = Integer.parseInt(inpArr[0]);
			int ncol = Integer.parseInt(inpArr[1]);
			int srow = Integer.parseInt(inpArr[2]);
			int scol = Integer.parseInt(inpArr[3]);
			
			//create a matrix
			int [][] mx = new int [nrow][ncol];
			int c=1;
			for(int i=0;i<nrow; i++){
				for(int j=0; j<ncol; j++){
					mx[i][j]=c;
					c++;
				}
			}
			
			goSpiral(nrow,ncol, srow-1, scol-1, mx);
		}catch(Exception e){
			System.out.println("Error inn input");
		}
		
		
	}
}
