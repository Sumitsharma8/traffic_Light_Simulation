/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.intersectionsimulator0;

/**
 *
 * @author mwichabe
 */
public class Car {
    private int speed;       // Speed in km/h
    private final String direction; // Direction: "N" (North), "S" (South), "E" (East), "W" (West)
    private final String color;    // Color of the car

    public Car(int speed, String direction, String color) {
        this.speed = speed;
        this.direction = direction;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void accelerate(int amount) {
        speed += amount;
    }

    public void brake(int amount) {
        speed = Math.max(0, speed - amount);
    }

    public String getDirection() {
        return direction;
    }

    public String getColor() {
        return color;
    }    
}
