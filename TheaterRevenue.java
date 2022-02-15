/* Program: TheaterRevenue
   Date: May 1, 2018
   Author: Jonathan Price
   
   This program is designed to ask the user to
   enter the costs and amounts sold of adult tickets
   and child tickets in one night at a movie theater,
   then display the gross adult ticket revenue, gross
   child ticket revenue, net adult ticket revenue, net
   child ticket revenue, total gross revenue, and total
   net revenue earned with the user's entered figures. 
   When run, this program will display a window with 
   a set of instructions on how to input the cost of an
   adult ticket, the cost of a child ticket, the amount
   of adult tickets sold, and the amount of child tickets
   sold along with the four textboxes to enter the required
   figures and a button to initiate the calculation. After 
   being executed, this program needs the user to enter the
   cost of an adult ticket, the cost of a child ticket, the
   amount of adult tickets sold, and the amount of child
   tickets sold before clicking the "Calculate" button. The
   user must also click the "OK" button on each pop-up to
   dismiss it.
   
*/

import javax.swing.*;   //Needed for Swing classes
import java.awt.event.*;   //Needed for ActionListener Interface

/**
   The TheaterRevenue class displays a JFrame that
   lets the user enter the price of an adult ticket,
   the price of a child ticket, the amount of adult
   tickets sold, and the amount of child tickets
   sold into four text fields. When the Calculate 
   button is clicked, a dialog box is displayed with
   the gross revenue for adult tickets sold. When the
   "OK" button is clicked in the pop-up, it will create
   a new pop-up with additional information until there
   is no longer any further information to be displayed
*/

public class TheaterRevenue extends JFrame
{
   private JPanel panel;   //To reference a panel
   private JLabel messageLabel1;  //To reference a label for instructions
   private JLabel messageLabel2;  //To reference a label for instructions
   private JLabel messageLabel3;  //To reference a label for instructions
   private JLabel messageLabel4;  //To reference a label for instructions
   private JLabel messageLabel5;  //To reference a label for instructions
   private JTextField adultTicketPriceField; //Adult ticket price field
   private JTextField childTicketPriceField; //Child ticket price field
   private JTextField adultTicketsSoldField; //Adult tickets sold field
   private JTextField childTicketsSoldField; //Child tickets sold field
   private JButton calcButton;   //To reference a button
   private final int WINDOW_HEIGHT = 300; //Window height
   private final int WINDOW_WIDTH = 175;  //Window width
   
   /**
      Constructor
   */
   
   public TheaterRevenue()
   {
      //Set the window title
      setTitle("Theater Revenue Calculator");
      
      //Set the size of the window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      //Specify what happens when close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Build the panel and add it to the frame
      buildPanel();
      
      //Add the panel to the frame's content pane
      add(panel);
      
      //Display the window
      setVisible(true);
   }
   
   /**
      The buildPanel method adds a label, text field, and button to a panel
   */
   
   private void buildPanel()
   {
      //Create label to display first part of instructions
      messageLabel1 = new JLabel("Enter the prices and amounts");
      
      //Create label to display second part of instructions
      messageLabel2 = new JLabel("of adult and child sales in this");
      
      //Create label to display third part of instructions
      messageLabel3 = new JLabel("order: adult ticket price, child");
      
      //Create label to display fourth part of instructions
      messageLabel4 = new JLabel("ticket price, adult tickets sold,");
      
      //Create label to display second part of instructions
      messageLabel5 = new JLabel("child tickets sold");
      
      //Create a text field 10 characters wide for adult ticket price       
      adultTicketPriceField = new JTextField(10);
      
      //Create a text field 10 characters wide for child ticket price         
      childTicketPriceField = new JTextField(10);
      
      //Create a text field 10 characters wide for adult tickets sold     
      adultTicketsSoldField = new JTextField(10);
      
      //Create a text field 10 characters wide for child tickets sold
      childTicketsSoldField = new JTextField(10);
      
      //Create a button with the caption "Calculate"
      calcButton = new JButton("Calculate");
      
      //Add an action listener to the button
      calcButton.addActionListener(new CalcButtonListener());
      
      //Create a JPanel object and let the panel field reference it
      panel = new JPanel();
      
      //Add the labels, text fields, and button components to the panel
      panel.add(messageLabel1);
      panel.add(messageLabel2);
      panel.add(messageLabel3);
      panel.add(messageLabel4);
      panel.add(messageLabel5);
      panel.add(adultTicketPriceField);
      panel.add(childTicketPriceField);
      panel.add(adultTicketsSoldField);
      panel.add(childTicketsSoldField);
      panel.add(calcButton);
   }
   
