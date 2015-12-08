/******************************************
* Programmer : Anthony D'Ambrosio
* Date       : 11/10/2015
* Purpose    : Net Worth
* Notes      :
******************************************/
package InheritanceDesign;

public class Car extends Property
{  
    public String assetName;
    
    
    public Car ( String name, double propertyValue, double propertyDebt )
    {
        super( name, propertyValue, propertyDebt );
    }
    
    @Override
    public double getAssetValue()
    {
        return ( getValueAmount() );
    }
    
    @Override
    public double getDebtValue()
    {
        return ( getDebtAmount() );
    }
    
    @Override 
    public String toString()
    {
        return this.getClass().getSimpleName() + ", " + name + 
                ", Property Value: " + getValueAmount() + ", Property Debt: " +
                getDebtAmount() + ", Net Value: " + (
                getValueAmount() - getDebtAmount() );
    }
    
    @Override 
    public String getAssetName()
    {
        return assetName;
    }
    
    
}
