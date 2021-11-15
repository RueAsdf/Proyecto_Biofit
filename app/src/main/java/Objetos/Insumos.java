package Objetos;

public class Insumos {

    private int id;
    private int stock;
    private String[] insumons = {"Mancuernas","Barras","Pesas","Press banca"};
    private int[] precios = {35000, 12000, 35000, 120000};

    public Insumos(){


    }

    public Insumos(int id, int stock, String[] insumons, int[] precios) {
        this.id = id;
        this.stock = stock;
        this.insumons = insumons;
        this.precios = precios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String[] getInsumons() {
        return insumons;
    }

    public void setInsumons(String[] insumons) {
        this.insumons = insumons;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int anadirAdicional(int precio,int adicional){


        return precio + adicional;
    }
}
