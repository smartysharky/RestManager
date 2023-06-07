package model;

/**
 * implementa un elemento de un pedido
 * @author Ana Pallarés Rodríguez
 */
public class OrderItem {
    
    private MenuItem menuItem;
    private int amount;

    /**
     * 
     * @return el plato que de ha pedido 
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }
    
    /**
     * 
     * @return la cantidad de platos
     */
    public int getAmount() {
        return amount;
    }
    
    /**
     * 
     * @param amount la nueva cantidad
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    /**
     * construcotr de la clase
     * @param menuItem el plato que se ha pedido
     * @param amount cantidad de platos
     */
    public OrderItem(MenuItem menuItem, int amount) {
        this.menuItem = menuItem;
        this.amount = amount;
    }
    
    /**
     * calcula el dinero que hay que pagar por este elemento del pedido
     * @return cantidad de dinero que hay que pagar
     */
    public double getPrice(){
        
        double prize = menuItem.getPrize();
        
        return prize*amount;
    }
    
}
