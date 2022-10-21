import java.util.ArrayList;

public class Offering {
    public Product product;
    public Person user;
    public String message="Price is 20$";
    public int price=20;
    Offering(){}
    Offering(Product product, Person user, String message, int price){
        this.product=product;
        this.user=user;
        this.message=message;
        this.price=price;

    }
    public void setproduct(Product product){
        this.product=product;
    }
    public Product getproduct(){
        return this.product;
    }
    public void setuser(Person user){
        this.user=user;
    }
    public Person getuser(){
        return this.user;
    }
    public void setmessage(){
        this.message=message;
    }
    public String getmessage(){
        return this.message;
    }
    public void setprice(int price){
        this.price=price;
    }
    public int getPrice(){
        return this.price;
    }
}
