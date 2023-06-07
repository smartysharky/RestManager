package model;
import java.util.ArrayList;

/**
 * implementa un pedido
 * @author Ana Pallarés Rodríguez
 */
public class Order {
    
    private int tableNumber;
    private ArrayList<OrderItem> elementsInOrder;

    /**
     * 
     * @return número de la mesa que hace el pedido 
     */
    public int getTableNumber() {
        return tableNumber;
    }
    
    /**
     * 
     * @return todos los elementos en el pedido
     */
    public ArrayList<OrderItem> getElementsInOrder() {
        return elementsInOrder;
    }

    /**
     * constructor de la clase
     * @param tableNumber número de la mesa que hace el pedido
     */
    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        elementsInOrder = new ArrayList<>();
    }
    
    public double getPrice(){
        
        double totalPrice = 0;
        
        for (OrderItem orderItem : elementsInOrder) {
            double itemPrice =orderItem.getPrice() * orderItem.getAmount();
            totalPrice = totalPrice + itemPrice;
        }
        
       return totalPrice;
    }
    
}
