package FLIPZON;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Customerr implements  Function{
    Welcome wel;
    Admin adm;
    private String name;
    private String psw;
    private float amount =1000;
    private String status = "normal";
    private List<Integer> coupons = new ArrayList<>();

    private  List<Product> cart = new ArrayList<Product>();

    Scanner sc = new Scanner(System.in);
    Scanner scc = new Scanner(System.in);
//    browse produt
    List<Categoryy> catg;
    List<Product> pro;
    Categoryy cat;
    Product prod;
    float p_id;
    int p_idd;
    int c_id;
    float id_remember;
//    view coupons
    int i;
//    view cart
     List<Product> cartt;
//     add amount
    float amout;
//    update
        List<Normall> l_n ;
        List<Elitee> l_e ;
        List<Primee> l_p ;
        Normall n1;
        Primee p1;
        String up_str;
        Elitee elit;
        Primee pri;
//        add product
    float id;
    float rememb;
    int p_id1;
    int c_id1;
    List<Categoryy> c_list;
    List<Product> p_list;
    Categoryy b_c;
    Product b_p;
    int quantity;
    int size;
    int give_deal = -1;
    int give_deal1 = -1;

//  clear cart
    float dilivery_charge;
    float all_amount;
    float finl_pay;
    Product dp;
    Product cp;
    List<Integer> coupl;
    int flag = 0;
    int apply;
    int no_coups;
    int coupons_percentage;
    float total_price;
    private int trigerr_add_deal_product;
    float total_discount;

    Customerr(Welcome wel){
        this.wel = wel;
    }
    String getName(Customerr c){
        return c.name;
    }
    String getPsw(Customerr c){
        return c.psw;
    }
    String getStatus(Customerr c){
        return c.status;
    }
    float getAmount(Customerr c){
        return c.amount;
    }

    void  setName(Customerr c,String name){
        c.name = name;
    }
    void setPsw(Customerr c,String psw){
        c.psw = psw;
    }
    void setStatus(Customerr c,String status){
        c.status = status;
    }
    void setCoupons(Customerr c,List<Integer> coupons){
        c.coupons = coupons;
    }
    void setCart(Customerr c,List<Product> cart){
        c.cart = cart;
    }
    void  setamount(Customerr c,float amount){
        c.amount = amount;
    }
    void input() {
        System.out.print("Enter Name: ");
        this.name =sc.nextLine();
        System.out.print("Enter password(psw will only integer):");
        this.psw = scc.nextLine();
        this.adm = wel.getAdm();
    }
    @Override
    public void browse_products(Customerr c) {
        catg = c.adm.getCat_list(c.adm);
        System.out.print("Enter Product Id to browse: ");
        p_id = sc.nextFloat();
        id_remember = p_id*10;
        p_idd = (int) id_remember%10;
        c_id = (int) id_remember/10;
        if(c_id > catg.size()){
            System.out.println("there no such product present");
        } else {
            cat = catg.get(c_id-1);
            if (cat == null){
                System.out.println("there no such product present");
            }
            else {
                pro = cat.getProd(cat);
                if(p_idd > pro.size()){
                    System.out.println("there no such product present");
                }
                else {
                    prod = pro.get(p_idd-1);
                    if (prod == null){
                        System.out.println("there no such product present");
                    }
                    else {
                        System.out.println("Information of the product that you search is");
                        System.out.println("Product Name: "+prod.getProduct_Name(prod));
                        System.out.println("Product Id: "+prod.getProduct_id(prod));
                        System.out.println("Product Price: "+prod.getProduct_price(prod));
                        System.out.println("Product quantity: "+prod.getProduct_quantity(prod));
                        System.out.println("product other info: "+prod.getProduct_allin(prod));
                    }
                }
            }
        }
    }
    @Override
    public void browse_deals(Customerr c) {
        if(wel.getrem(wel)== 0){
            System.out.println("Dear User, there are no deals for now!!! Please check regularly for exciting deals.");
        } else if (c.adm.getDeal_setter(c.adm) == 0) {
            System.out.println("Dear User, there are no deals for now!!! Please check regularly for exciting deals.");
        }
        else{
            System.out.println(c.adm.getInfo_deals(c.adm));
        }
    }
    @Override
    public void views_coupons(Customerr c) {
//        l = c.coupons;
        if(c.coupons.size() == 0){
            System.out.println("There is no coupons");
        }
        else{
            System.out.println("Available Coupons are: "+c.coupons.size());
            System.out.println("And There Discount % is");
            for (i =0; i< c.coupons.size();i++){
                System.out.println(i+1 +") "+c.coupons.get(i));
            }
        }
    }
    @Override
    public void check_balance(Customerr c) {
        System.out.println("Current account balance is Rupees "+c.amount);
    }
    @Override
    public void view_cart(Customerr c) {
        cartt = c.cart;
        if(cartt.size() == 0){
            System.out.println("Cart is empty");
        }
        else {
            for (i = 0;i < cartt.size();i++){
                prod = cartt.get(i);
                System.out.println("Information of the product");
                System.out.println("Product Name: "+prod.getProduct_Name(prod));
                System.out.println("Product Id: "+prod.getProduct_id(prod));
                System.out.println("Product Price: "+prod.getProduct_price(prod));
                System.out.println("product other info: "+prod.getProduct_allin(prod));
            }
        }
    }
    @Override
    public void empty_cart(Customerr c) {
       c.cart.clear();
        System.out.println("Cart is successfully empty");
    }
    @Override
    public void add_amount(Customerr c) {
        System.out.print("Enter How many amount do you want to add: ");
        amout = sc.nextFloat();
        c.amount += amout;
        System.out.println("Amount is successfully added");
    }
    @Override
    public int update(Customerr c){
        System.out.print("Current Status is: ");
        System.out.println(c.status);
        System.out.print("Choose new Status: ");
         up_str = sc.next();
         if(c.status.equals("elite")){
             System.out.println("You are still a elite user");
             return 0;
         } else if (c.status.equals("prime")) {
             if(up_str.equals("elite")){
                 elit = new Elitee(wel);
                 c.amount = c.amount - 300;
                 elit.setName(elit,c.name);
                 elit.setPsw(elit,c.psw);
                 elit.setamount(elit,c.amount);
                 elit.setStatus(elit,"elite");
                 elit.setCoupons(elit,c.coupons);
                 elit.setCart(elit,c.cart);
                 elit.adm = c.adm;
                 l_p = wel.getPrime(wel);
                l_e = wel.getElites(wel);
                 for (i =0;i < l_p.size();i++){
                     p1 = l_p.get(i);
                     if (p1.getPsw(p1) == c.getPsw(c)){
                         l_p.remove(i);
                         l_e.add(elit);
                         System.out.println("Successfully updated");
                         elit.run(elit);
                         return 1;
                     }
                 }

         } else if (up_str.equals("prime")) {
                 System.out.println("You are still a prime user");
             } else{
                 System.out.println("You are still a prime user");
                 return 0;
             }
         } else if (c.status.equals("normal")) {
             if(up_str.equals("elite")){
                 elit = new Elitee(wel);
                 c.amount = c.amount - 300;
                 elit.setName(elit,c.name);
                 elit.setPsw(elit,c.psw);
                 elit.setamount(elit,c.amount);
                 elit.setStatus(elit,"elite");
                 elit.setCoupons(elit,c.coupons);
                 elit.setCart(elit,c.cart);
                 elit.adm = c.adm;
                 l_n = wel.getNormall(wel);
                 l_e = wel.getElites(wel);
                 for (i =0;i < l_n.size();i++){
                     n1 = l_n.get(i);
                     if (n1.getPsw(n1) == c.getPsw(c)){
                         l_n.remove(i);
                         l_e.add(elit);
                         System.out.println("Successfully updated");

                         elit.run(elit);
                         return 1;
                     }
                 }
             }
             else if(up_str.equals("prime")){
                 pri = new Primee(wel);
                 c.amount = c.amount - 200;
                 pri.setName(pri,c.name);
                 pri.setPsw(pri,c.psw);
                 pri.setamount(pri,c.amount);
                 pri.setStatus(pri,"prime");
                 pri.setCoupons(pri,c.coupons);
                 pri.setCart(pri,c.cart);
                 pri.adm = c.adm;
                 l_n = wel.getNormall(wel);
                 l_p = wel.getPrime(wel);
                 for (i =0;i < l_n.size();i++){
                     n1 = l_n.get(i);
                     if (n1.getPsw(n1) == c.getPsw(c)){
                         l_n.remove(i);
                         l_p.add(pri);
                         System.out.println("Successfully updated");

                         pri.run(pri);
                         return 1;
                     }
                 }
             }
             else{
                 System.out.println("You are still normal user");
                 return 0;
             }
         }

        return 0;
    }
    @Override
    public void add_product(Customerr c){
        System.out.print("Product Id: ");
        c.id = sc.nextFloat();
        c.rememb  = id*10;
        c.p_id1 = (int) rememb%10;
        c.c_id1 =(int) rememb/10;

        c.c_list = adm.getCat_list(adm);
        if(c.c_id1 > c.c_list.size()){
            System.out.println("there no such product present");
        } else {
            c.b_c = c.c_list.get(c.c_id1-1);
            if (c.b_c == null){
                System.out.println("there no such product present");
            }
            else {
                c.p_list = c.b_c.getProd(c.b_c);
                if(c.p_id1 > c.p_list.size()){
                    System.out.println("there no such product present");
                }
                else {
                    c.b_p = c.p_list.get(c.p_id1-1);
                    if (c.b_p == null){
                        System.out.println("there no such product present");
                    }
                    else {
                        System.out.print("Quantity is: ");
                        c.quantity = sc.nextInt();
                        if(c.quantity > c.b_p.getProduct_quantity(c.b_p)){
                            System.out.println("Current the stock of "+c.b_p.getProduct_Name(c.b_p) +" is less then your demand");
                        }
                        else {
                            for (i =0;i < c.quantity;i++){
                                c.size = c.cart.size();
                                c.cart.add(c.size,c.b_p);
                            }
                            System.out.println("Product added Succesfully");
                            System.out.println();
                        }

                    }
                }
            }
        }
    }
    @Override
    public void add_deal_product(Customerr c){
        if (adm.getDeal_setter(adm) == 0) {
            System.out.println("There is no product in deal");
        }
        else {
            c.trigerr_add_deal_product = 1;
            c.give_deal = c.cart.size();
            c.give_deal1 = c.cart.size()+1;
            if(adm.getP1(adm).getProduct_quantity(adm.getP1(adm)) <= 0 || adm.getP2(adm).getProduct_quantity(adm.getP2(adm)) <= 0 ){
                System.out.println("Product stock is empty");
            }
            else{
            c.cart.add(adm.getP1(adm));
            c.cart.add(adm.getP2(adm));
                System.out.println("Product added Succesfully");
                System.out.println();
        }}
    }
    public void clear_cart(Customerr c){
     if (c.status.equals("normal")){
         c.flag =0;
         cartt = c.cart;
         c.dilivery_charge = 100;
         c.apply = 0;
         c.all_amount =0;
         c.finl_pay =0;
         c.total_price =0;
         c.total_discount =0;
     if(cartt.size() == 0){
             System.out.println("your cart is empty");
         }
         else {
             for ( i = 0 ;i < cartt.size();i++){
                 cp = cartt.get(i);
                 dp = adm.getp(adm);
                 if(c.give_deal == i && c.give_deal1 == i+1 || c.trigerr_add_deal_product == 1){
                     c.trigerr_add_deal_product = 0;
                     c.flag = 1;
                     i += 1;
                     continue;
                 }
                 else  if(dp != null ) {
                     if (dp.getProduct_id(dp) == cp.getProduct_id(cp)) {
                         c.total_price += cp.getProduct_price(cp);
                         c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * dp.getDiscount_normal(dp)) / 100);
                             c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * dp.getDiscount_normal(dp)) / 100));
                         }
                     else {
                         c.total_price += cp.getProduct_price(cp);
                         c.total_discount = c.total_discount +0;
                         c.all_amount = c.all_amount + cp.getProduct_price(cp);

                     }
                 }

                 else {
                     c.total_price += cp.getProduct_price(cp);
                     c.total_discount = c.total_discount +0;
                     c.all_amount = c.all_amount + cp.getProduct_price(cp);
                 }
             }
             if(flag == 1){
                 c.total_price += adm.getcombinedprice(adm).get(2);
                 c.total_discount = c.total_discount +(adm.getAdd_give_aways_amount(adm)-adm.getcombinedprice(adm).get(2));
                 c.all_amount = c.all_amount + adm.getcombinedprice(adm).get(2);
             }

             c.dilivery_charge = c.dilivery_charge + ((c.total_price*5)/100);

             c.finl_pay = c.dilivery_charge+c.all_amount;
             if (c.finl_pay > c.amount){
                 System.out.println("Bank Balance is low cannot buy");
             }
             else {
                 c.amount = c.amount - c.finl_pay;
                 for (int i = 0;i < cartt.size();i++){
                     dp = cartt.get(i);
                     dp.setProduct_quantity(dp,dp.getProduct_quantity(dp) -1);
                 }

                 System.out.println("succefully placed order");
                 System.out.println();
                 for (int i = 0;i< cartt.size();i++){
                     dp =cartt.get(i);
                     System.out.println("Product Name: "+dp.getProduct_Name(dp));
                     System.out.println("Product Id: "+dp.getProduct_id(dp));
                     System.out.println("Product Price: "+dp.getProduct_price(dp));
                     System.out.println("product other info: "+dp.getProduct_allin(dp));
                     System.out.println();
                 }
                 System.out.println("Dilivery Charge is: "+ c.dilivery_charge);
                 System.out.println("Total Discount on Product is: "+c.total_discount);
                 System.out.println("Product Price after discount: "+c.all_amount);
                 System.out.println("Total amount to pay is: "+c.finl_pay);
                 System.out.println("Wallet Balance is: "+c.amount);
                 c.empty_cart(c);
                 System.out.println("Product Will be Diliverd between 7 to 10 days");
             }
         }
     }


        else if (c.status.equals("prime")) {
         c.flag = 0;
         cartt = c.cart;
         c.dilivery_charge = 100;
         c.apply = 0;
         c.all_amount =0;
         c.finl_pay =0;
         c.total_price =0;
         c.total_discount =0;
         if (cartt.size() == 0) {
             System.out.println("your cart is empty");
         } else {
             c.coupl = c.coupons;
             if (c.coupl.size() != 0) {
                 c.apply = c.coupl.get(0);
             }
             for (i = 0; i < cartt.size(); i++) {
                 cp = cartt.get(i);
                 dp = adm.getp(adm);
                 if (c.give_deal == i && c.give_deal1 == i + 1 && c.trigerr_add_deal_product == 1) {
                     c.trigerr_add_deal_product = 0;
                     c.flag = 1;
                     i += 1;
                     continue;
                 } else if (dp != null) {
                     if (dp.getProduct_id(dp) == cp.getProduct_id(cp)) {
                         if (c.apply > dp.getDiscount_prime(dp)) {
                             if (c.apply > 5) {
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount +((cp.getProduct_price(cp) * c.apply) / 100);
                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * c.apply) / 100));

                             } else {
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * 5) / 100);
                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 5) / 100));


                             }

                         } else {
                             if (dp.getDiscount_prime(dp) > 5) {
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount +  ((cp.getProduct_price(cp) * dp.getDiscount_prime(dp)) / 100);

                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * dp.getDiscount_prime(dp)) / 100));

                             } else {
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount +  ((cp.getProduct_price(cp) * 5) / 100);

                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 5) / 100));
                             }
                         }
                     }
                     else {
                         if (c.apply > 5) {
                             c.total_price += cp.getProduct_price(cp);
                             c.total_discount = c.total_discount +((cp.getProduct_price(cp) * c.apply) / 100);
                             c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * c.apply) / 100));

                         } else {
                             c.total_price += cp.getProduct_price(cp);
                             c.total_discount = c.total_discount +  ((cp.getProduct_price(cp) * 5) / 100);
                             c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 5) / 100));


                         }
                     }
                 } else {
                     if (c.apply > 5) {
                         c.total_price += cp.getProduct_price(cp);
                         c.total_discount = c.total_discount +  ((cp.getProduct_price(cp) * c.apply) / 100);
                         c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * c.apply) / 100));

                     } else {
                         c.total_price += cp.getProduct_price(cp);
                         c.total_discount = c.total_discount +  ((cp.getProduct_price(cp) * 5) / 100);
                         c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 5) / 100));


                     }
                 }
             }
                 if (flag == 1) {
                     c.total_price += adm.getcombinedprice(adm).get(1);
                     c.total_discount = c.total_discount + (adm.getAdd_give_aways_amount(adm)- adm.getcombinedprice(adm).get(1));
                     c.all_amount = c.all_amount + adm.getcombinedprice(adm).get(1);


                 }
                 c.dilivery_charge = c.dilivery_charge + ((c.total_price * 2) / 100);
                 c.finl_pay = c.dilivery_charge + c.all_amount;
                 if (c.finl_pay > c.amount) {
                     System.out.println("Bank Balance is low cannot buy");
                 } else {
                     c.amount = c.amount - c.finl_pay;
                     for (int i = 0; i < cartt.size(); i++) {
                         dp = cartt.get(i);
                         dp.setProduct_quantity(dp, dp.getProduct_quantity(dp) - 1);
                     }
                     if (c.coupons.size() != 0) {
                         c.coupons.remove(0);
                     }
                     System.out.println("succefully placed order");
                     System.out.println();
                     for (int i = 0; i < cartt.size(); i++) {
                         dp = cartt.get(i);
                         System.out.println("Product Name: " + dp.getProduct_Name(dp));
                         System.out.println("Product Id: " + dp.getProduct_id(dp));
                         System.out.println("Product Price: " + dp.getProduct_price(dp));
                         System.out.println("product other info: " + dp.getProduct_allin(dp));
                         System.out.println();
                     }

                     System.out.println("Dilivery Charge is: " + c.dilivery_charge);
                     System.out.println("Total Discount on Product is: "+c.total_discount);
                     System.out.println("Product Price after discount: " + c.all_amount);
                     System.out.println("Total amount to pay is: " + c.finl_pay);
                     System.out.println("Wallet Balance is: " + c.amount);
                     c.empty_cart(c);
                     if (c.finl_pay > 5000){
                         c.no_coups = (int)(Math.random()*2)+1;
                         System.out.println("WOW you have won "+c.no_coups+" Coupons");
                         for (int i = 0;i< c.no_coups;i++){
                             c.coupons_percentage = (int)(Math.random()*11)+5;
                             c.coupons.add(c.coupons_percentage);
                             System.out.println("Having percentage: \n"+(i+1)+")"+c.coupons.get(i));
                         }
                         Collections.sort(c.coupons, Collections.reverseOrder());
                     }
                     else {
                         System.out.println("Sorry Your purchase amount is less than 5000");
                     }
                     System.out.println();
                     System.out.println("Product Will be Diliverd between 3 to 4 days");

             }
         }
        }

     else if (c.status.equals("elite")){
         c.flag =0;
         cartt = c.cart;
         c.dilivery_charge = 100;
         c.apply = 0;
         c.all_amount =0;
         c.finl_pay =0;
         c.total_price =0;
         c.total_discount =0;
         if(cartt.size() == 0){
             System.out.println("your cart is empty");
         }
         else {
             c.coupl = c.coupons;
             if(c.coupl.size() != 0){
                 c.apply = c.coupl.get(0);
             }
             for ( i = 0 ;i < cartt.size();i++){
                 cp = cartt.get(i);
                 dp = adm.getp(adm);
                 if(c.give_deal == i && c.give_deal1 == i+1 && c.trigerr_add_deal_product ==1){
                     c.trigerr_add_deal_product = 0;
                     c.flag = 1;
                     i += 1;
                     continue;
                 }
                 else  if(dp != null ) {
                     if (dp.getProduct_id(dp) == cp.getProduct_id(cp)) {
                         if (c.apply > dp.getDiscount_elite(dp)) {
                             if(c.apply > 10){
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * c.apply) / 100);
                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * c.apply) / 100));}
                             else{
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * 10) / 100);

                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 10) / 100));
                             }

                         } else {
                             if (dp.getDiscount_elite(dp) > 10) {
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * dp.getDiscount_elite(dp)) / 100);
                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * dp.getDiscount_elite(dp)) / 100));
                             } else {
                                 c.total_price += cp.getProduct_price(cp);
                                 c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * 10) / 100);
                                 c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 10) / 100));
                             }                         }
                     }
                     else {
                         if(c.apply > 10){
                             c.total_price += cp.getProduct_price(cp);
                             c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * c.apply) / 100);

                             c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * c.apply) / 100));}
                         else{
                             c.total_price += cp.getProduct_price(cp);
                             c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * 10) / 100);

                             c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 10) / 100));
                         }

                     }
                 }
                 else {
                     if(c.apply > 10){
                         c.total_price += cp.getProduct_price(cp);
                         c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * c.apply) / 100);
                         c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * c.apply) / 100));}
                     else{
                         c.total_price += cp.getProduct_price(cp);
                         c.total_discount = c.total_discount + ((cp.getProduct_price(cp) * 10) / 100);
                         c.all_amount = c.all_amount + (cp.getProduct_price(cp) - ((cp.getProduct_price(cp) * 10) / 100));
                     }                 }
             }
             if(c.flag == 1){
                 c.total_price += adm.getcombinedprice(adm).get(0);
                 c.total_discount = c.total_discount + (adm.getAdd_give_aways_amount(adm)- adm.getcombinedprice(adm).get(1));
                 c.all_amount = c.all_amount + adm.getcombinedprice(adm).get(1);
                 }
             c.dilivery_charge = c.dilivery_charge ;
             c.finl_pay = c.dilivery_charge+c.all_amount;
             if (c.finl_pay > c.amount){
                 System.out.println("Bank Balance is low cannot buy");
             }
             else {
                 c.amount = c.amount - c.finl_pay;
                 for (int i = 0;i < cartt.size();i++){
                     dp = cartt.get(i);
                     dp.setProduct_quantity(dp,dp.getProduct_quantity(dp) -1);
                 }
                 if (c.coupons.size() != 0){
                     c.coupons.remove(0);
                 }
                 System.out.println("succefully placed order");
                 System.out.println();
                 for (int i = 0;i< cartt.size();i++){
                     dp =cartt.get(i);
                     System.out.println("Product Name: "+dp.getProduct_Name(dp));
                     System.out.println("Product Id: "+dp.getProduct_id(dp));
                     System.out.println("Product Price: "+dp.getProduct_price(dp));
                     System.out.println("product other info: "+dp.getProduct_allin(dp));
                     System.out.println();
                 }
                 System.out.println("Dilivery Charge is: "+ c.dilivery_charge);
                 System.out.println("Total Discount on Product is: "+c.total_discount);
                 System.out.println("Product Price after discount: "+c.all_amount);
                 System.out.println("Total amount to pay is: "+c.finl_pay);
                 System.out.println("Wallet Balance is: "+c.amount);
                 c.empty_cart(c);
                 if (c.finl_pay > 5000){
                     c.no_coups = (int)(Math.random()*(2))+3;
                     System.out.println("WOW you have won "+c.no_coups+" Coupons");
                     for (int i = 0;i< c.no_coups;i++){
                         c.coupons_percentage = (int)(Math.random()*11)+5;
                         c.coupons.add(c.coupons_percentage);
                         System.out.println("Having percentage: \n"+(i+1)+" ) "+c.coupons.get(i));
                     }
                     Collections.sort(c.coupons, Collections.reverseOrder());
                 }
                 else {
                     System.out.println("Sorry Your purchase amount is less than 5000");
                 }



                 System.out.println("Product Will be Diliverd between 2 days");
             }
         }
     }
    }
    }





