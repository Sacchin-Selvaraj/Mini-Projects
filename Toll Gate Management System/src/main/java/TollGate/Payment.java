package TollGate;

public class Payment {

    public Payment() {

    }

    public int calculatePrice(int startingPoint, int destinationPoint, String vehicleType) {

        int[] bikePrices={20,25,30};
        int[] carPrices={50,60,70};
        int[] truckPrices={100,120,150};
        if(vehicleType.contains("Bike")){
            return calculateTollPrice(startingPoint,destinationPoint,bikePrices);
        } else if (vehicleType.contains("Car")) {
            return calculateTollPrice(startingPoint,destinationPoint,carPrices);
        } else if (vehicleType.contains("Truck")) {
            return calculateTollPrice(startingPoint,destinationPoint,truckPrices);
        }else {
            System.out.println("Entered Vehicle type is invalid");
            return 0;
        }

    }

    private int calculateTollPrice(int startingPoint, int destinationPoint, int[] Prices) {

        int amount=0;
        int a=Math.min(startingPoint,destinationPoint);
        int b=Math.max(startingPoint,destinationPoint);
        for (int i = a; i <=b ; i++) {
            amount=amount+Prices[i];
        }
        return amount;
    }


}
