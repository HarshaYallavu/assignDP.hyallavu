import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Facade{
    private int UserType, nProductCategory;
    private Product theSelectedProduct;
    private ClassProductList theProductList;
    private Person thePerson;
    static Person theperson;
    public static HashMap<String,ArrayList<String>> arr;
    Facade(int UserType){
        this.UserType=UserType;
    }
    Facade(){}
    // Facade Design Pattern is implemented in this Facade class. these methods act as interface to all the functionalities.
    public boolean login(){
        //Shows GUI and returns the login result.
        boolean loginStatus = false;
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Hi User, Please input the type of services you need:\n 1.Buyer \n 2.Seller \n ");
            UserType=sc.nextInt();
            UserType-=1;
            System.out.println("Enter Username");
            @SuppressWarnings("resource")
            Scanner scanner = new java.util.Scanner(System.in);
            String inputUsername = scanner.nextLine();
            System.out.println("Enter Password");
            String inputPassword = scanner.nextLine();
            UserInfoItem UII=new UserInfoItem();
            boolean status=false,sellerStatus=false;
            if(UserType==0)
                status = loginCheck("./resources/BuyerInfo.txt", inputUsername, inputPassword);
            else if(UserType==1)
                sellerStatus = loginCheck("./resources/SellerInfo.txt", inputUsername, inputPassword);

            if(status==true) {
                System.out.println("Logged in as Buyer!");
                thePerson = UII.userInfo.get(inputUsername);
                loginStatus = true;
            }
            else if(sellerStatus==true) {
                System.out.println("Logged in as Seller!");
                thePerson = UII.userInfo.get(inputUsername);
                loginStatus = true;
            }
            else {
                if(UserType==0)
                    throw new Exception("Invalid as your buyer account doesn't exist.");
                else
                    throw new Exception("Invalid as your seller account doesn't exist.");
            }
            theperson=thePerson;
        }catch(Exception e) {
            System.out.println(e.getMessage());
            login();
        }
        return loginStatus;
    }

    public boolean loginCheck(String inputFileType, String inputUsername, String inputPassword) {
        boolean loginStatus = false;
        try {
            boolean found = false;
            FileReader fileReader = new FileReader(inputFileType);
            @SuppressWarnings("resource")
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String creds = bufferedReader.readLine();
            String[] str=new String[2];
            while (true) {
                if (creds == null) break;
                str=creds.split(":");
                String username = str[0];
                if(username.equals(inputUsername)) {
                    found = true;
                    if(str[1].equals(inputPassword))
                    loginStatus = true;
                }

                creds = bufferedReader.readLine();
            }
            if (found) {
            } else {
                return found;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            login();
        }
        return loginStatus;
    }


    private BufferedReader getBufferedReader(BufferedReader bufferedReader) {
        return bufferedReader;
    }

    public void addTrading(){
        //When clicking the add button of the ProductMenu, call this function.
        // This function will add a new trade and fill in the required information.
        // This function will be called SellerTradingMenu or BuyerTradingMenu based on the type of the user.
        // It will not update the product menu. The product menu needs to be refreshed outside the function.
        Trading trade=new Trading();
        Product p=theSelectedProduct;
        OfferingMenu OM=new OfferingMenu();
        OfferingList OL= OM.getOfferingMenu();
        ArrayList<Offering> OfferList=OL.offeringlist;
        OfferingIterator OI=new OfferingIterator(OfferList);
        ClassProductList CPL=new ClassProductList();
            Offering offer=OI.getOffering(p);
        if(thePerson.personType.equals("Buyer"))
            trade.addTrade(offer);
        else
            CPL.accept(new ReminderVisitor());

    }
    public void viewTrading(){
        //When clicking the view button of the ProductMenu, call this function and pass the pointer of the Trading and the person pointer to this function.
        //This function will view the trading information.
        //This function will call SellerTradingMenu or BuyerTradingMenu according to the type of the user.
        Trading trade=new Trading();
        ArrayList<Offering> t=trade.viewTrade();
        for(int i=0;i<t.size();i++)
            System.out.println(thePerson.personType+": "+thePerson.personName+"=> productName:"+t.get(i).product.curr_productName+":"+t.get(i).message+"Seller:"+t.get(i).getuser().personName);
        if(t.size()==0 || t==null)
            System.out.println("No tradings to show.");
    }
    public void decideBidding(){
       //This function will view the given offering.
    }
    public void discussBidding(){
       //Set the deal flag of the given offering.
    }
    public void submitBidding(){
       //Used by the buyer to submit the offering.
    }
    public void remind(){
        //Show the remind box to remind buyer of the upcoming overdue trading window.
        System.out.println("Please close the available tradings because they will be refreshed by the end of the day.");
    }
    public void createUser(UserInfoItem userinfoitem){
        //Create a user object according to the userinfoitem, the object can be a buyer or a seller.
    }
    public void createProductList()throws IOException {
        //Create the product list of the entire system.
        if(theProductList.productList==null)
            theProductList.productList=new ArrayList<Product>();
        if(theProductList.productList.isEmpty()){
            String inputProductFile = "./resources/ProductInfo.txt";
            FileReader productInfoFile;
            String[] str=new String[2];
            try {
                productInfoFile = new FileReader(inputProductFile);
                BufferedReader readCourseInfo = new BufferedReader(productInfoFile);
                String product = readCourseInfo.readLine();
                Product p1;
                do {
                    if (product == null)
                        break;
                    str=product.split(":");
                     p1=new Product(str[1],str[0]);
                    theProductList.productList.add(p1);
                    product = readCourseInfo.readLine();
                } while (true);
            } catch (FileNotFoundException e) {
            }
        }
//        String productType;
//        if(nProductCategory==0)
//            productType="Meat";
//        else
//            productType="Produce";
//        ProductIterator PI=new ProductIterator(theProductList.productList);
//        do{
//            if(!PI.hasNext())
//                break;
//            Product p=PI.Next();
//            if(productType.equals(p.productType))
//                System.out.println(p.productType+":"+p.curr_productName);
//        }while(true);
//        for(int i=0;i<theProductList.productList.size();i++) {
//            if(productType.equals(theProductList.productList.get(i).productType))
//                System.out.println(theProductList.productList.get(i).productType + ":" + theProductList.productList.get(i).curr_productName);
//        }




    }
    public void AttachProductToUser(String[] userProduct)throws IOException{
        //Call this function after creating the user.
        // Create productList by reading the UserProduct.txt file.
        // Match the product name with theProductList.
        // Attach the matched product object to the new create user: Facade.thePerson. ProductList
        String UserProductFile = "./resources/UserProduct.txt";
        FileReader UserproductInfoFile;
        String[] str=new String[2];
        int i = 0;
        try {
            UserproductInfoFile = new FileReader(UserProductFile);
            BufferedReader readCourseInfo = new BufferedReader(UserproductInfoFile);
            String userproduct = readCourseInfo.readLine();

        }catch (FileNotFoundException e) {
        }

        }
    public Product SelectProduct(){
        //Show the Product list in a Dialog and return the selected product.
        Scanner sc=new Scanner(System.in);
        String productName=sc.next();
        if(theProductList.productList!=null){
            for(int i=0;i<theProductList.productList.size();i++)
                if(theProductList.productList.get(i).curr_productName.equals(productName))
                    theSelectedProduct=theProductList.productList.get(i);
        }
        else System.out.println("check the classproductlist variable");
        return theSelectedProduct;
    }
    public void productOperation(){
        //This function will call the thePerson.
        // CreateProductMenu0 According to the real object (buyer or seller) and the productLevel, it will call different menu creator and show the menu differently according to the usertype.
    }
    public void setProductCategory(int productCategory){
        this.nProductCategory=productCategory;
    }
    public Person getThePerson(){
        Person p=theperson;
        return p;
    }

}