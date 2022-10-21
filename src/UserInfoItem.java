import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class UserInfoItem {

    public static HashMap<String,Person> userInfo;
    UserInfoItem(HashMap<String,Person> userInfo){
        this. userInfo=userInfo;
    }
    UserInfoItem(){}
   public void createUsers()throws IOException {
        String sellerInfoFile="./resources/SellerInfo.txt";
        String buyerInfoFile="./resources/BuyerInfo.txt";
        String UserProductFile = "./resources/UserProduct.txt";
        String productInfoFile="./resources/ProductInfo.txt";
        FileReader UserproductInfoFile, ProductInfoFile,BuyerInfoFile,SellerInfoFile;
        String[] str=new String[2];
       try {
           SellerInfoFile=new FileReader(sellerInfoFile);
           BufferedReader readsellerInfo = new BufferedReader(SellerInfoFile);
           String sellerinfo= readsellerInfo.readLine();
           Person p;
           String[] str1=new String[2];
           if(userInfo==null)
               userInfo=new HashMap<>();
           do{
               if(sellerinfo==null)
                   break;
               str1 =sellerinfo.split(":");
               p=new Seller(str1[0]);
               if(userInfo.containsKey(str1[0])){}
               else{
                 //  System.out.println(p.personName);
                   userInfo.put(str1[0],p);
               }
            //   System.out.println(str1[0]+":"+userInfo.get(str1[0]).personType);
               sellerinfo= readsellerInfo.readLine();
           }while(true);

           BuyerInfoFile=new FileReader(buyerInfoFile);
           BufferedReader readbuyerInfo = new BufferedReader(BuyerInfoFile);
           String buyerinfo= readbuyerInfo.readLine();
           str1=new String[2];
//           if(userInfo==null)
//               userInfo=new HashMap<>();
           do{
               if(buyerinfo==null)
                   break;
               str1 =buyerinfo.split(":");
               p=new Buyer(str1[0]);
               if(userInfo.containsKey(str1[0])){}
               else{
                   userInfo.put(str1[0],p);
               }
           //    System.out.println(str1[0]+":"+userInfo.get(str1[0]).personType);
               buyerinfo= readbuyerInfo.readLine();
           }while(true);

           UserproductInfoFile = new FileReader(UserProductFile);
           BufferedReader readproductInfo = new BufferedReader(UserproductInfoFile);
           String userproduct = readproductInfo.readLine();
//           if(userInfo==null)
//               userInfo=new HashMap<>();
           do{
               if (userproduct == null)
                   break;
               str=userproduct.split(":");
               if(userInfo.containsKey(str[0])) {
                   p=null;
                   p=userInfo.get(str[0]);
                   ClassProductList theproductlist=new ClassProductList();
                   ProductIterator PI=new ProductIterator(theproductlist.productList);
                   Product p1=PI.getproductType(str[1]);
                   p.userproductList.add(p1);
                   userInfo.put(str[0],p);
               }
               else {
                   Facade facade= new Facade();
                   facade.AttachProductToUser(str);
               }
               userproduct = readproductInfo.readLine();
           }while(true);

       }catch (FileNotFoundException e) {
       }

   }
   public void showAllUsers(){
       for (Map.Entry<String,Person> mapElement : userInfo.entrySet()) {
           Person p1=mapElement.getValue();
           if(p1.userproductList.size()>0) {
               for(int i=0;i<p1.userproductList.size();i++)
               System.out.println(mapElement.getKey() + ":" + mapElement.getValue().userproductList.get(i).productType);
           }
       }
       System.out.println("usersSize:"+userInfo.size());
   }
}