   /**
      CalcButtonListener is an action listener class for the Calculate button
   */
   
    private class CalcButtonListener implements ActionListener
   {
      /**
         The actionPerformed method executed when the user clicks on the
         Calculate button.
         @param e The event object
      */
      
      public void actionPerformed(ActionEvent e)
      {
         final double KEPT_REVENUE = 0.2; //Hold the percentage of kept revenue
         String adult_price_input;  //Hold the user's input for adult ticket price
         String child_price_input;  //Hold the user's input for child ticket price
         String adult_tickets_input;  //Hold the user's input for adult tickets sold
         String child_tickets_input;  //Hold the user's input for child tickets sold
         double adult_ticket_gross; //Hold the gross revenue for adult tickets sold
         double child_ticket_gross; //Hold the gross revenue for child tickets sold
         double adult_ticket_net;   //Hold the net revenue for adult tickets sold
         double child_ticket_net;   //Hold the net revenue for child tickets sold
         double total_gross;  //Hold the total gross revenue
         double total_net; //Hold the total net revenue
         
         //Get the adult ticket price
         adult_price_input = adultTicketPriceField.getText();
         
         //Get the child ticket price
         child_price_input = childTicketPriceField.getText();
         
         //Get the adult tickets sold
         adult_tickets_input = adultTicketsSoldField.getText();
         
         //Get the child tickets sold
         child_tickets_input = childTicketsSoldField.getText();
                            
         //Calculate the gross revenue for adult tickets
         adult_ticket_gross = (Double.parseDouble(adult_price_input)) * 
                              (Double.parseDouble(adult_tickets_input));
                              
         //Calculate the gross revenue for child tickets
         child_ticket_gross = (Double.parseDouble(child_price_input)) *
                              (Double.parseDouble(child_tickets_input));
                              
         //Calculate the net revenue for adult tickets
         adult_ticket_net = adult_ticket_gross * KEPT_REVENUE;
         
         //Calculate the net revenue for child tickets
         child_ticket_net = child_ticket_gross * KEPT_REVENUE;
         
         //Calculate the total gross revenue
         total_gross = adult_ticket_gross + child_ticket_gross;
         
         //Calculate the total net revenue
         total_net = adult_ticket_net + child_ticket_net;
         
         //Display the adult gross revenue
         JOptionPane.showMessageDialog(null, String.format("The gross revenue for" + 
                           " sold adult tickets is $%.2f", adult_ticket_gross));
                           
         //Display the child gross revenue
         JOptionPane.showMessageDialog(null, String.format("The gross revenue for" + 
                           " sold child tickets is $%.2f", child_ticket_gross));
                           
         //Display the adult net revenue
         JOptionPane.showMessageDialog(null, String.format("The net revenue for" + 
                           " sold adult tickets is $%.2f", adult_ticket_net));
                           
         //Display the child net revenue
         JOptionPane.showMessageDialog(null, String.format("The net revenue for" + 
                           " sold child tickets is $%.2f", child_ticket_net));
                           
         //Display the total gross revenue
         JOptionPane.showMessageDialog(null, String.format("The total gross revenue for" + 
                           " one night is $%.2f", total_gross));
                           
         //Display the total net revenue
         JOptionPane.showMessageDialog(null, String.format("The total net revenue for" + 
                           " one night is $%.2f", total_net));
      }
   }  //End of CalcButtonListener class
   
   /**
      The main method creates an instance of the TheaterRevenue
      class which displays its window on the screen
   */
   
   public static void main(String[] args)
   {
      new TheaterRevenue();
   }
}