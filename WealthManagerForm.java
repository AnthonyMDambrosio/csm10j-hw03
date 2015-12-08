import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import InheritanceDesign.*;

public class WealthManagerForm extends JFrame implements ActionListener, WindowListener, MouseListener
{   
    private int previousY = 30;
    private String name;
    private Double balance;
    
    private JFrame frame = new JFrame("Wealth Manager");
    private JFrame frame2;
    private JPanel contentPane = new JPanel();
                            
    private JMenuBar menuMB = new JMenuBar();
    private JMenu newM = new JMenu( "New" );
    private JMenuItem BankAccountMI, StockMI, CarMI, HouseMI;
    
    private JTextField [] AssetsTF; 
    private JTextArea AssetDetailTA;

    private JLabel AssetsL, AssetDetailL;
    
    private Vector<Asset> assetList = new Vector<Asset>();
    
    private WindowListener wombo;
    
    private Wealth wealthObj = new Wealth();
    
    public WealthManagerForm()
    {   
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 500);
   
        contentPane.setLayout(null);
        
        menuSetup();
        
        //Instantiate 
        AssetsL = new JLabel("Assets");
        AssetDetailL = new JLabel("Asset Detail");
        
        AssetsTF = new JTextField[12];
        AssetDetailTA = new JTextArea();
        
        for (int c = 0; c < AssetsTF.length; c++)
            AssetsTF[c] = new JTextField(30);
        
        // Set Location 
        AssetsL.setLocation(5,5);
        AssetDetailL.setLocation(150,5);
        AssetDetailTA.setLocation (150, 30);
        
        // setSize()
        AssetsL.setSize(50,20);
        AssetDetailL.setSize(100,20);
        AssetDetailTA.setSize(400, 250);
        
        //Add to content pane
        contentPane.add(AssetsL);
        contentPane.add(AssetDetailL);
        contentPane.add(AssetDetailTA);
        

        // Set Location, Size, and Add to contentpane for the array
        for (int c = 0, previousY = 30; c < AssetsTF.length; c++)
        {
            AssetsTF[c].setText("");
            AssetsTF[c].setLocation(5, previousY);
            AssetsTF[c].setSize(120, 30);
            AssetsTF[c].addMouseListener(this);
            
            contentPane.add(AssetsTF[c]);
            previousY += 30;
        }
        
        // Adding Mouse Listener 
        AssetDetailTA.addMouseListener(this);
        
        // Add to frame
        frame.setJMenuBar(menuMB);
        frame.add(contentPane);
        frame.addWindowListener(this);
        frame.addMouseListener(this);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
    
    public void windowActivated(WindowEvent e)
    {
       System.out.println("windowActivated");
    }
    public void windowClosed(WindowEvent e)
    {
       System.out.println("windowClosed"); 
    }
    public void windowClosing(WindowEvent e)
    {
       System.out.println("windowClosing"); 
    }
    public void windowDeactivated(WindowEvent e)
    {
       System.out.println("windowDeactivated"); 
    }
    public void windowIconified(WindowEvent e)
    {
       System.out.println("windowIconified"); 
    }
    public void windowDeiconified(WindowEvent e)
    {
       System.out.println("windowOpened"); 
    }
    public void windowOpened(WindowEvent e)
    {
       System.out.println("windowOpened"); 
       
       for (int c = 0; c < AssetsTF.length; c++)
       {
           AssetsTF[c].setText( wealthObj.getName( c ) );
       }
    }
    
    public void mouseClicked (MouseEvent e)
    {
        int index = 0;
        AssetDetailTA.setText( null );
        AssetDetailTA.setText( "" );
        
        for (int c = 0; c < AssetsTF.length; c++)
        {
            if (e.getSource() == AssetsTF[c])
                AssetDetailTA.setText(  AssetsTF[c].toString() );
        }
        
        System.out.println("mouseClicked");
    }
    
    public void mouseEntered (MouseEvent e)
    {
        System.out.println("mouseEntered");
    }
    public void mouseExited (MouseEvent e)
    {
        System.out.println("mouseExited");
    }
    public void mousePressed (MouseEvent e)
    {
        System.out.println("mousePressed");
    }
    public void mouseReleased (MouseEvent e)
    {
        System.out.println("mouseReleased");
    }
    
    public void menuSetup()
    {
        menuMB.add( newM );
        BankAccountMI = new JMenuItem( "Bank Account" );
        newM.add(  BankAccountMI );
        BankAccountMI.addActionListener(this);
        StockMI = new JMenuItem( "Stock" );
        newM.add( StockMI );
        StockMI.addActionListener(this);
        CarMI = new JMenuItem( "Car" );
        newM.add( CarMI );
        CarMI.addActionListener(this);
        HouseMI = new JMenuItem( "House" );
        newM.add( HouseMI );
        HouseMI.addActionListener(this);
    }
    
    @Override 
    public void actionPerformed ( ActionEvent e )
    {
        JMenuItem mItem = ( JMenuItem ) e.getSource();
        if ( mItem == BankAccountMI )
        {        
            BankAccount BankAccountObj = new BankAccount();
            wealthObj.addAsset( BankAccountObj );
            
            for (int c = 0; c < AssetsTF.length; c++)
            {
                if ( ( "".equals( AssetsTF[c].getText() ) ) )
                {
                    AssetsTF[c].setText( wealthObj.toString());
                }
            }
            
        }
        else if ( mItem == StockMI )
        {

        }
        else if ( mItem == CarMI )
        {

        }
        else if ( mItem == HouseMI )
        {

        }
    }
}
