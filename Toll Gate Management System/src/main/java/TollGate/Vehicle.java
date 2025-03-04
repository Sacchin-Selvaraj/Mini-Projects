package TollGate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.text.DateFormat;
import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Vehicle {

    private String vehicleId;
    private String vehicleType;
    private int startingPoint;
    private  int DestinationPoint;
    private double amount;
    private String tollPass;
    private String wayType;
    private Date date;

    public Vehicle(String vehicleId, String vehicleType, int startingPoint, int destinationPoint, String tollPass, String wayType, Date date) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.startingPoint = startingPoint;
        this.DestinationPoint = destinationPoint;
        this.tollPass = tollPass;
        this.wayType = wayType;
        this.date = date;
    }
}
