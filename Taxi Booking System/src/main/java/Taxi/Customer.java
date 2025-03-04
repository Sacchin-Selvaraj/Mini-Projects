package Taxi;

public class Customer {

    private int customer_id;
    private int booking_id;
    private int amount;
    private int pickup_time;
    private int drop_time;
    private char pickup_location;
    private char drop_location;

    public Customer(int customer_id, int booking_id, int amount, int pickup_time, int drop_time, char pickup_location, char drop_location) {
        this.customer_id = customer_id;
        this.booking_id = booking_id;
        this.amount = amount;
        this.pickup_time = pickup_time;
        this.drop_time = drop_time;
        this.pickup_location = pickup_location;
        this.drop_location = drop_location;


    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(int pickup_time) {
        this.pickup_time = pickup_time;
    }

    public char getPickup_location() {
        return pickup_location;
    }

    public void setPickup_location(char pickup_location) {
        this.pickup_location = pickup_location;
    }

    public int getDrop_time() {
        return drop_time;
    }

    public void setDrop_time(int drop_time) {
        this.drop_time = drop_time;
    }

    public char getDrop_location() {
        return drop_location;
    }

    public void setDrop_location(char drop_location) {
        this.drop_location = drop_location;
    }
}
