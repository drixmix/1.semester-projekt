package ModelLayer;
import java.util.LinkedList;
import java.util.Date;
import java.util.Iterator;

public class Order{
    // instance variables
    private int orderId;
    private static int counter = 1000;
    private String date;
    private double totalPrice;
    private boolean delivery = false;
    private boolean paid = false;
    private String deliveryAddress;
    private LinkedList<OrderLine> orderLine;
    private boolean betalt;
    private Date dato;
    private String datop;
    private String[] orderLineList;

    //initialise contructor for class Order
    public Order(boolean delivery, String address){
        // initialise instance variables
        orderId = counter++;
        this.delivery = delivery;
        deliveryAddress = address;
        orderLine = new LinkedList<>();
        betalt=false;
        dato = new Date();
        datop=setDate();
        orderLineList = new String[10];
    }
    //add orderLine to order
    public void addOrderUniqueLine(Item item){
        OrderLine oL = new UniqueLine(item);
        orderLine.add(oL);
        totalPrice =+ oL.getPrice();
    }

    public void addOrderSimpleLine(Product product, int amount){
        OrderLine oL = new SimpleLine(amount, product);
        orderLine.add(oL);
        totalPrice =+ oL.getPrice();
    }
    //set methods
    public void setDate(String newDate){
        date = newDate;
    }

    public void setTotalPrice(double newTotalPrice){
        totalPrice = newTotalPrice;
    }

    public void setDelivery(boolean newDelivery){
        delivery = newDelivery;
    }

    //get methods
    public String getDate(){
        return datop;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public boolean getDelivery(){
        return delivery;
    }

    public int getId(){
        return orderId;
    }

    public boolean getbetalt(){

        return betalt;
    }

    public boolean setbetalt(){
        betalt = true;
        return betalt;

    }

    public String setDate(){
        String date1;
        date1= dato.getDate()+("-")+(dato.getMonth()+1)+("-")+(dato.getYear()+1900);
        return date1;

    }

    public LinkedList getOrderLines(){
        return orderLine; 
    }

    public String[] getorderlines(){
        Iterator<OrderLine> it = orderLine.iterator();
        OrderLine tmp;
        int i = 0;
        while(it.hasNext()){
            tmp = it.next();
            orderLineList[i]=tmp.getName()+"     "+"antal:"+tmp.getAmount()+"           "+"enheds pris: "+tmp.getPrice()+"      "+"Totalpris: "+(tmp.getAmount()*tmp.getPrice());
            i ++;

        }
        return orderLineList;

    }
}

