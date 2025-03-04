package TollGate;

import java.time.Instant;
import java.util.*;

public class TollGateProcess {
    Scanner sc = new Scanner(System.in);
    Payment p1 = new Payment();
    Deque<Vehicle> vehicles = new ArrayDeque<>();
    List<List<TollDetails>> tollDetails=new ArrayList<>();
    public static int id=0;
    int[] bikePrices={20,25,30};
    int[] carPrices={50,60,70};
    int[] truckPrices={100,120,150};

    private void config(){
        tollDetails.add(new ArrayList<>());
        tollDetails.add(new ArrayList<>());
        tollDetails.add(new ArrayList<>());
    }

    private void bookTollPass() {

        System.out.println("Enter the Vehicle Type : (eg:Bike,Car,Truck)");
        String vehicleType = sc.next();
        System.out.println("Enter the Starting Point :");
        int startingPoint = sc.nextInt();
        System.out.println("Enter the Destination Point :");
        int destinationPoint = sc.nextInt();
        System.out.println("Have TollPass (Yes/No) :");
        String tollPass = sc.next();
        System.out.println("Single Pass/Double Pass");
        String wayType = sc.next();
        double price = p1.calculatePrice(startingPoint, destinationPoint, vehicleType);
        if (tollPass.equals("Yes")) {
            price = price - (price * 0.2);
        }
        if (wayType.equals("Double")) {
            price = price * 2;
        }
        config();
        String id=generateVehicleId();
        Date date=Date.from(Instant.now());
        Vehicle vehicle=new Vehicle(id,vehicleType,startingPoint,destinationPoint,price,tollPass,wayType,date);

        Vehicle tollVehicle=new Vehicle(id,vehicleType,startingPoint,destinationPoint,tollPass,wayType,date);

        int min=Math.min(startingPoint,destinationPoint);
        int max=Math.max(startingPoint,destinationPoint);
        while(min<=max){
            if(vehicleType.equals("Bike")){
                price=bikePrices[min];
                tollVehicle.setAmount(price);
                String tollId=generateTollId();
                TollDetails tollDetails1=new TollDetails(tollId,tollVehicle);
                tollDetails.get(min).add(tollDetails1);
            } else if (vehicleType.equals("Car")) {
                price=carPrices[min];
                tollVehicle.setAmount(price);
                String tollId=generateTollId();
                TollDetails tollDetails1=new TollDetails(tollId,tollVehicle);
                tollDetails.get(min).add(tollDetails1);
            }else {
                price=truckPrices[min];
                tollVehicle.setAmount(price);
                String tollId=generateTollId();
                TollDetails tollDetails1=new TollDetails(tollId,tollVehicle);
                tollDetails.get(min).add(tollDetails1);
            }
            min++;
        }

        vehicles.offer(vehicle);
        System.out.println(vehicle);
        System.out.println("Success");
    }


    private void displayTollDetails() {
        System.out.println("Enter the Toll Id: eg(0,1,2)");
        int n=sc.nextInt();
        List<TollDetails> oneTollList=tollDetails.get(n).stream().toList();
        double amount=0;
        for (TollDetails toll:oneTollList){
            amount=amount+toll.getVehicleList().getAmount();
            System.out.println(toll);
        }
        System.out.println("Total Amount :"+amount);
    }

    private void displayVehicleDetails() {
        double amount=0;
        for (Vehicle vehicle:vehicles){
            amount=amount+vehicle.getAmount();
            System.out.println(vehicle);
        }
        System.out.println("Total Vehicle Amount: "+amount);
    }

    private void findMinimumDistance() {

        System.out.println("Enter the Vehicle Type : (eg:Bike,Car,Truck)");
        String vehicleType = sc.next();
        System.out.println("Enter the Starting Point :");
        int startingPoint = sc.nextInt();
        System.out.println("Enter the Destination Point :");
        int destinationPoint = sc.nextInt();
        System.out.println("Have TollPass (Yes/No) :");
        String tollPass = sc.next();
        System.out.println("Single Pass/Double Pass");
        String wayType = sc.next();
        int total=3;
        List<Integer> clockwise=new ArrayList<>();
        List<Integer> anticlockwise=new ArrayList<>();
        for (int i = startingPoint; i!=destinationPoint ; i=(i+1)%total) {
            clockwise.add(i);
        }
        clockwise.add(destinationPoint);
        for (int i = startingPoint; i!=destinationPoint ; i=(i-1+total)%total) {
            anticlockwise.add(i);
        }
        anticlockwise.add(destinationPoint);
        System.out.println(clockwise.size()<=anticlockwise.size()?clockwise:anticlockwise);


    }

    public String generateVehicleId(){

        return "V"+id++;
    }
    public String generateTollId(){

        return "T"+id++;
    }

    public TollGateProcess() {

        while (true) {
            System.out.println("\n-----Welcome to the TollGate Management System-----");
            System.out.println("1.Process Journey\n2.Display Toll Details\n3.Display Vehicle\n4.Find the Minimum Toll Amount\n5.Exit");
            System.out.println();
            System.out.println("Enter your Choice :");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        bookTollPass();
                        break;
                    case 2:
                        displayTollDetails();
                        break;
                    case 3:
                        displayVehicleDetails();
                        break;
                    case 4:
                        findMinimumDistance();
                        break;
                    case 5:
                        System.out.println("Exiting!!!");
                        System.exit(1);
                    default:
                        System.out.println("Invalid Choice");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Enter only Numeric Values");
                sc.nextLine();
            }
        }

    }
}
