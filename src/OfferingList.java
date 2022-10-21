import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OfferingList {
    public static ArrayList<Offering> offeringlist= new ArrayList<>();
    public OfferingList(){

    }
    public void createOfferingList() throws IOException {
        int n= UserInfoItem.userInfo.size();
        String UserProductFile = "./resources/UserProduct.txt";
        FileReader UserproductInfoFile;
        UserproductInfoFile = new FileReader(UserProductFile);
        BufferedReader readproductInfo = new BufferedReader(UserproductInfoFile);
        String userproduct = readproductInfo.readLine();
        String[] str=new String[2];
        Person p;
        Offering offer=null;
        do{
            if (userproduct == null)
                break;

            str=userproduct.split(":");
            if(UserInfoItem.userInfo.containsKey(str[0])) {
                p=null;
                p=UserInfoItem.userInfo.get(str[0]);
                //System.out.println(p.personName+"::"+p.personType);
                if(p.personType.equals("Seller")) {
                    offer=new Offering();
                    //System.out.println(p.personName);
                    ClassProductList theproductlist = new ClassProductList();
                    ProductIterator PI = new ProductIterator(theproductlist.productList);
                    Product p1 = PI.getproductType(str[1]);
                    offer.setproduct(p1);
                    offer.setuser(p);
                }
            }
            if(offer!=null)
            offeringlist.add(offer);
            userproduct = readproductInfo.readLine();
        }while(true);
//      System.out.println(offeringlist.size()+"offer list size");

//        for (Map.Entry<String,Person> mapElement : UserInfoItem.userInfo.entrySet()) {
//            Person p1=mapElement.getValue();
//            if(p1.personType.equals("Seller")) {
//
//
//            }
//
//            }
    }
}
