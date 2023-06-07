package view;

import controller.RestManagerController;
import db.OrderDB;
import java.util.Scanner;
import model.Order;
import java.util.ArrayList;
import model.OrderItem;

/**
 *
 * @author Ana PAllarés Rodríguez
 */
public class RestManagerView {
    
    Scanner scan = new Scanner(System.in);
    
    private RestManagerController controller;

    /**
     * constructoe de la clase
     * @param controller refererncia al controlador (bigBoss)
     */
    public RestManagerView(RestManagerController controller) {
        this.controller = controller;
    }
    
    /**
     * muestra el menu principal de la app
     * @return devuelve true si el usuario quiere salir, false si quiere continuar
     */
    public boolean showInitMenu(){
        System.out.println("");
        System.out.println("WELCOME TO RESTAURANT MANAGER");
        System.out.println("1. Add elements to an existing order");
        System.out.println("2. Show order");
        System.out.println("3. Charge order");
        System.out.println("4. Exit");
        
        int awns = scan.nextInt();
        scan.nextLine();
        
        switch (awns) {
            case 1:
                System.out.println("Enter the table´s number");
                int table = scan.nextInt();
                scan.nextLine();
                controller.completeOrder(table);
                return false;
            case 2:
                System.out.println("Enter the table´s number");
                int table1 = scan.nextInt();
                scan.nextLine();
                controller.showOrder(table1);
                return false;
            case 3:
                // no hace nada
                return false;
            case 4:
                return true;
            default:
                throw new AssertionError();
        }
    }
    
    /**
     * pregunta el numero del plato que el usuario quiere pedir, o 0 si se quiere parar de pedir
     * @return el numero del plato que se quiere pedir
     */
    public int askOrderItem(){
        System.out.println("Enter the number of the plate you wish to order (0 if you don't want to order more)");
        int item = scan.nextInt();
        scan.nextLine();
        
        return item;
    }
    
    /**
     * muestra un mensaje de error
     */
    public void showItemNotFoundMessage(){
        System.out.println("There is no element in our menu with that number");
    }
    
    /**
     * muestra todos los elementos de un pedido asi como su precio total
     * @param order el pedido del que se quieren mostrar los elemtos
     */
    public void showOrderItems(Order order){
        
        if (OrderDB.findByTable(order.getTableNumber()) != null) {
            ArrayList<OrderItem> items = order.getElementsInOrder();
            
            double totalPrice = 0;
            for (OrderItem item : items) {
                System.out.println(item.getAmount() + " - " + item.getMenuItem().getDescription());
                totalPrice += item.getPrice();
            }
            
            System.out.println("");
            System.out.println("Total: " + totalPrice);
        }else{
            System.out.println("There is no order for the indicated table");
        }
        
        
    }
}
