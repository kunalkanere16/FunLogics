package com.service;

import java.util.ArrayList;
import java.util.Scanner;

public class ParseCsv {
	
	public static void parse(String input){
				
		String text = "";
		boolean capture = false;
		boolean isDigit = false;
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < input.length(); i++){
	//		System.out.println("char = "+input.charAt(i));
			if(Character.isDigit(input.charAt(i))){	//check if char is digit
	//			System.out.println("1....");
				if(!capture)	//not a part of string value
					isDigit = true;
				
				text+=input.charAt(i);
				if(i==input.length()-1){	//last char of input
					list.add(text);
				}
				
			}
			else if(input.charAt(i) == '"'){	
				if(capture){	//end of string value
	//				System.out.println("2....");
					text+=input.charAt(i);
					capture=false;
					
					if(i==input.length()-1){	//last char check
						list.add(text);
					}
						
				}
				else{	//start of value
	//				System.out.println("3....");
					capture = true;
					text+=input.charAt(i);
				}
			}
			else if(input.charAt(i) == ','){	
				if(isDigit){	//end of digit values
	//				System.out.println("4....");
					list.add(text);
					text="";
					isDigit=false;
				}
				else if(capture){	//part of string value
	//				System.out.println("5....");
					text+=input.charAt(i);
										
				}
				else if(!capture){	// end of string value
	//				System.out.println("6....");
					list.add(text);
					text="";
				}
			}
			else{	//any other char as part of string value
	//			System.out.println("7....");
				text+=input.charAt(i);
			}
	//		System.out.println("text = "+text);
		}
		
		for(String s: list)
			System.out.println(s);
	}
	
	public static void main(String[] args){
		
    	Scanner user_input = new Scanner( System.in );
    	System.out.println("please provide csv input:");
    	try{
    		String input = user_input.nextLine(); // read complete line with spaces
        	user_input.close();
        	//System.out.println("input="+input);
        	parse(input);
    	}catch(Exception e){
    		System.out.println("Error in input");
    	}
    	
		
	}
}
