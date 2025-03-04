package TollGate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TollDetails {

    private String tollId;
    private Vehicle vehicleList;


}
