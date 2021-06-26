package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Saveable {
    private String name;
    private List<String> monsterList=new ArrayList<>();

    public Monster(String name){
            this.name=name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void read(List<String> savedValue) {

    }

    @Override
    public List<String> write() {
        return null;
    }
}
