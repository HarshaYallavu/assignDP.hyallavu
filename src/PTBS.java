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
         System.out.println("Hi User, Please input the type of services you need:\n 1.Buyer \n 2.Seller \n ");
         UserType=sc.nextInt();
         UserType-=1;
         Facade facade = new Facade(UserType);
         boolean loginStatus= facade.login();
         MeatProductMenu MPM=new MeatProductMenu();
         ProduceProductMenu PPM= new ProduceProductMenu();
         while(true){
             System.out.println("Choose option");
             System.out.println(" 1-ShowMenu\n 2-ShowTradings\n 3-AddTrading\n 4-Logout\n 5-Exit");

                 int option = sc.nextInt();
                 switch(option){
                     case 1:
                         System.out.println("Enter the Product Category\n 0:Meat\n 1:Produce");
                         facade.createProductList();
                         nProductCategory=sc.nextInt();
                         facade.setProductCategory(nProductCategory);
                         if(nProductCategory==0)
                             MPM.showMenu();
                         else if(nProductCategory==1)
                             PPM.showMenu();
                         break;
                     case 2:
                         break;
                     case 3:break;
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
