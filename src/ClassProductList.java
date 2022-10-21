import java.util.ArrayList;

public class ClassProductList {
    public static ArrayList<Product> productList;
    public void accept(NodeVisitor visitor){
        System.out.println("The trading offer is accepted");
    }
}
