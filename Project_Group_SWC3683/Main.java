import javax.swing.*;

public class Main {
    public static void main(String[] args){
        //Test

        //Create LogisticsManager object to handle all logistics operations
        LogisticsManager lm = new LogisticsManager();

        String input;
        int menu = 0;
        boolean loop = true;

        //Continue displaying menu until user chooses Exit
        while (loop) {
            //Display system menu and get user's choice
            input = JOptionPane.showInputDialog("""
                        ECO LOGISTICS SYSTEM
                    
                    1. Load Manifest File
                    2. Create Routing Queue
                    3. Display Queues
                    4. Process Shipment
                    5. Departure Log
                    6. Exit
                    
                    Enter Choice:
                    """);

            if (input == null) {
                // Handle cancel(exit or do nothing)
                JOptionPane.showMessageDialog(null, "User Cancelled The Operation.");
                return;
            }
            //Convert user input from String into int menu option
            menu = Integer.parseInt(input);

            //Location of the shipment manifest file
            String fileName = "C:\\Users\\ryene\\Project_Group_SWC3683\\supply_chain_manifest.txt";

            //Perform action based on user's menu selection
            switch (menu)
            {
                case 1://Load Manifest file
                    JOptionPane.showMessageDialog(null, lm.loadFile(fileName));
                    break;

                case 2://CREATE ROUTING QUEUE
                    //Organize carrier into different queues based on shipment amount
                    lm.createQueue();
                    JOptionPane.showMessageDialog(null, " Routing Queue Created Successfully.");
                    break;

                case 3://DISPLAY QUEUES
                    //Display carriers inside Regional queue
                    System.out.println("====Regional Micro-Distribution Queue====\n");
                    lm.displayQueue(lm.regional);

                    // Display carriers inside Cross-Border queue
                    System.out.println("====Cross-Border Express Queue====\n");
                    lm.displayQueue(lm.crossBorder);

                    // Display carriers inside Industrial queue
                    System.out.println("====Industrial Bulk Logistics Fleet====\n");
                    lm.displayQueue(lm.industrial);
                    break;

                case 4://PROCESS SHIPMENT
                    //Process carriers and move them into the dispatched stack
                    lm.processShipment();
                    JOptionPane.showMessageDialog(null, "Shipment Process Completed.");
                    break;

                case 5://DEPARTURE LOG
                    //Display departure records from the dispatched stack
                    lm.departureLog();
                    break;

                case 6://EXIT
                    //Stop the menu loop and close all the system
                    loop = false;
                    break;
            }
        }
    }
}
