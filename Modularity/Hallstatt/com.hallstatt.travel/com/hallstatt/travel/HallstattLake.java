package com.hallstatt.travel;
 
public class HallstattLake {
    public static void main(String[] args) {
        System.out.println(new HallstattLake().boat("Crystal Clear"));
    }
 
    public String boat(String name) {
        return "The water  is " + name + "!";
    }
}