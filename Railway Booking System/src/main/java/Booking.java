import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Booking extends Train{

    static int bookingCounter=0;
    String allocatedBerth=null;

    public static String generateBookingID() {
        bookingCounter++;
        return "T" + bookingCounter;
    }

    Scanner sc=new Scanner(System.in);
    public Booking() {
        while (true) {
            System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.View Booked Tickets\n4.View Available Tickets\n5.RAC Tickets\n6.Waiting List\n7.Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        toBookTicket();
                        break;
                    case 2:
                        toCancelTicket();
                        break;
                    case 3:
                        BookedTicket();
                        break;
                    case 4:
                        AvailableTicket();
                        break;
                    case 5:
                        RACTicket();
                        break;
                    case 6:

                        WaitingList();
                        break;
                    case 7:
                        System.exit(1);
                    default:
                        System.out.println("Please enter valid Data!!!");
                }

        }
    }
    private void toBookTicket() {

        System.out.println("Enter the Name:");
        String name=sc.next();
        System.out.println("Enter the Age:");
        int age=sc.nextInt();
        System.out.println("Enter the Gender(M/F):");
        char gender=sc.next().toUpperCase().charAt(0);
        System.out.println("Enter the Berth Preference(L/M/U):");
        String berth=sc.next().toUpperCase();
        Passanger passanger=null;
        if(!availableBerth.isEmpty()){
            String allocatedBerth=toCheckavilablity(age,gender,berth);
            passanger=new Passanger(name,age,gender,berth,generateBookingID(),allocatedBerth);
            passangerList.add(passanger);
            availableBerth.remove(allocatedBerth);
            System.out.println("Ticket Confirmed "+passanger);
        } else if (RACQueue.size()<1) {
            String allocatedBerth="RAC";
            passanger=new Passanger(name,age,gender,berth,generateBookingID(),allocatedBerth);
            System.out.println("RAC Ticket has been Confirmed as of Now");
            RACQueue.add(passanger);
        }else if (WaitingList.size()<1) {
            allocatedBerth = "Waiting List";
            passanger = new Passanger(name,age, gender, berth, generateBookingID(), allocatedBerth);
            WaitingList.add(passanger);
            System.out.println("Your in Waiting List");
        }
        else {
            System.out.println("No Seats Available");
            return;
        }

        System.out.println("Ticket Booked Successfully!!!!");

        System.out.println("Tickets Available :"+availableBerth.size());

    }
    private void toCancelTicket() {
        if(passangerList.isEmpty()){
            System.out.println("No Passenger Available!!!");
        }
        System.out.println("Enter the Booking Id:");
        String BookingId=sc.next();
        Passanger selctedpassenger = null;
        for(Passanger pass:passangerList){
            if(BookingId.equals(pass.getBooking_id())){
                selctedpassenger=pass;
            }
        }
        allocatedBerth= selctedpassenger.getAllocatedBerth();
        availableBerth.add(allocatedBerth);
        System.out.println("Ticket Cancelled Successfully "+selctedpassenger);
        passangerList.remove(selctedpassenger);
        if(!RACQueue.isEmpty()){
            selctedpassenger=RACQueue.poll();
            allocatedBerth=toCheckavilablity(selctedpassenger.getAge(),selctedpassenger.getGender(),selctedpassenger.getBerth());
            availableBerth.remove(allocatedBerth);
            selctedpassenger.setAllocatedBerth(allocatedBerth);
            passangerList.add(selctedpassenger);
            System.out.println(selctedpassenger.getName()+" - Moved to Confirmed berth");
            if(!WaitingList.isEmpty()){
                selctedpassenger=WaitingList.poll();
                allocatedBerth="RAC";
                selctedpassenger.setAllocatedBerth(allocatedBerth);
                RACQueue.add(selctedpassenger);
                System.out.println("Passenger Moved to RAC -"+selctedpassenger);
            }
        }

    }

    private void BookedTicket() {
        System.out.printf("%-10s %-15s %-6s %-8s %-8s %-15s%n",
                "BookingId", "Name", "Age", "Gender", "Berth", "Allocated Berth");
        for (Passanger pass : passangerList) {
            System.out.printf("%-10s %-15s %-6d %-8c %-8s %-15s%n",
                    pass.getBooking_id(), pass.getName(), pass.getAge(), pass.getGender(), pass.getBerth(), pass.getAllocatedBerth());
        }
    }
    private void AvailableTicket() {
        System.out.println("Available Tickets :"+availableBerth.size());
        System.out.println("RAC Available Ticket :"+RACQueue.size());
        System.out.println("Waiting List :"+WaitingList.size());

    }
    private void RACTicket() {
        System.out.println("RAC Tickets :"+RAC);
        for(Passanger rac:RACQueue){
            System.out.println(rac);
        }
    }
    private void WaitingList() {
        System.out.println("Waiting List :"+waitingList);
        for(Passanger rac:WaitingList){
            System.out.println(rac);
        }
    }

}

