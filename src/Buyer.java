import java.util.ArrayList;

public class Buyer extends Person {
    Facade facade;
    Person cur_user;
    public Buyer(String username, Facade facade){

        personName=username;
        personType="Buyer";
        this.facade=facade;
    }
    public Buyer(String username){
        personName=username;
        personType="Buyer";
    }
   public void showMenu(){
    //According to the need of buyer show the appropriate items on the menu.
      // Facade facade=new Facade();
       UserInfoItem UII=new UserInfoItem();
       OfferingMenu OM=new OfferingMenu();
       OfferingList OL= OM.getOfferingMenu();
       ArrayList<Offering> OfferList=OL.offeringlist;
       OfferingIterator OI=new OfferingIterator(OfferList);
        if(facade==null)
            facade=new Facade();
       ArrayList<Product> p= facade.getThePerson().userproductList;
       if(p.size()>0 && OfferList.size()>0) {
           for (int i = 0; i < p.size(); i++) {
               Offering offer=OI.getOffering(p.get(i));
               if(offer!=null)
                System.out.println(i + 1 + "." + offer.product.curr_productName + "->" + offer.product.productType+" | Seller:"+offer.getuser().personName);
               else
                   System.out.println("No seller for the interested products");
           }
       }
   }
   public ProductMenu CreateProductMenu(){
    return null;
   }

}
