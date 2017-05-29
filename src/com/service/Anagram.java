package com.service;

import java.util.ArrayList;
import java.util.Scanner;

public class Anagram {
	

	public static void permutation(String str, ArrayList<String> permList) { 
	    permutation("", str, permList); 
	}
	
	private static void permutation(String prefix, String str, ArrayList<String> permList) {
	//	System.out.println("prefix="+prefix+" -- str="+str);
	    int n = str.length();
	    if (n == 0){
	    //	System.out.println(prefix);
	    	permList.add(prefix);
	    }
	    	
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), permList);
	    }
	}
	
	public static int search(String query, String parent){
		
		int plen = parent.length();
		int qlen = query.length();
		int count = 0;
		if(plen<qlen){
			return 0;
		}
		
		for(int i=0; i<plen; i++){
			if(i+qlen<=plen){
			//	System.out.println("i="+i+", qlen="+qlen+", plen="+plen);
			//	System.out.println("q="+query+", substr="+parent.substring(i, i+qlen));
				if(parent.substring(i, i+qlen).equals(query)){
				//	System.out.println("Match found!");
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args){
		String query = "";
		String parent = "";
		Scanner user_input = new Scanner( System.in );
		System.out.println("please provide input:");
		parent = user_input.nextLine();
		query = user_input.nextLine();
		user_input.close();
		ArrayList<String> permList = new ArrayList<String>(); 
		permutation(query,permList);
		int count = 0;
		for(String perm: permList){
			if(parent.contains(perm)){
				count+=search(perm, parent);
			}
			
		}
		System.out.println("Output: "+count);
	}
}
