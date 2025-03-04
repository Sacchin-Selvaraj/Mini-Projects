package Taxi;
import java.util.*;

class BookingSystem extends Taxi{
    static Scanner sc=new Scanner(System.in);
    static List<Taxi> taxi=new ArrayList<>();
    static int booking_id=1;
    static int customer_id=101;


    public void toBookTaxi(){
        System.out.println("Enter Pickup Time (in hours):");
        int pickuptime = sc.nextInt();
        System.out.println("Enter the Pickup Point(A-F):");
        char pick= sc.next().toUpperCase().charAt(0);
        System.out.println("Enter the Drop Point(A-F):");
        char drop= sc.next().toUpperCase().charAt(0);
        int droptime=Math.abs(drop-pick)+pickuptime;
        if(droptime>=24){
            droptime-=24;
        }
        int totalditance=Math.abs(drop-pick)*15;
        int amount=Math.abs(totalditance-5)*10+100;
        System.out.println("Amount:"+amount);
        System.out.println(("Totaldistance:"+totalditance));
        System.out.println("Droptime:"+droptime);
        Taxi selectedTaxi=null;
        int minDistance=Integer.MAX_VALUE;

        for(Taxi taxi:taxi){

            if(taxi.toCheckTaxi(pickuptime)){

                    int distance=Math.min(taxi.getCurrent_location(),pick);
                    if(distance<minDistance|| (distance==minDistance&&taxi.getTotal_earnings()<selectedTaxi.getTotal_earnings())){
                        minDistance=distance;
                        selectedTaxi=taxi;
                    }
            }
        }

        if(selectedTaxi==null){
            System.out.println("No Taxis Available!!!");
            return;
        }
        Customer obj=new Customer(customer_id++,booking_id++,amount,pickuptime,droptime,pick,drop);
        selectedTaxi.addBooking(obj);

        System.out.println("Taxi "+selectedTaxi.getTaxi_id()+" have been Booked!!!");
    }


    private void toGetTaxiDetails() {
        for(Taxi taxi:taxi){
            System.out.println("Taxi No:"+taxi.getTaxi_id()+"   Total_Earnings Rs:"+taxi.getTotal_earnings()+"  Current_Location:"
                    +taxi.getCurrent_location());
        }
    }

    public BookingSystem() {
        super();
        System.out.println("Enter the No of Taxis");
        int n=sc.nextInt();
        for (int i = 1; i<=n; i++) {
            taxi.add(new Taxi(i));
        }

        while(true) {
            System.out.println("1.Book taxi\n2.Booking Details\n3.Taxi Details\n4.Exit");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    toBookTaxi();
                    break;
                case 2:
                    toGetBookingDetails();
                    break;
                case 3:
                    toGetTaxiDetails();
                    break;
                case 4:
                    System.out.println("Thanks you !!!!");
                    System.exit(0);
                default:
                    System.out.println("Enter the Valid details");
            }

        }
    }
}
