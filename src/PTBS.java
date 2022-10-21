import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class PTBS{
    public static void main(String[] args) throws IOException {


         int UserType, nProductCategory;
         Product theSelectedProduct;
         ClassProductList theProductList;
         Person thePerson;
        Scanner sc=new Scanner(System.in);
        // Using the Facade class methods. And Facade Design pattern is implemented.
         Facade facade = new Facade();
         //Implemented the Iterator Design Pattern. and calling the classProductList methods from facade.
         facade.createProductList();
         UserInfoItem UII=new UserInfoItem();
         UII.createUsers();
         boolean loginStatus= facade.login();
         Person user=facade.getThePerson();
         OfferingList OL=new OfferingList();
         OL.createOfferingList();
         ProductMenu PM=null;
         while(true){
             System.out.println("Choose option");
             System.out.println(" 1-ShowAllProductMenu\n 2-PersonalCart\n 3-Reminder\n 4-Logout\n 5-Exit");

                 int option = sc.nextInt();
                 switch(option){
                     case 1:
                         //Factory Design Pattern is implemented. By considering the Product category,
                         // we are deciding which subclass to be instantiated i.e. MeaProductMenu,ProduceProductMenu.
                         System.out.println("Enter the Product Category to choose the ProductMenu Type\n 0:Meat\n 1:Produce");
                        // facade.createProductList();
                         nProductCategory=sc.nextInt();
                         facade.setProductCategory(nProductCategory);
                         if(nProductCategory==0) {
                             PM=new MeatProductMenu(facade);
                             //Iterator Design pattern is implemented in the Meat and Produce's show method.
                             PM.showMenu();
                         }
                         else if(nProductCategory==1) {
                             PM=new ProduceProductMenu(facade);
                             //Iterator Design pattern is implemented in the Meat and Produce's show method.
                             PM.showMenu();
                         }
                         break;
                     case 2:System.out.println("Menu shows the products which user interests to trade");
                        //Bridge Design Pattern Implemented. At login stage the type of user is filtered
                         // and here we are filtering the product category.
                         user.showMenu();
                         System.out.println("Options in Menu:\n 1:AddTrading\n 2:ViewTrading");
                         int menuop=sc.nextInt();
                         if(menuop==1) {
                             System.out.println("Select a product to add a trade for it");
                             facade.SelectProduct();
                             System.out.println("Enter the Product Category for selected product\n 0:Meat\n 1:Produce");
                             nProductCategory=sc.nextInt();
                             System.out.println(" ");

                             if(nProductCategory==0)
                                 PM=new MeatProductMenu(facade);
                             else if(nProductCategory==1)
                                 PM=new ProduceProductMenu(facade);
                             PM.showAddButton();
                         }
                         else if(menuop==2) {
                             PM.showViewButton();
                         }
                         break;
                    // case 3:break;
                     case 3:
                         //Visitor Design pattern is implemented. it calls the remind method from the facade class.
                         ReminderVisitor rv=new ReminderVisitor();
                         rv.visitFacade(facade);
                         break;
                     case 4:
                         System.out.println("Logged out!");
                         facade.login();
                         break;
                     case 5:
                         System.exit(0);
                     default:
                         System.out.println("Invalid option!");
                 }

         }


    }
}
