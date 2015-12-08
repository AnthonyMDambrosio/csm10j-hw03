/******************************************
* Programmer : Anthony D'Ambrosio
* Date       : 11/10/2015
* Purpose    : Net Worth
* Notes      :
******************************************/
package InheritanceDesign;


public class Stock extends Security
{
    public String assetName;
    
    public Stock ( String name, double price, int quantity )
    {
        super( name, price, quantity);
    }
    
    @Override
    public double getAssetValue()
    {
        return price * quantity;
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
        return this.getClass().getSimpleName()+ ", " + name + ", Shares Owned: " 
                + quantity + ", Price: " + price 
                + ", Value: " + getAssetValue(); 
    }
    
    @Override
    public String getAssetName()
    {
        return assetName;
    }
}
