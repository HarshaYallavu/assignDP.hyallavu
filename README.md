# assignDP.hyallavu
All 5 design patterns are implemented i.e. Facade, Bridge, Factory, Iterator and Vistor Design Patterns.

Facade Design Pattern- It is used to as an interface for the systems features i.e. this class methods can be used to implement the system features.
   Facade is used at:
   1. It is used in main method, to call the login method of facade class. The login method is implemented in facade class.
   2. It is used to implement the createproductlist method of facade class. the method creates a global list which stores all the products.
   3.It is used to implement the addtrading and viewtrading methods, which can be used to create a trade for a product per user.
   4. All the other methods in Facade class are defined for the implementation of other features.
   
  Bridge Design Patter is implemented at:
  1. PersonalCart, which shows the menu products based on the user type i.e. for buyer it shows- the all the sellers who sells his intreseted products.
      for seller it shows- all the products he is going to sell.
      Bridge pattern is used here to load the menu based on UserType and ProductCategory.
      
  Factory Design Patter is implemented at:
  
  1.AllProductmenu, which loads the menu based on the productCategory i.e. on the productcategory we are going to instantiate either
     MeatProductMenu or ProduceProdcutMenu.
     
  Iterator Design Pattern is implemented at:
  1.It is used at call the createproductlist method of facade class. which inturn, implements the classProductList class which stores all the products of
    the system. It uses the Iterator interface to move in the list.
  2. It is used at MeatProductMenu and ProduceProductMenu's showMenu method. to traverse the classProductList.
  
  Visitor Design Pattern is implemented at:
  1. It is used for remind feature. It calls the reminderVisitor class to traverse the products and trading in the facade .
  
  Flow of the PTBS:
  1. Prompts the user to choose a service between buyer and seller.
  2. Ask to input the username and password for login.
  3. If not logged in successfully, it re-prompts to choose the service between buyer and seller for login.
  4. If logged in successfully, it shows 5 options i.e. AllProductMenu, PersonalCart, Remind, Logout,Exit.
      4.1 AllProductMenu- shows all the products in the system based on Product Category.
      4.2 Personal Cart- Shows the user intrested products and any sellers for it.
          4.2.1 Has options AddTrading and view Trading
      4.3 Remind- it shows the trading messages for the users
      4.4 LogOut- user logs out of the system.
      4.5 Exit- user exits the system.
  
  
