
package inventoryapp;

import java.time.LocalDate ;

public class Item implements Expirable{
    public String name ;
    public LocalDate purchaseDate ;
    public LocalDate expiryDate ;
    public String type ;

    public Item(String name, LocalDate purchaseDate, LocalDate expiryDate, String type) {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.type = type;
    }
    
    @Override
    public boolean isExpireSoon(){
        if (expiryDate == null)
            return false ;
        LocalDate now = LocalDate.now() ;
        return 
        !expiryDate.isBefore(now)&& !expiryDate.isAfter(now.plusDays(7)) ;
        
    }
    
    @Override 
    public String toString(){
        String r =  "Name : " + name+" | Purchased : " +purchaseDate ;
        if (expiryDate != null) {
            r+=" | Expiry : "+expiryDate ; 
        }
        else {
            r+= " | Expiry : Not Available !! " ;
        }
         r+= " | Type : " +type ; 
         return r ;
    }
 
}
