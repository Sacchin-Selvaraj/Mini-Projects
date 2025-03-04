package Taxi;

import java.util.ArrayList;
import java.util.List;

import static Taxi.BookingSystem.taxi;

public class Taxi {

    List<Customer> customer=new ArrayList<>();
    private int total_earnings=0;
    private char current_location='A';
    private int taxi_id;//

    public Taxi() {
    }

    public Taxi(int taxi_id) {
        this.taxi_id=taxi_id;
    }
    public void addBooking(Customer booking) {
        customer.add(booking);
        total_earnings += booking.getAmount();
        current_location = booking.getDrop_location();
    }
    public boolean toCheckTaxi(int pickup){
        boolean found=false;
        if(customer.isEmpty()){
            return true;
        }
        Customer lastbooking=customer.get(customer.size()-1);
        if(lastbooking.getDrop_time()<=pickup){
            found=true;
        }
        return found?true:false;
    }
     void toGetBookingDetails() {
         System.out.println("Size:"+customer.size());
        System.out.printf("%-10s %-10s %-4s %-5s %-7s %-8s %-6s%n",
                "CustomerId", "BookingId", "Pickup", "Drop", "Amount", "PickupTime", "DropTime");
        for(Taxi taxi:taxi) {
             for (Customer cust : taxi.customer) {
                 System.out.printf("%-10d %-10d %-6c %-5c %-7d %-10d %-6d%n",
                         cust.getCustomer_id(), cust.getBooking_id(),
                         cust.getPickup_location(), cust.getDrop_location(),
                         cust.getAmount(), cust.getPickup_time(), cust.getDrop_time());
             }
        }

    }

    public int getTotal_earnings() {
        return total_earnings;
    }

    public void setTotal_earnings(int total_earnings) {
        this.total_earnings = total_earnings;
    }

    public char getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(char current_location) {
        this.current_location = current_location;
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }
}
