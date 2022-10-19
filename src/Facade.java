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
    public static HashMap<String,ArrayList<String>> arr;
    Facade(int UserType){
        this.UserType=UserType;
    }
    public boolean login(){
        //Shows GUI and returns the login result.
        boolean loginStatus = false;
        try {

            System.out.println("Enter Username");
            @SuppressWarnings("resource")
            Scanner scanner = new java.util.Scanner(System.in);
            String inputUsername = scanner.nextLine();
            System.out.println("Enter Password");
            String inputPassword = scanner.nextLine();
            boolean status,sellerStatus;
            if(UserType==0) {
                status = loginCheck("./resources/BuyerInfo.txt", inputUsername, inputPassword);
                System.out.println("Logged in as Buyer!");
                thePerson=new Buyer(inputUsername);
                loginStatus =true;
            }
            else if(UserType==1){
             sellerStatus = loginCheck("./resources/SellerInfo.txt", inputUsername, inputPassword);
             System.out.println("Logged in as Seller!");
                thePerson=new Seller(inputUsername);
                loginStatus =true;
            }
            else
                throw new Exception("Invalid!");

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
            while (true) {
                if (creds == null) break;
                String username = getString(creds);
                if (!isEqualsIgnoreCase(inputUsername, username)) {
                } else {
                    found = true;
                    boolean checkPassword = isPassword(inputPassword, creds);
                    loginStatus = isLoginStatus(loginStatus, checkPassword);
                }
                creds = getBufferedReader(bufferedReader).readLine();
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
    private boolean isLoginStatus(boolean loginStatus, boolean checkPassword) {
        if (!checkPassword) {
            System.out.println("Invalid Username/Password");
            login();
        } else {
            System.out.println("Login success");
            loginStatus = true;
        }
        return loginStatus;
    }

    private boolean isPassword(String inputPassword, String creds) {
        String password = getPassword(creds);
        boolean checkPassword = isCheckPassword(inputPassword, password);
        return checkPassword;
    }

    private boolean isEqualsIgnoreCase(String inputUsername, String username) {
        return username.equalsIgnoreCase(inputUsername);
    }

    private BufferedReader getBufferedReader(BufferedReader bufferedReader) {
        return bufferedReader;
    }

    private boolean isCheckPassword(String inputPassword, String password) {
        boolean checkPassword = inputPassword.equals(password);
        return checkPassword;
    }

    private String getPassword(String creds) {
        String password = creds.substring(creds.lastIndexOf(":") + 1);
        return password;
    }

    private String getString(String creds) {
        String username = creds.substring(0, creds.indexOf(":"));
        return username;
    }
    public void addTrading(){
        //When clicking the add button of the ProductMenu, call this function.
        // This function will add a new trade and fill in the required information.
        // This function will be called SellerTradingMenu or BuyerTradingMenu based on the type of the user.
        // It will not update the product menu. The product menu needs to be refreshed outside the function.
    }
    public void viewTrading(){
        //When clicking the view button of the ProductMenu, call this function and pass the pointer of the Trading and the person pointer to this function.
        //This function will view the trading information.
        //This function will call SellerTradingMenu or BuyerTradingMenu according to the type of the user.
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
            int i = 0;
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
                    i++;
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
    public void AttachProductToUser(){
        //Call this function after creating the user.
        // Create productList by reading the UserProduct.txt file.
        // Match the product name with theProductList.
        // Attach the matched product object to the new create user: Facade.thePerson. ProductList
    }
    public Product SelectProduct(){
        //Show the Product list in a Dialog and return the selected product.
        return null;
    }
    public void productOperation(){
        //This function will call the thePerson.
        // CreateProductMenu0 According to the real object (buyer or seller) and the productLevel, it will call different menu creator and show the menu differently according to the usertype.
    }
    public void setProductCategory(int productCategory){
        this.nProductCategory=productCategory;
    }

}