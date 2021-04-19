package service;

import model.Plane;

import java.util.Scanner;

public class PlaneService {

    public Plane create() {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        System.out.println("Enter name of the plane");
        String model = s.next();
        System.out.println("Enter country the plane belongs to");
        String country = s.next();
        System.out.println("Enter plane publishing year");
        int year = s.nextInt();
        System.out.println("Enter how many hours plane was in air");
        int hours = s.nextInt();
        System.out.println("Enter plane is military or not (y/n) ");
        String input = s.next();
        boolean isMilitary = input.charAt(0) == 'y' || input.charAt(0) == 'Y';
        System.out.println("Enter weight of plane");
        double weight = s.nextDouble();
        System.out.println("Enter plane maximal speed per hour");
        double topSpeed = s.nextDouble();
        System.out.println("Enter number of seats in plane");
        int seats = s.nextInt();
        System.out.println("Enter cost of the plane");
        double cost = s.nextDouble();

        Plane plane = new Plane(model, country, year);
        plane.setCost(cost);
        plane.setHours(hours);
        plane.setSeats(seats);
        plane.setMilitary(isMilitary);
        plane.setWeight(weight);
        plane.setTopSpeed(topSpeed);

        return plane;
    }

    public void printDependsOnMilitary(Plane plane) {
        if (plane.isMilitary()) {
            System.out.printf("Cost: %f \t Top Speed: %f \n", plane.getCost(), plane.getTopSpeed());
        } else
            System.out.printf("Model: %s \t Country: %s \n", plane.getModel(), plane.getCountry());
    }

    public Plane newerPlane(Plane plane1, Plane plane2) {
        return plane1.getYear() >= plane2.getYear() ? plane1 : plane2;
    }

    public void printSmallestSeatsPlaneCountry(Plane plane1, Plane plane2, Plane plane3) {
        Plane withSmallestSeats = plane1.getSeats() <= plane2.getSeats() ? plane1 : plane2;

        if (plane3.getSeats() < withSmallestSeats.getSeats())
            withSmallestSeats = plane3;

        System.out.println(withSmallestSeats.getCountry());
    }

    public void printNotMilitaryPlanes(Plane[] planes) {
        for (Plane plane : planes)
            if (!plane.isMilitary())
                plane.printInfo();
    }

    public void printPlanesInAirMoreThan100hours(Plane[] planes) {
        for (Plane plane : planes) {
            if (plane.isMilitary() && plane.getHours() > 100)
                plane.printInfo();
        }
    }

    public Plane planeWithMinWeight(Plane[] planes) {
        Plane withMinWeight = planes[0];

        for (int i = 1; i < planes.length; i++) {
            if (planes[i].getWeight() <= withMinWeight.getWeight())
                withMinWeight = planes[i];
        }
        return withMinWeight;
    }

    public Plane militaryPlaneWithMinCost(Plane[] planes) {
        Plane withMinCost = null;

        for (Plane plane : planes) {
            if (plane.isMilitary()) {
                if (withMinCost == null) {
                    withMinCost = plane;
                } else {
                    if (plane.getCost() < withMinCost.getCost())
                        withMinCost = plane;
                }
            }
        }
        return withMinCost;
    }

    public void sortByYear(Plane[] planes) {
        boolean isActive = true;
        int countOfFor = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < planes.length - 1 - countOfFor; i++) {
                if (planes[i].getYear() > planes[i + 1].getYear()) {
                    Plane temp = planes[i];
                    planes[i] = planes[i + 1];
                    planes[i + 1] = temp;
                    isActive = true;
                }
            }
            countOfFor++;
        }

        for (Plane plane : planes)
            plane.printInfo();
    }
}
