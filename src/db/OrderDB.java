package db;

import java.util.HashMap;
import model.MenuItem;
import model.Order;
import model.OrderItem;

/**
 * implementa la persistencia de los elementos de la carta y de los pedidos
 * @author Ana Pallarés Rodríguez
 */
public class OrderDB {
    
    /**
     * la carta
     */
    private static final MenuItem[] menu = new MenuItem[]{
        new MenuItem(1, "Carbonara", 12.50),
        new MenuItem(2, "Medium chees pizza", 11.90),
        new MenuItem(3, "CocaCola 33 cl", 2.5),
        new MenuItem(4, "Water 1l", 3)
    };
    
    /**
     * los pedidos
     */
    private static HashMap<Integer, Order> orders = new HashMap<>();
    
    /**
     * comprueba si hay algun elemento en la carta con ese id
     * @param id el id del elemento que se quiere encontrar
     * @return el elemento del menu que coincida con el id. Si no hay, null
     */
    public static MenuItem findById(int id){
        
        for (MenuItem menuItem : menu) {
            if (menuItem.getId() == id) {
                return menuItem;
            }
        }
        
        return null;
    }
    
    /**
     * busca el pedido de una mesa
     * @param tableNum el número de mesa de la que se quiere encontrar el pedido
     * @return el pedido de la mesa si existe. Si no,  null
     */
    public static Order findByTable(int tableNum){
        
        if (orders.containsKey(tableNum)) {
            return orders.get(tableNum);
        }
        return null;
    }
    
    /**
     * guarda un pedido en el Hashmap de pedidos
     * @param order el pedido que se quiere añadir
     */
    public static void save(Order order){
        
        orders.put(order.getTableNumber(), order);
        
    }
    
    /**
     * guarda un nuevo item en un pedido
     * @param order pedido al que se le va a añadir el item
     * @param item lo que se va a añadir
     */
    public static void saveItem(Order order, OrderItem item){
        //de momento no hace nada
    }
    
    /**
     * actualiza un item en un pedido
     * @param order pedido en el que se va a hacer la actualización
     * @param item item que se va a actualizar
     */
    public static void updateItem(Order order, OrderItem item){
        //de momento no hace nada
    }
}
