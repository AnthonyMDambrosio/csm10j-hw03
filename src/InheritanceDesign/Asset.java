/******************************************
* Programmer : Anthony D'Ambrosio
* Date       : 11/10/2015
* Purpose    : Net Worth
* Notes      :
******************************************/
package InheritanceDesign;

abstract public class Asset
{
    protected String name;
    
    public Asset ( String name )
    {   
        this.name = name;
    }
    
    public Asset()
    {
        
    }
    
    @Override 
    public String toString()
    {
        return name;
    }
    
    abstract public String getAssetName();
    
    abstract public double getAssetValue();
    
    abstract public double getDebtValue();
    
}
