
public class Product {
    String curr_productName, productType;
    public Product(String productName, String productType){
        curr_productName=productName;
        this.productType=productType;
    }
    public void setProductName(String productName){
        this.curr_productName=productName;
    }
    public String getProductName(){
        return curr_productName;
    }
}
