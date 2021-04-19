package main;

import model.Plane;
import service.PlaneService;

import java.util.Scanner;

public class AirportTest {
    public static void main(String[] args) {
        PlaneService service = new PlaneService();
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        Plane plane1 = service.create();
        Plane plane2 = service.create();
        Plane plane3 = service.create();
        Plane[] planes = {plane1, plane2, plane3};

        plane1.printInfo();
        plane2.printInfo();
        plane3.printInfo();

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Print cost and topSpeed if the plane is military otherwise print model and country");
            System.out.println("2. Return the plane which one is newer ");
            System.out.println("3. Print country of the plane with smallest seats count ");
            System.out.println("4. Print all not military planes.");
            System.out.println("5. Print all military planes which were in air more than 100 hours.");
            System.out.println("6. Return the plane with minimal weight.");
            System.out.println("7. Return the plane with minimal cost from all military planes .");
            System.out.println("8. Print planes in ascending form order by year");
            System.out.println("9. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    service.printDependsOnMilitary(plane1);
                    break;
                case 2:
                    service.newerPlane(plane1, plane2).printInfo();
                    break;
                case 3:
                    service.printSmallestSeatsPlaneCountry(plane1, plane2, plane3);
                    break;
                case 4:
                    service.printNotMilitaryPlanes(planes);
                    break;
                case 5:
                    service.printPlanesInAirMoreThan100hours(planes);
                    break;
                case 6:
                    service.planeWithMinWeight(planes).printInfo();
                    break;
                case 7:
                    service.militaryPlaneWithMinCost(planes).printInfo();
                    break;
                case 8:
                    service.sortByYear(planes);
                    break;
                case 9:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }
}
