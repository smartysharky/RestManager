package controller;

import db.OrderDB;
import model.Order;
import view.RestManagerView;
import java.util.ArrayList;
import model.OrderItem;

/**
 *
 * @author Ana Pallarés Rodríguez
 */
public class RestManagerController {

    private RestManagerView view = new RestManagerView(this);

    /**
     * llama al menu inicial hasta que este devuelva true, lo que quiere decir
     * que el usuario quiere salir de la app
     */
    public void initApp() {
        boolean exit = false;
        do {
            exit = view.showInitMenu();
        } while (!exit);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RestManagerController ctr = new RestManagerController();
        ctr.initApp();
    }

    /**
     * añade elementos a un pedido existente, o crea un pedido
     *
     * @param tableNum el numero de la mesa que quiere añadir a su pedido
     */
    public void completeOrder(int tableNum) {

        Order order;

        if (OrderDB.findByTable(tableNum) != null) {
            order = OrderDB.findByTable(tableNum);

            int item = 0;

            do {
                item = view.askOrderItem();

                if (OrderDB.findById(item) != null) {

                    ArrayList<OrderItem> items = order.getElementsInOrder();

                    for (OrderItem item1 : items) {
                        if (item1.getMenuItem().getId() == item) {
                            item1.setAmount(item1.getAmount() + 1);
                            OrderDB.updateItem(order, item1);
                        } else {
                            items.add(item1);
                            OrderDB.saveItem(order, item1);
                        }

                    }

                } else if (item != 0) {
                    view.showItemNotFoundMessage();
                }

            } while (item != 0);

        } else {
            order = new Order(tableNum);
            OrderDB.save(order);

            int item = 0;
            boolean alreadyExists;

            do {
                item = view.askOrderItem();

                if (OrderDB.findById(item) != null) {

                    ArrayList<OrderItem> items = order.getElementsInOrder();
                    alreadyExists = false;

                    for (OrderItem item1 : items) {
                        if (item1.getMenuItem().getId() == item) {
                            item1.setAmount(item1.getAmount() + 1);
                            alreadyExists = true;
                        }
                    }

                    if (!alreadyExists) {
                        OrderItem oItem = new OrderItem(OrderDB.findById(item), 1);
                        items.add(oItem);
                    }

                } else if (item != 0) {
                    view.showItemNotFoundMessage();
                }

            } while (item != 0);
        }

    }

    /**
     * muestra todo el pedido
     *
     * @param tableNum el número de mesa del pedido wue se quiere ver
     */
    public void showOrder(int tableNum) {
        Order order = OrderDB.findByTable(tableNum);

        view.showOrderItems(order);
    }

}
