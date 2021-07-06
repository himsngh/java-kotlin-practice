package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer,Location> location=new HashMap<>();
    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        location.put(0,new Location(0,"You are sitting in front of your computer and learning java."));
        location.put(1,new Location(1,"You are on the road now ."));
        location.put(2,new Location(2,"You are going towards the jungle"));
        location.put(3,new Location(3,"you are at the hill"));
        location.put(4,new Location(4,"YOu are inside the building"));
        location.put(5,new Location(5,"You are in the forest."));

        location.get(1).addExit("N",5);
        location.get(1).addExit("W",2);
        location.get(1).addExit("E",3);
        location.get(1).addExit("S",4);

        location.get(2).addExit("N",5);

        location.get(3).addExit("W",1);

        location.get(4).addExit("N",1);
        location.get(4).addExit("W",2);

        location.get(5).addExit("S",1);
        location.get(5).addExit("W",2);

        Map<String,String> voculabary= new HashMap<>();
        voculabary.put("QUIT","Q");
        voculabary.put("NORTH","N");
        voculabary.put("SOUTH","S");
        voculabary.put("EAST","E");
        voculabary.put("WEST","W");

        int loc=1;
        while(true){
            System.out.println(location.get(loc).getDescription());
            if(loc==0){
                break;
            }
            System.out.print("Available Directions : ");
            Map <String,Integer> map=location.get(loc).getExits();
            for(String s:map.keySet()){
                System.out.print(s+" ");
            }
            System.out.println();
            String direction=sc.nextLine().toUpperCase();

            if(direction.length() > 1) {
                String[] key=direction.split(" ");
                for (String s : key) {
                    if (voculabary.containsKey(s)) {
                        direction = voculabary.get(s);
                        System.out.println("You are going in the "+ s +" direction.");
                        break;
                    }
                }

            }
            if(map.containsKey(direction)){
                    loc=map.get(direction);

            }else{
                System.out.println("You are going in the wrong direction.");
            }



        }
    }
}
