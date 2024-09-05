package FLIPZON;
//import Inclass.A;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
//    main attribute
    private final String name ="Beff Jezos";
    private final int psw = 2021283;
    private List<Categoryy> cat_list = new ArrayList<Categoryy>();
    private int  catg_mode_input;
    private Product p1;
    private Product p2;
    private  float add_give_aways_amount;
    private Categoryy c1;
    private Categoryy c2;
    private float p1_id;
    private float p2_id;
    private float deal_price;
    private int c1_id;
    private int c2_id;
    private int p1_id_represet;
    private int p2_id_represet;
    private String info_deals;
    private int deal_setter = 0;
    private List<Float> combined_price = new ArrayList<Float>();


    private Product discount_p;
    private Categoryy discount_c;
    private float discount_p_id;
    private int discount_c_id;
    private int discount_p_ids;

    private float discount_remember;


//    used in main
    int f = 0;
    int id;
    int c_id;
   int p_idd;
    float remm;
    int id1;
    int j_pas_while = 1;
    float remember;


//    used in main
    Product p ;
    Product prod_1 ;
    Categoryy catg;
    List<Product> pro;
    Admin ad;
    Welcome wel;
    int psw_input;
    String name_input;

//    used in input function taker
   float fl_input;
    int intt_input;
    String str_input;



    Scanner sc = new Scanner(System.in);
    Scanner scc = new Scanner(System.in);



    Admin(Welcome wel){
        this.wel = wel;

    }
    String stri_input(){
        str_input = sc.nextLine();
        return str_input;
    }
    int inte_input(){
        intt_input = scc.nextInt();
        return intt_input;
    }
    float flot_input(){
        fl_input = scc.nextFloat();
        return fl_input;
    }
    void delete_category(){
        System.out.println("Which Category Do you want to delete");
        System.out.print("Category Id: ");
        id = inte_input();
        if(id > ad.cat_list.size()){
            System.out.println("there is no such category");
        }
        else{
        catg = ad.cat_list.get(id-1);
        if(catg == null){
            System.out.println("there no such category");
        }
        else {
            catg = null;
            ad.cat_list.set(id-1,null);
            System.out.println("Category Id " + id + "got deleted");
        }}
    }
    void add_giveaway_deal(){
        System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
        System.out.println("Enter the first Product ID");
        p1_id = flot_input();
        System.out.println("Enter the second Product ID");
        p2_id = flot_input();
        System.out.println("Enter the combined price(Should be less than their combined price");
        System.out.print("Combined price for the Elite: ");
        deal_price = flot_input();
        combined_price.add(0,deal_price);
        System.out.println();
        System.out.print("Combined price for the Prime: ");
        deal_price = flot_input();
        combined_price.add(1,deal_price);
        System.out.println();
        System.out.print("Combined price for the Normal: ");
        deal_price = flot_input();
        combined_price.add(2,deal_price);

//        remebering id's
        remember =  p1_id*10;
        c1_id = (int) remember/10;
        p1_id_represet =(int) remember%10;
//        remmbering id's
        remember =  p2_id*10;
        c2_id = (int) remember/10;
        p2_id_represet = (int) remember%10;

        c1 = ad.cat_list.get(c1_id-1);
        c2 = ad.cat_list.get(c2_id-1);
        if(c1 == null  || c2 == null){
            if(c1 == null){
                System.out.println(p1_id +"product  is not present");
            }
            else if(c2 == null ){
                System.out.println(p2_id +" Catergory is not present");
            }
            c1 = null;
            c2 = null;
        }
        else{
            p1 = c1.getProd(c1).get(p1_id_represet-1);
            p2 = c2.getProd(c2).get(p2_id_represet-1);
            if(p1 == null){
                System.out.println(p1_id +"product is not present");
                c1 = null;
                c2 = null;
                p1 = null;
                p2 = null;
            }
            else if(p2 == null ){
                System.out.println(p2_id +"product is not present");
                c1 = null;
                c2 = null;
                p1 = null;
                p2 = null;
            }
            else{
                deal_setter = 1;
                add_give_aways_amount = p1.getProduct_price(p1)+p2.getProduct_price(p2);
                info_deals = "If you Buys both "+p1_id+" and "+p2_id+" together "+"price will be "+combined_price.get(0)+" for elite user ,"+combined_price.get(1)+" for prime user ,"+combined_price.get(2)+" for normal user";
            }

        }
    }


    void discount(){

        System.out.println("Dear Admin give the Product ID you want to add discount for");
        discount_p_id = flot_input();
        discount_remember =  (discount_p_id)*10;
        discount_c_id = (int) discount_remember/10;
        if(discount_c_id > ad.cat_list.size()){
            System.out.println("there is no such product available due to no presence of the catogory");
        }
        else{
        discount_c = ad.cat_list.get(discount_c_id -1);
        if(discount_c == null){
            System.out.println("there is no such product available due to no presence of the catogory");
        }
        else{
        discount_p_ids =(int) discount_remember%10;
        if (discount_p_ids > discount_c.getProd(discount_c).size()){
            System.out.println("there is no such product available");
        }
        else {
            discount_p = discount_c.getProd(discount_c).get(discount_p_ids-1);
            if(discount_p == null){
                System.out.println("there is no such product available");
            }
            else{
                discount_p.discount_set(discount_p);
            }
        }
        }
    }
    }

    void admin_run(){
        this.ad = wel.getAdm();
        j_pas_while = 1;
        while(j_pas_while == 1) {
            System.out.println("Dear Admin,");
            System.out.println("Please Enter Your Username and Password: ");
            System.out.print("Username: ");
            name_input = stri_input();
            System.out.print("Password: ");
            psw_input = inte_input();
            if (name_input.equals(name) && psw_input == psw) {
                while (true) {
                    System.out.println();
                    System.out.println("Welcome Beff!!!");
                    System.out.println("Please Chose ant one of the following action");
                    System.out.println("\t1) Add category\n" +
                            "\t2) Delete category\n" +
                            "\t3) Add Product\n" +
                            "\t4) Delete Product\n" +
                            "\t5) Set Discount on Product\n" +
                            "\t6) Add giveaway deal\n" +
                            "\t7) Back\n");
                    catg_mode_input = inte_input();
                    if (catg_mode_input == 1) {
                        catg = new Categoryy(ad);
                        id = catg.take_input();
                         if (cat_list.size() == 0){
                            cat_list.add(id - 1, catg);
                            }
                         else if (id > cat_list.size()) {
                             cat_list.add(id - 1, catg);
                         } else if(cat_list.get(id-1) == null){
                        cat_list.set(id - 1, catg);
                        }
                        else{
                            cat_list.add(id - 1, catg);}
                        f = 1;
                    } else if (catg_mode_input == 2) {
                       ad.delete_category();
                    } else if (catg_mode_input == 3) {
                        System.out.println("Enter category ID");
                        id = inte_input();
                        catg = ad.cat_list.get(id - 1);
                        if (catg == null) {
                            System.out.println("Such category is not present");
                        } else {
                            p = new Product(ad);
                            id = catg.product_input(p);
                            pro = catg.getProd(catg);
                            if(id <= pro.size()){
                                prod_1 = pro.get(id-1);
                                if(prod_1 == null){
                                    pro.set(id-1, p);
                                }
                                else{
                                    System.out.println("their such product is available");
                            }
                            }
                            else{
                                pro.add(id-1, p);

                            }

                    }} else if (catg_mode_input == 4) {
                        System.out.print("Product Id: ");
                        remm = flot_input();
                        remm = remm*10;
                        p_idd = (int)remm%10;
                        c_id = (int)remm/10;
                        if(c_id > cat_list.size()){
                            System.out.println("such category no present");
                        }
                        else{
                        catg = ad.cat_list.get(c_id-1);
                       if(catg == null){
                            System.out.println("there is no category");
                        }
                        else{
                            catg.delete_product(catg,p_idd);
                        }
                        }
                    } else if (catg_mode_input == 5) {
                        ad.discount();
                    } else if (catg_mode_input == 6) {
                        ad.add_giveaway_deal();
                    } else if (catg_mode_input == 7) {
                        j_pas_while = 0;
                        break;
                    } else {
                        System.out.println("Wrong Input");
                    }
                }
            } else {
                System.out.println("Wrong Input");

            }
        }
    }
    List<Categoryy> getCat_list(Admin a){
        return a.cat_list;
    }
    String getInfo_deals(Admin a){
        return a.info_deals;
    }
    int getDeal_setter(Admin a){
        return a.deal_setter;
    }
    Product getp(Admin a){
        return a.discount_p;
    }
    Product getP1(Admin a){
        return a.p1;
    }
    Product getP2(Admin a){
        return a.p2;
    }
    List<Float> getcombinedprice(Admin a){
        return a.combined_price;
    }
    float getAdd_give_aways_amount(Admin a){
        return a.add_give_aways_amount;
    }
}
