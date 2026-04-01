package ie.atu.serialisation;

import java.io.Serializable;

public class Product implements Serializable{
    private static final long serialVersionUID = 2L;

    private String name;
    private double price;
    private String category;

    public Product(String name, double price){
       this(name, price, "Uncategorised");
    }

    public Product(String name, double price, String category){
       this.name = name;
       this.price = price;
       this.category = category;
    }

    @Override
    public String toString(){
        return "Product{name=' " + name + " ', price= " + price + " , category=' " + category + " '}";
    }
}