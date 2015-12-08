/******************************************
* Programmer : Anthony D'Ambrosio
* Date       : 11/10/2015
* Purpose    : Net Worth
* Notes      :
******************************************/
package InheritanceDesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccount extends Asset implements ActionListener
{
    private double balance;
    public String assetName;
    
    private JFrame frame = new JFrame("Bank Account");
    
    private JPanel contentPane = new JPanel();
    
    private JLabel NameL = new JLabel("Name");
    private JLabel BalanceL = new JLabel("Balance");

    private JTextField NameTF = new JTextField(150);
    private JTextField BalanceTF = new JTextField(150);

    private JButton CancelB = new JButton("Cancel");
    private CancelButtonHandler cbHandler = new CancelButtonHandler();
    private JButton SaveB = new JButton("Save");
    private SaveButtonHandler sbHandler = new SaveButtonHandler();
    
    public BankAccount()
    {
        frame.setSize( 300, 200);

        contentPane.setBackground( Color.GRAY );
        contentPane.setLayout(null);
        
        // Set location
        NameL.setLocation( 5, 5 );
        BalanceL.setLocation( 5, 50 );
        NameTF.setLocation(75, 5);
        BalanceTF.setLocation( 75, 50 );
        CancelB.setLocation(5, 125);
        SaveB.setLocation(175, 125);


        // Set Size
        NameL.setSize( 50, 20 );
        BalanceL.setSize(50, 20);
        NameTF.setSize(150, 20);
        BalanceTF.setSize(150, 20);
        CancelB.setSize(100, 20);
        SaveB.setSize(100, 20);

        // Rig the buttons
        CancelB.addActionListener(cbHandler);
        SaveB.addActionListener(sbHandler);
        
        // Add to content pane
        contentPane.add(NameL);
        contentPane.add(BalanceL);
        contentPane.add(NameTF);
        contentPane.add(BalanceTF);
        contentPane.add(CancelB);
        contentPane.add(SaveB);
        frame.add(contentPane);
        
        super.name = assetName;
        
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
    
    
    private class CancelButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            frame.dispose();
        }
    }
    
    private class SaveButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            assetName = NameTF.getText();
            balance = Double.parseDouble( BalanceTF.getText());
            System.out.println(name);
            System.out.println(balance);
            frame.dispose();
        }
    }
    
    @Override 
    public void actionPerformed ( ActionEvent e )
    {
    }
    
    @Override 
    public double getAssetValue()
    {
        return balance;
    }
    
    @Override
    public double getDebtValue() 
    {
        double dummy = 0; 
        return dummy;
    }
    
    @Override 
    public String toString()
    {
        return this.getClass().getSimpleName() + ", Balance: " + balance;
    }
    
    public String getAssetName()
    {
        System.out.println("assetName" + assetName);
        return assetName;
    }
}
