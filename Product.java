package FLIPZON;

import java.util.Scanner;

public class Product extends Categoryy {
    private String  product_Name;
    private float product_id;
    private String allinput;
    private float price;
    private int product_quantity;

    private float discount_elite;
    private float discount_prime;
    private float discount_normal;
    Scanner sc = new Scanner(System.in);

    Product(Admin adm) {
        super(adm);
    }
    void discount_set(Product p){
        System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms)");
        System.out.print("Discount for the elite: ");
        p.discount_elite = sc.nextFloat();


        System.out.print("Discount for the Prime: ");
        p.discount_prime = sc.nextFloat();



        System.out.print("Discount for the Normal: ");
        p.discount_normal = sc.nextFloat();
    }
    String getProduct_Name(Product p){
        return p.product_Name;
    }
    float getProduct_id(Product p){
        return p.product_id;
    }
    float getProduct_price(Product p){
        return p.product_price;    }
    String getProduct_allin(Product p){
        return p.allinput;
    }
    int getProduct_quantity(Product p){
        return p.product_quantity;
    }
    void setProduct_Name(Product p,String name){
       p.product_Name = name;
    }
    void setProduct_id(Product p,float id){
        p.product_id = id;
    }
    void setProduct_allinput(Product p,String other){
       p.allinput = other;
    }
    void setProduct_price(Product p,float price){
        p.product_price = price;
    }

    void setProduct_quantity(Product p,int quant){
        p.product_quantity = quant;
    }
    float getDiscount_elite(Product p){
        return p.discount_elite;
    }
    float getDiscount_prime(Product p){
        return p.discount_prime;
    }
    float getDiscount_normal(Product p){
        return p.discount_normal;
    }
}
