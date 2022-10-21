import java.util.ArrayList;

public class OfferingIterator implements ListIterator {
    OfferingList classofferinglist;
    public ArrayList<Offering> offeringsList;
    public static int index;
    OfferingIterator(ArrayList<Offering> offeringsList){
    this.offeringsList=offeringsList;
    index=0;
    }
    public boolean hasNext(){
        if(index<classofferinglist.offeringlist.size())
            return true;
        return false;
    }
    public Offering Next(){
        setofferingList(classofferinglist.offeringlist);

        return offeringsList.get(index++);
    }
    public void MoveToHead(){
    index=0;
    }
    public void Remove(){
        offeringsList.remove(index);
    }
    public Offering getOffering(Product P){
        int i;
        for( i=0;i<offeringsList.size();i++) {
            if (offeringsList.get(i).product.equals(P))
                return offeringsList.get(i);
        }
        return null;
    }
    public void setofferingList(ArrayList<Offering> offerList){
        this.offeringsList=offerList;
    }
}
