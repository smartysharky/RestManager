package model;

/**
 * implementa un elemento de la carta
 * @author Ana Pallarés Rodríguez
 */
public class MenuItem {
    
    private int id;
    private String description;
    private double prize;

    /**
     * 
     * @return el id del plato
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return la descripción del plato 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @return el precio del plato 
     */
    public double getPrize() {
        return prize;
    }

    /**
     * constructor de la clase
     * @param id el id del plato
     * @param description la descripción del plato
     * @param prize el precio del plato
     */
    public MenuItem(int id, String description, double prize) {
        this.id = id;
        this.description = description;
        this.prize = prize;
    }
    
}
