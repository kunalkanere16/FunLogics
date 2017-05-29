package com.service;

import java.util.ArrayList;
import java.util.Scanner;

public class TimeConfusion {

	
	public static void sortList(ArrayList<Time> list){
		for(int j=0; j<list.size()-1; j++){
			for(int i=0; i<list.size()-1;i++){
				
				if(list.get(i).getHour()>list.get(i+1).getHour()){
					//swap
					Time t1 = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, t1);
				}
				else if(list.get(i).getHour() == list.get(i+1).getHour()){
					//check minutes
					if(list.get(i).getMinute()>list.get(i+1).getMinute()){
						//swap
						Time t1 = list.get(i);
						list.set(i, list.get(i+1));
						list.set(i+1, t1);
					}
				}
			}
		}
	}
	
	//going t1 to t2 clockwise
	public static int clockdiff(Time t1, Time t2){
		int diff=0;
		//e.g. 1 to 5
		if(t2.getHour()>t1.getHour()){
			
			if(t2.getMinute()>t1.getMinute()){
				diff = (t2.getHour()-t1.getHour())*60+(t2.getMinute()-t1.getMinute());
			}
			else if(t2.getMinute()<t1.getMinute()){
				diff = ((t2.getHour()-1)-t1.getHour())*60+((t2.getMinute()+60)-t1.getMinute());
			}
			else if(t2.getMinute() == t1.getMinute()){
				diff = (t2.getHour()-t1.getHour())*60;
			}
		}
		//e.g. 5 to 1
		else if(t2.getHour()<t1.getHour()){
			int x = 12-t1.getHour();
			
			if(t2.getMinute()>t1.getMinute()){
				
				diff = (x+t2.getHour())*60 + (t2.getMinute()-t1.getMinute());
			}
			else if(t2.getMinute()<t1.getMinute()){
				diff = (x+t2.getHour()-1)*60 + ((t2.getMinute()+60)-t1.getMinute());
			}
			else if(t2.getMinute() == t1.getMinute()){
				diff = (x+t2.getHour())*60;
			}
		}
		
		else if(t2.getHour() == t1.getHour()){
			if(t2.getMinute()>t1.getMinute()){
				diff = t2.getMinute()-t1.getMinute();
			}
			else if(t2.getMinute()<t1.getMinute()){
				diff = (11*60) + (60 - (t1.getMinute()-t2.getMinute()));
			}
		}
		return diff;
	}
		
	public static void main(String[] args){
		
		
		try{
			//Scan user input
			Scanner user_input = new Scanner( System.in );
			System.out.println("Please provide input:");
			int cases = Integer.parseInt(user_input.nextLine());
			ArrayList<String> inputList = new ArrayList<String>();
			for(int i=0; i<cases; i++)
				inputList.add(user_input.nextLine());
			user_input.close();
			
			Time t = null;
			for(String s: inputList){
				//String to list
				ArrayList<Time> list = new ArrayList<Time>();
				String[] arr = s.split(" ");
				for(String i: arr){
					
					//check for valid input
					if(Integer.parseInt(i.split(":")[0])<1 || Integer.parseInt(i.split(":")[0])>13)
						throw new Exception();
					else if(Integer.parseInt(i.split(":")[1])<0 || Integer.parseInt(i.split(":")[1])>59)
						throw new Exception();
					
					t = new Time();
					t.setHour(Integer.parseInt(i.split(":")[0]));
					t.setMinute(Integer.parseInt(i.split(":")[1]));
					list.add(t);
					
				}
				
				//sort the list
				sortList(list);
			//	System.out.println("sorted = "+list);
				
				ArrayList<ArrayList<Time>> result = new ArrayList<ArrayList<Time>>();
				int d1 = clockdiff(list.get(0), list.get(1));
				int d2 = clockdiff(list.get(1), list.get(2));
				
				if(d1==d2){
				//	System.out.println("case 1 match");
					result.add(list);
				}
				
				//Generate combination by rotating list clockwise once
				//rotate
				ArrayList<Time> combo2 = new ArrayList<Time>();
				combo2.add(list.get(2));
				combo2.add(list.get(0));
				combo2.add(list.get(1));
			//	System.out.println("combo2 = "+combo2);
				
				//Find time difference in minutes
				d1 = clockdiff(combo2.get(0), combo2.get(1));
				d2 = clockdiff(combo2.get(1), combo2.get(2));
				
				if(d1==d2){
					result.add(combo2);
				//	System.out.println("case 2 match");
				}
				
				//Generate combination by rotating list clockwise once
				//rotate
				ArrayList<Time> combo3 = new ArrayList<Time>();
				combo3.add(list.get(1));
				combo3.add(list.get(2));
				combo3.add(list.get(0));
			//	System.out.println("combo3 = "+combo3);
				
				d1 = clockdiff(combo3.get(0), combo3.get(1));
				d2 = clockdiff(combo3.get(1), combo3.get(2));
				if(d1==d2){
					result.add(combo3);
				//	System.out.println("case 3 match");
				}
				
				//Final output
				if(result.size()==1){
					int hour = result.get(0).get(1).getHour();
					int min = result.get(0).get(1).getMinute();
					
					System.out.println("The correct time is "+hour+":"+(min<10?("0"+min):min));
				}else{
					System.out.println("Look at the sun");
				}
			}
			
		}catch(Exception e){
			System.out.println("Error in input");
		}
	}
	
}
