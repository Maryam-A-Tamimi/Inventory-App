 
package inventoryapp;

 import java.util.Scanner ;
   
public class InventoryApp {
 
    public static void main(String[] args) {
          
        InventoryManager manager = new InventoryManager() ;
        Scanner in = new Scanner(System.in) ;
        boolean run =true ;
        
        do {  
             System.out.println(" <<HOME INVENTORY MENU >>");
             System.out.println(" 1.Add Item") ;
             System.out.println(" 2.Delete Item") ;
             System.out.println(" 3.Update Item") ;
             System.out.println(" 4.Search Item") ;
             System.out.println(" 5.List Items Expiring in 7 Days") ;
             System.out.println(" 6.List All Items") ;
             System.out.println(" 7.Exit") ;
             System.out.print(" chooce number: ") ;
             int c = in.nextInt();
             in.nextLine() ;
             
             switch (c) {
                case 1: 
                    manager.addItem();
                    break;
                case 2: 
                    manager.deleteItem();
                    break;
                case 3: 
                    manager.updateItem();
                    break;
                case 4: 
                    manager.searchItem();
                    break;  
                case 5: 
                    manager.listExpiringSoon();
                    break;
                case 6: 
                    manager.listAllItems();
                    break;
                case 7: 
                    run = false;
                    break;    
                   
                    
                default:
                    System.out.println(" invalid choise !");
                    break;
            }
        }while(run) ;
    }
     
}
