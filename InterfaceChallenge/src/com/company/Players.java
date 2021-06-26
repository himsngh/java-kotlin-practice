package com.company;

import java.util.ArrayList;
import java.util.List;

public class Players implements Saveable {
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;


    public Players (String name,int hitPoints,int strength){
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
        this.weapon="Sword";
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public void read(List<String> savedValue) {
        if(savedValue != null && savedValue.size() >0){
            this.name = savedValue.get(0);
            this.hitPoints = Integer.parseInt(savedValue.get(1));
            this.strength = Integer.parseInt(savedValue.get(2));
            this.weapon= savedValue.get(3);

        }

    }

    @Override
    public List write() {
        List<String> values=new ArrayList();
        values.add(0,this.name);
        values.add(1," "+this.hitPoints);
        values.add(2," "+this.strength);
        values.add(3,this.weapon);
        return values;
    }
}
