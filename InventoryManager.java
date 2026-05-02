 
package inventoryapp;

import java.util.* ;
import java.time.LocalDate ;
import java.time.format.DateTimeFormatter ;

public class InventoryManager {
    
    private List<Item> invrntory = new ArrayList<>() ;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") ;
    private  Scanner in = new Scanner(System.in) ;
    
    public void addItem(){
        System.out.println("Enter Name: ");
        String name = in.nextLine();
        
        System.out.println("Enter Purchased date (yyyy-MM-dd) : ");
        LocalDate Purchased = LocalDate.parse(in.nextLine(), formatter);
       
        System.out.println("Enter expiry date (yyyy-MM-dd) or leave a blank:  ");
        String ein = in.nextLine() ;
        LocalDate expiry = ein.isEmpty() ? null:LocalDate.parse(ein,formatter) ;
        
        System.out.println("Enter Type: ");
        String type = in.nextLine();
        
        invrntory.add(new Item(name, Purchased, expiry, type)) ;
        System.out.println("Item added successfully . ");
        
    } 
    
    public void deleteItem (){
        System.out.println("Enter name to delete: ") ;
        String name = in.nextLine();
        invrntory.removeIf(item->item.name.equalsIgnoreCase(name)) ;
        System.out.println(" deleted if found .");
    }
    
    public void updateItem(){
         System.out.println("Enter name to update : ") ;
         String name = in.nextLine();
         
         for (Item i : invrntory){
             if (i.name.equalsIgnoreCase(name)){
                  System.out.println("Enter new Purchased date (yyyy-MM-dd) : ");
                  i.purchaseDate = LocalDate.parse(in.nextLine(), formatter);
                  
                  System.out.println("Enter new expiry date (yyyy-MM-dd) or leave a blank:  ");
                  String ein = in.nextLine() ;
                  i.expiryDate = ein.isEmpty() ? null:LocalDate.parse(ein,formatter) ;
                  
                  System.out.println("Enter new Type: ");
                  i.type = in.nextLine();
                  System.out.println("Item Updated . ");
                  return;
             }
         }
         System.out.println("Item not found !!");
    }
    
    public void searchItem(){
        System.out.println("Enter name to search: ");
        String name = in.nextLine();
        for (Item i : invrntory){
           if (i.name.equalsIgnoreCase(name)){
               System.out.println(i);
               return;
           }  
        }
        System.out.println("Item not found !!");
    }
    
    public void listExpiringSoon(){
         System.out.println("Items Expiring Within 7 Days :") ;
         boolean f= false ;
         
          for (Item i : invrntory){
              if(i.isExpireSoon()){
                System.out.println(i);  
                f=true ;
              }
          }
          if(!f){
              System.out.println("No items expiring soon .");
          }
    }
    
     public void listAllItems(){
         if(invrntory.isEmpty()){
             System.out.println(" no item in invrntory .");
             return;
         }
         for (Item i : invrntory){
             System.out.println(i);
         }
     
     }
}
