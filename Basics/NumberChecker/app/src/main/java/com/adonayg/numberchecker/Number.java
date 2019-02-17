package com.adonayg.numberchecker;

public class Number {

    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isTriangular(){
        int x = 1;

        int triangularNumber = 1;

        while(triangularNumber < number){
            x++;
            triangularNumber += x;
        }

        if(triangularNumber == number){
            return true;
        } else {
            return false;
        }
    }

    public boolean isSquare(){
        double squareRoot = Math.sqrt(number);
        if (squareRoot == Math.floor(squareRoot)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isCube() {
        double cubeRoot = Math.cbrt(number);
        if (cubeRoot == Math.floor(cubeRoot)){
            return true;
        } else {
            return false;
        }
    }
}
