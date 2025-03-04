import java.util.*;

public class Train {

    List<String> availableBerth=new ArrayList<>(Arrays.asList("Lower Berth","Middle berth","Upper Berth"));
    List<Passanger> passangerList=new ArrayList<>();
    Queue<Passanger> RACQueue=new LinkedList<>();
    Queue<Passanger> WaitingList=new LinkedList<>();
    static int RAC=1;
    static int waitingList=1;


     public String toCheckavilablity(int age,char gender,String berth){
         if(age>60||gender=='F'||berth=="L") {
             if(availableBerth.contains("L")){return "Lower Berth";}
         }
         else if(availableBerth.contains(berth)){
             return berth;
             }

         return availableBerth.get(0);
     }

}

