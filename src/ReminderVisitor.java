public class ReminderVisitor extends NodeVisitor {
    private Reminder m_Reminder;
    public  void visitProduct(Product product){
        System.out.println("visited the product");
        visitTrading(new Trading());
    }
    public  void visitTrading(Trading trading){
     System.out.println("will check the trading timeframe and show the message");
    }
    public  void visitFacade(Facade facade){
        System.out.println("will visit each product in the productList");
        facade.remind();
        visitProduct(new Product());
    }
}
