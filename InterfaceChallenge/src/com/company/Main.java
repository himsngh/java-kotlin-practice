package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Players him=new Players("Himansh",200,80);
        System.out.println(him.toString());
        saveObject(him);

        him.setHitPoints(100);
        System.out.println(him);
        him.setWeapon("Axe");
        saveObject(him);
        LoadObject(him);
        System.out.println(him);

    }

    public static List<String> readValue(){
        List<String> values=new ArrayList<>();
        boolean quit=true;
        int index=0;
        System.out.println("Choose the operation :" +
                        "1. To enter a string"+
                        "0. To quit");
        while(quit){
            System.out.println("Choose an option\n");
            Scanner sc=new Scanner(System.in);
            int i=sc.nextInt();
            sc.nextLine();
            switch (i){
                case 0:
                    quit=false;
                    break;
                case 1:
                    System.out.println("Enter the string to save: ");
                    String s=sc.nextLine();
                    values.add(index,s);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(Saveable objectToSave){
        for(int i=0;i<objectToSave.write().size();i++){
            System.out.println("Saving "+objectToSave.write().get(i) +" in the memory");
        }
    }
    public static void LoadObject(Saveable objectToLoad){
        List<String> object=readValue();
        objectToLoad.read(object);
    }
}
