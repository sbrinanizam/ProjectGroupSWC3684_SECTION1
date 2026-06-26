public class ShipmentInfo
{
    private String shipmentId;
    private String packageType;
    private int ecoPriorityScore;
    private String dispatchDate;
    private int estimatedTransitTime;
    private double carbonTaxCost;

    //Constructor
    public ShipmentInfo(String shipmentId, String packageType, int ecoPriorityScore, String dispatchDate, int estimatedTransitTime, double carbonTaxCost )
    {
        this.shipmentId = shipmentId;
        this.packageType = packageType;
        this.ecoPriorityScore = ecoPriorityScore;
        this.dispatchDate = dispatchDate;
        this.estimatedTransitTime = estimatedTransitTime;
        this.carbonTaxCost = carbonTaxCost;
    }
    //Getters
    public String getShipmentId()
    {
        return shipmentId;
    }
    public String getPackageType()
    {
        return packageType;
    }
    public int getEcoPriorityScore()
    {
        return ecoPriorityScore;
    }
    public String getDispatchDate()
    {
        return dispatchDate;
    }
    public int getEstimatedTransitTime()
    {
        return estimatedTransitTime;
    }
    public double getCarbonTaxCost()
    {
        return carbonTaxCost;
    }
    //Setters
    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
    }
    public void setPackageType(String packageType)
    {
        this.packageType = packageType;
    }
    public void setEcoPriorityScore(int ecoPriorityScore)
    {
        this.ecoPriorityScore = ecoPriorityScore;
    }
    public void setDispatchDate(String dispatchDate)
    {
        this.dispatchDate = dispatchDate;
    }
    public void setEstimatedTransitTime(int estimatedTransitTime)
    {
        this.estimatedTransitTime = estimatedTransitTime;
    }
    public void setCarbonTaxCost(double carbonTaxCost)
    {
        this.carbonTaxCost = carbonTaxCost;
    }
}