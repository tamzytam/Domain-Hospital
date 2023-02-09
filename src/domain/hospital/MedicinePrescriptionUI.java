/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.hospital;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kellul
 */
public class MedicinePrescriptionUI extends JFrame{
    
    
    private JTextField txtMedicineName, txtMedicineDosage, txtMedicineType;
    private JLabel lblMedicineName, lblMedicineDosage, lblMedicineType;
    private JButton btnAdd, btnClear, btnExit;
    
    //Path where the file will be saved
    String prescriptionFileName = "Prescriptions.obj";

    // Instance of ApplicationLogic Class
    ApplicationLogic aLogic = new ApplicationLogic();
      
     
    //Default Constructor
    public MedicinePrescriptionUI(){
        
        buildMedicineInventroyGUI();
        
        //Assigning an on click event to add button. addMedicine() method will be executed
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to Add Medicine
                addMedicine();
               
            }
        });

        //Assigning an on click event to clear button. clear() method will be executed
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to clear all field records
                clear();
                
            }
        });

        //exit button
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               System.exit(0);
      
  
            }
        });
         
    
    }
    
     /*
    *Building the User Interface to capture the Medicine Details
     */
    public void buildMedicineInventroyGUI() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medicine Inventory");
        setSize(700, 700);
        setLocationRelativeTo(null);

        //This Panel will contain data input about the Prescription in a grid with 4 rows and 2 columns based on fields
        JPanel prescriptionMedicineDetailPanel = new JPanel(new GridLayout(5, 2));

        prescriptionMedicineDetailPanel.add(new JLabel("MEDICINE INVENTORY DETAILS"));
        prescriptionMedicineDetailPanel.add(new JLabel(" "));
        prescriptionMedicineDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        prescriptionMedicineDetailPanel.add(lblMedicineName = new JLabel("Name:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        prescriptionMedicineDetailPanel.add(txtMedicineName = new JTextField(25));

        prescriptionMedicineDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        prescriptionMedicineDetailPanel.add(lblMedicineDosage = new JLabel("Dosage:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        prescriptionMedicineDetailPanel.add(txtMedicineDosage= new JTextField(25));

        prescriptionMedicineDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        prescriptionMedicineDetailPanel.add(lblMedicineType = new JLabel("Type:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        prescriptionMedicineDetailPanel.add(txtMedicineType = new JTextField(25));
        
        
         //This Panel will contain form control buttons
        JPanel prescriptionMedicineFormControlPanel = new JPanel(new FlowLayout()); //Order Left to Right
        prescriptionMedicineFormControlPanel.add(btnAdd = new JButton("Add Medicine"));
        prescriptionMedicineFormControlPanel.add(btnClear = new JButton("Clear Medicine"));
        prescriptionMedicineFormControlPanel.add(btnExit = new JButton("Exit"));

        //add panels to frame
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(prescriptionMedicineDetailPanel, BorderLayout.CENTER);
        panel.add(prescriptionMedicineFormControlPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
                      
    }
   
    public void clear(){
    
    this.txtMedicineName.setText("");
    this.txtMedicineDosage.setText("");
    this.txtMedicineType.setText("");
        
    }
    
    
    public void addMedicine(){
    
    String medicineName, medicineDosage, medicineType, messageTobeDisplay;
    boolean quit;
    
    do{
    
    //Assigning the variable medicineName with the text submitted in the form textbox
            medicineName = this.txtMedicineName.getText();

            //Checking if the string variable medicineName is not null
            if (medicineName != null) {

                //Checking if the string variable medicineName is not empty
                if (medicineName.trim().equals("")) {

                    //Displaying a message box for the user to submit the medicine name
                    JOptionPane.showMessageDialog(null, "Medicine Name is Mandatory. Please submit Medicine Name", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //medicineName contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //medicineName is null and loop will break 
            } else {

                //Return to User 
                return;
            }
            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            
            //Assigning the variable medicineDosage with the text submitted in the form textbox
            medicineDosage = this.txtMedicineDosage.getText();

            //Checking if the string variable medicineDosage is not null
            if (medicineDosage != null) {

                //Checking if the string variable medicineDosage is not empty
                if (medicineDosage.trim().equals("")) {

                    //Displaying a message box for the user to submit the medicine dosage
                    JOptionPane.showMessageDialog(null, "Medicine Dosage is Mandatory. Please submit the Appropriate Dosage", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //medicineDosage contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //medicineDosage is null and loop will break 
            } else {

                //Return to User 
                return;
            }
            //-----------------------------------------------------------------------------------------------------------------------------------------------------
    
            //Assigning the variable medicineType with the text submitted in the form textbox
            medicineType = this.txtMedicineType.getText();

            //Checking if the string variable medicineType is not null
            if (medicineType != null) {

                //Checking if the string variable medicineType is not empty
                if (medicineType.trim().equals("")) {

                    //Displaying a message box for the user to submit the medicine Type
                    JOptionPane.showMessageDialog(null, "Medicine Type is Mandatory. Please submit the Appropriate Type", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //medicineType contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //medicineType is null and loop will break 
            } else {

                //Return to User 
                return;
            }
            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            
            //Setting the String variable messageTobeDisplay to empty
            messageTobeDisplay = "";

            //Validating and checking if a Medicine object with the same parameters exists already in the system, 
            Vector<MedicinePrescription> validateMedicineScheduleEntry = aLogic.checkMedicineIfExisits(medicineName, medicineDosage, medicineType);

            //If the vector validateMedicineScheduleEntry is returned empty, Medicine is not yet in stock and can be added to the inventory.
            if (validateMedicineScheduleEntry.isEmpty()) {

                //Setting the String variable messageTobeDisplay to - Adding to Inventory    
                messageTobeDisplay = "New Medicine to Be added to the Pharmacy Inventory";

                //Calling the addDoctorScheduleVector from the ApplicationLogic class to add the new Schedule Record
                aLogic.addMedicineVector(medicineName, medicineDosage, medicineType);

                //Displaying a message box informing the user that new Medicine record was successfully added to the list
                JOptionPane.showMessageDialog(null, "Successfully Added new Medicine List to the Inventory", "Inventory - ADD", JOptionPane.INFORMATION_MESSAGE);
            } else {

                //Setting the String variable messageTobeDisplay to - Medicine already exists     
                messageTobeDisplay = "Medicine already listed in the inventory";

            }

            //Displaying a messagebox with the messageTobeDisplay    
            JOptionPane.showMessageDialog(null,
                    messageTobeDisplay);
            
    
    }while(quit==true);
    
    
    
    }
    
}