class Normall extends Customerr {
    int mode;
    int check;
    Scanner sc = new Scanner(System.in);

    Normall(Welcome wel) {
        super(wel);
    }

    void run(Normall n) {
        while (true) {
            System.out.println();
            System.out.println("welcome " + n.getName(n));
            System.out.println("1) browse products\n" +
                    "2) browse deals\n" +
                    "3) add a product to cart\n" +
                    "4) add products in deal to cart\n" +
                    "5) view coupons\n" +
                    "6) check account balance\n" +
                    "7) view cart\n" +
                    "8) empty cart\n" +
                    "9) checkout cart\n" +
                    "10) upgrade customer status\n" +
                    "11) Add amount to wallet\n" +
                    "12) back");
            System.out.print("Which mode do you want to use: ");
            mode = sc.nextInt();
            if (mode == 1) {
                this.browse_products(n);
            }
            else if (mode == 2) {
                this.browse_deals(n);
            }
            else if (mode == 3) {
                this.add_product(n);
            }
            else if (mode == 4) {
                this.add_deal_product(n);
            }
            else if (mode == 5){
                this.views_coupons(n);
            }
            else if (mode == 6){
                this.check_balance(n);
            }
            else if (mode == 7){
                this.view_cart(n);
            }
            else if (mode == 8){
                this.empty_cart(n);
            } else if (mode == 9) {
                this.clear_cart(n);
            } else if (mode == 10){
                check = this.update(n);
                if(check == 1){
                    break;
                }
            }
            else if (mode == 11) {
                this.add_amount(n);

            }
            else if (mode == 12) {
                break;
            } else {
                System.out.println("Wrong Input");
            }
        }
    }
}
class Primee extends Customerr {
    int mode;
    int check;
    Scanner sc = new Scanner(System.in);
    Primee(Welcome wel) {
        super(wel);
    }
    void run(Primee p) {
        while (true) {
            System.out.println();
            System.out.println("welcome " + p.getName(p));
            System.out.println("1) browse products\n" +
                    "2) browse deals\n" +
                    "3) add a product to cart\n" +
                    "4) add products in deal to cart\n" +
                    "5) view coupons\n" +
                    "6) check account balance\n" +
                    "7) view cart\n" +
                    "8) empty cart\n" +
                    "9) checkout cart\n" +
                    "10) upgrade customer status\n" +
                    "11) Add amount to wallet\n" +
                    "12) back");
            System.out.print("Which mode do you want to use: ");
            mode = sc.nextInt();
            if (mode == 1) {
                this.browse_products(p);
            }
            else if (p.mode == 2) {
                this.browse_deals(p);
            }
            else if (mode == 3) {
                this.add_product(p);
            }
            else if (mode == 4) {
                this.add_deal_product(p);
            }
            else if (mode == 5){
                this.views_coupons(p);
            }
            else if (mode == 6){
                this.check_balance(p);
            }
            else if (mode == 7){
                this.view_cart(p);
            }
            else if (mode == 8){
                this.empty_cart(p);
            }
            else if (mode == 9){
                this.clear_cart(p);
            }
            else if (mode == 10){
                check = this.update(p);
                if(check == 1){
                    break;
                }
            }
            else if (mode == 11) {
                this.add_amount(p);

            }
            else if (mode == 12) {
                break;
            } else {
                System.out.println("Wrong Input");
            }
        }
    }


}
class Elitee extends Customerr {
    int mode;
    int check;
    Scanner sc = new Scanner(System.in);
    Elitee(Welcome wel) {
        super(wel);
    }
    void run(Elitee e) {
        while (true) {
            System.out.println();
            System.out.println("welcome " + e.getName(e));
            System.out.println("1) browse products\n" +
                    "2) browse deals\n" +
                    "3) add a product to cart\n" +
                    "4) add products in deal to cart\n" +
                    "5) view coupons\n" +
                    "6) check account balance\n" +
                    "7) view cart\n" +
                    "8) empty cart\n" +
                    "9) checkout cart\n" +
                    "10) upgrade customer status\n" +
                    "11) Add amount to wallet\n" +
                    "12) back");
            System.out.print("Which mode do you want to use: ");
    mode = sc.nextInt();
            if (mode == 1) {
                this.browse_products(e);
            }
            else if (mode == 2) {
                this.browse_deals(e);
            }
            else if (mode == 3) {
                this.add_product(e);
            }
            else if (mode == 4) {
                this.add_deal_product(e);
            }
            else if (mode == 5){
                this.views_coupons(e);
            }
            else if (mode == 6){
                this.check_balance(e);
            }
            else if (mode == 7){
                this.view_cart(e);
            }
            else if (mode == 8){
                this.empty_cart(e);
            }
            else if (mode == 9){
                this.clear_cart(e);
            }
            else if (mode == 10){
                check = this.update(e);
                if(check == 1){
                    break;
                }
            }
            else if (mode == 11) {
                this.add_amount(e);
            }
            else if (e.mode == 12) {
                break;
            } else {
                System.out.println("Wrong Input");
            }
        }
    }
}