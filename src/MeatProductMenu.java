public class MeatProductMenu implements ProductMenu{
    Facade facade;
    MeatProductMenu(){}
    MeatProductMenu(Facade facade){
        this.facade=facade;
    }
    //Implementation of Iterator Design Pattern.
    public void showMenu(){
        String str="Meat";
        ClassProductList theproductlist=new ClassProductList();
        ProductIterator PI=new ProductIterator(theproductlist.productList);
        do{
            if(!PI.hasNext())
                break;
            Product p=PI.Next();
            if(str.equals(p.productType))
                System.out.println(p.productType+":"+p.curr_productName);
        }while(true);
    }
    public void showAddButton(){
    //To show the add buttons.
        facade.addTrading();
    }
    public void showViewButton(){
    //To show the view buttons.
        facade.viewTrading();
    }
    public void showRadioButton(){
    //To show the radio buttons.
    }
    public void showLabels(){
    //To show the labels.
    }
    public void showComboxes(){

    }
}
