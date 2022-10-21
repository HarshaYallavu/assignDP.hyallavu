import java.util.ArrayList;

public class ProductIterator implements ListIterator {
    ClassProductList classproductlist;
    public ArrayList<Product> productList;
    public static int curr_index=0;
    public ProductIterator(ArrayList<Product> productList){
        this.productList=productList;
        curr_index=0;
    }
    public boolean hasNext(){
        if(curr_index<classproductlist.productList.size())
            return true;
        return false;
    }
    public Product Next(){
        setproductList(classproductlist.productList);

        return productList.get(curr_index++);
    }
    public void MoveToHead(){
        curr_index=0;
    }
    public void Remove(){
       productList.remove(curr_index);
    }

    public Product getproductType(String productName){
        int i;
        for( i=0;i<productList.size();i++){
            if(productList.get(i).curr_productName.equals(productName))
                break;
        }
        return productList.get(i);
    }
    public void setproductList(ArrayList<Product> productList){
        this.productList=productList;
    }
}
