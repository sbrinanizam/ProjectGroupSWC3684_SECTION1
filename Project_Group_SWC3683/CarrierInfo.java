import java.util.ArrayList;
import java.util.List;
public class CarrierInfo
{
    private String carrierId;
    private String carrierName;
    private String fleetType;
    private List<ShipmentInfo> shipments;

    //Constructor
    public CarrierInfo(String carrierId, String carrierName, String fleetType)
    {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.fleetType = fleetType;
        this.shipments = new ArrayList<>();
    }
    //Add shipment to carrier
    public void addShipment(ShipmentInfo shipment)
    {
        shipments.add(shipment);
    }
    public List<ShipmentInfo> getShipmentList()
    {
        return shipments;
    }
    //Getters and Setters
    public String getCarrierId()
    {
        return carrierId;
    }
    public void setCarrierId(String carrierId)
    {
        this.carrierId = carrierId;
    }
    public String getCarrierName()
    {
        return carrierName;
    }
    public void setCarrierName(String carrierName)
    {
        this.carrierName = carrierName;
    }
    public String getFleetType()
    {
        return fleetType;
    }
    public void setFleetType(String fleetType)
    {
        this.fleetType = fleetType;
    }

}