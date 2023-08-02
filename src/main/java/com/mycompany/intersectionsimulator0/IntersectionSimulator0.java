package com.mycompany.intersectionsimulator0;
import java.util.*;

public class IntersectionSimulator0 {

   private static final int SIMULATION_TIME_SECONDS = 10;

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        Random rand = new Random();

        // Create cars with random speeds, directions, and colors
        Car[] cars = new Car[20];
        for (int i = 0; i < cars.length; i++) {
            int speed = rand.nextInt(60) + 20; // Speed between 20 and 80 km/h
            String[] directions = {"N", "S", "E", "W"};
            String direction = directions[rand.nextInt(directions.length)];

            String[] colors = {"Red", "Green", "Blue", "Orange", "Pink"};
            String color = colors[rand.nextInt(colors.length)];

            cars[i] = new Car(speed, direction, color);
        }

        // Simulate the intersection for a fixed number of seconds
        for (int time = 0; time < SIMULATION_TIME_SECONDS; time++) {
            System.out.println("Time: " + time + " seconds");

            // Randomly set the traffic light to green for one direction
            int randomDirectionIndex = rand.nextInt(4);
            String[] directions = {"N", "S", "E", "W"};
            String greenDirection = directions[randomDirectionIndex];
            System.out.println("Traffic light is green for: " + greenDirection);
            trafficLight.setGreen(true);

            // Simulate car movements and update traffic light
            Map<String, Map<String, Integer>> report = new HashMap<>();
            for (Car car : cars) {
                if (car.getDirection().equals(greenDirection)) {
                    System.out.println("Car going " + car.getDirection() + " with speed " + car.getSpeed() + " km/h and color " + car.getColor());

                    // Update the report
                    Map<String, Integer> directionMap = report.getOrDefault(car.getDirection(), new HashMap<>());
                    directionMap.put(car.getColor(), directionMap.getOrDefault(car.getColor(), 0) + 1);
                    report.put(car.getDirection(), directionMap);
                } else {
                    System.out.println("Car waiting at red light: " + car.getDirection());
                }
            }

            trafficLight.setGreen(false); // Set the traffic light back to red
            System.out.println("------------------");

            try {
                Thread.sleep(1000); // Wait for 1 second in the simulation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Print the report at the end of each cycle
            System.out.println("Current Report:");
            for (String direction : report.keySet()) {
                System.out.println("Direction: " + direction);
                Map<String, Integer> directionMap = report.get(direction);
                for (String color : directionMap.keySet()) {
                    int count = directionMap.get(color);
                    System.out.println("- " + color + ": " + count);
                }
            }
            System.out.println("------------------");
        }
    }
}
