import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LogisticsManager{

    //Store all carrier information that is loaded from the manifest file
    LinkedList<CarrierInfo> carrierList = new LinkedList<>();

    //Create separate queue based on shipment category
    Queue<CarrierInfo> regional = new LinkedList<>();
    Queue<CarrierInfo> crossBorder = new LinkedList<>();
    Queue<CarrierInfo> industrial = new LinkedList<>();

    public LogisticsManager(){
    }

    public String loadFile(String fileName){

        String message = null;
        CarrierInfo carrierData = null;
        ShipmentInfo shipmentData = null;

        try {

            // Read shipment data from the given text file
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String freightData;

            //Read each line from the manifest file until the end
            while ((freightData = br.readLine()) != null){

                //Split each line using "|" delimiter to get individual data
                StringTokenizer itemToken = new StringTokenizer(freightData, "|");

                //Get carrier information from the file
                String tokenCarrierId = itemToken.nextToken();
                String tokenCarrierName = itemToken.nextToken();
                String tokenCarrierFleet = itemToken.nextToken();

                //Get shipment information from the file
                String tokenShipmentId = itemToken.nextToken();
                String tokenShipmentPackage = itemToken.nextToken();
                int tokenShipmentEcoPS = Integer.parseInt(itemToken.nextToken());
                String tokenShipmentDDate = itemToken.nextToken();
                int tokenShipmentETT = Integer.parseInt(itemToken.nextToken());
                double tokenShipmentCTC = Double.parseDouble(itemToken.nextToken());

                CarrierInfo existCarrier = null;

                //Check whether the carrier already exists in the carrier list
                for (CarrierInfo carrier : carrierList){
                    if (carrier.getCarrierId().equals(tokenCarrierId)){
                        existCarrier = carrier;
                        break;
                    }
                }
                //If carrier does not exists, create a new carrier object and store it
                if (existCarrier == null){
                    existCarrier = new CarrierInfo(tokenCarrierId, tokenCarrierName, tokenCarrierFleet);

                    carrierList.add(existCarrier);
                }
                //Create shipment object using the data form the file
                shipmentData = new ShipmentInfo(tokenShipmentId, tokenShipmentPackage, tokenShipmentEcoPS,
                                                tokenShipmentDDate,tokenShipmentETT, tokenShipmentCTC);

                //Add shipment into the related carrier's shipment list
                existCarrier.addShipment(shipmentData);
            }

            br.close();

            int shipmentCount = 0;

            //Calculate the total number of shipments loaded
            for (int i = 0; i < carrierList.size(); i++){
                CarrierInfo currentCarrier = carrierList.get(i);

                shipmentCount += currentCarrier.getShipmentList().size();
            }
            // Display loading result with total carrier and shipment count
            message = "Manifest Loaded Successfully.\nTotal Carrier: " + carrierList.size() + "\nTotal Shipment: " + shipmentCount;
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File Not Found.");
        }
        catch (IOException e){
            System.out.println("Error Reading File.");
        }
        return message;
    }
    public void createQueue(){

        boolean alternate = true;

        //Assign carrier into different queue based on shipment amount
        for (int i = 0; i < carrierList.size(); i++){
            CarrierInfo currentCarrier = carrierList.get(i);

            int shipmentCount = currentCarrier.getShipmentList().size();

            //Carriers with 3 or fewer shipments are assigned alternately
            if(shipmentCount <= 3){
                if(alternate){
                    regional.add(currentCarrier);
                    alternate = false;
                }
                else {
                    crossBorder.add(currentCarrier);
                    alternate = true;
                }
            }
            //Carriers with more than 3 shipments are assigned to industrial
            else {
                industrial.add(currentCarrier);
            }
        }
    }
    public void displayQueue(Queue<CarrierInfo> queue){
        //Display all carriers inside the selected queue
        for(CarrierInfo carrier : queue){

            System.out.println("Carrier Name: " + carrier.getCarrierName());
            System.out.println("Fleet Type: " + carrier.getFleetType());

            System.out.println("Shipments:");

            double totalCarbonTax = 0;
            //Display shipment details and calculate total carbon tax
            for(ShipmentInfo shipment : carrier.getShipmentList()){

                System.out.println(
                        " - Shipment ID: " + shipment.getShipmentId()
                );

                totalCarbonTax = totalCarbonTax + shipment.getCarbonTaxCost();
            }
            //Display total carbon tax cost for each carrier
            System.out.println("\nTotal Carbon Tax Cost: RM" + totalCarbonTax);
            System.out.println("----------------------------------------\n");
        }

    }
}