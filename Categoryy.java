package FLIPZON;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Categoryy{
//    main_attribute
    private String category_name;
    private int category_id;
    private List<Product> prod = new ArrayList<Product>();

//    input_taker
    String product_name;
    float product_id;
    String other;
    float product_price;
    int quantity;

//    used in func
    Admin adm;
    List<Categoryy> cat_list;
    Categoryy c;

//    used in computation
    int p_ids;
    int lp_ids;
    int mul;
//    used in input_function
    int id_input;
    String nam_input;
    float flid_input;
    float flid_input_price;
    Scanner sc = new Scanner(System.in);
    Scanner scc = new Scanner(System.in);
    Scanner sccc = new Scanner(System.in);
    Scanner nc = new Scanner(System.in);


     Categoryy(Admin adm) {
         this.adm = adm;
    }
    int idd_input(){
       id_input = sc.nextInt();
         return id_input;
    }
    float prod_idd(){
         flid_input = sc.nextFloat();
         return flid_input;
    }
    float prod_price(){
        flid_input_price = sccc.nextFloat();
        return flid_input;
    }
    String name_input(){
    nam_input = scc.nextLine();
         return nam_input;
    }
    int product_input(Product p){
        System.out.println("ADD Product");
        System.out.print("Product Name: ");
        product_name = name_input();
        p.setProduct_Name(p,product_name);

        System.out.print("Product Id: ");
        product_id = prod_idd();
        mul = (int) (product_id*10);
        p_ids = mul - this.category_id*10;
        p.setProduct_id(p,product_id);

        System.out.print("Product Quantity: ");
        quantity = sc.nextInt();
        p.setProduct_quantity(p,quantity);
        System.out.print("Product Price: ");
        product_price = nc.nextFloat();
        p.setProduct_price(p,product_price);

        System.out.print("other: ");
        other = name_input();
        p.setProduct_allinput(p,other);

        return p_ids;
    }
    void delete_product(Categoryy catg,int p_idd){

        adm.id1 = p_idd;
        adm.p = adm.catg.getProd(adm.catg).get(adm.id1-1);
        if(adm.p == null){
            System.out.println("there is no such product present");
        }
        else{
            adm.p = null;
            catg.prod.set(adm.id1-1,null);}
    }

    int take_input(){
         while(true) {
             System.out.println("Add Category ID");
             category_id = idd_input();
             cat_list = adm.getCat_list(adm);
             if(adm.f == 0){
                 System.out.println("Add name of the category");
                 category_name = name_input();
                 Product p= new Product(adm);
                 lp_ids = product_input(p);
                 prod.add(lp_ids-1,p);
                 return this.category_id;             }
             else if (category_id <= adm.getCat_list(adm).size()) {
                 c = adm.getCat_list(adm).get(category_id-1);
                 if(c != null){
                 System.out.println("Dear Admin, the category ID is already used!!! Please set a different and a unique category ID");
             }
             else{
                 System.out.println("Add name of the category");
                 category_name = name_input();
                 Product p= new Product(adm);
                 lp_ids = product_input(p);
                 prod.add(lp_ids-1,p);
                 return this.category_id;
             }} else  {
                 System.out.println("Add name of the category");
                 category_name = name_input();
                 Product p= new Product(adm);
                 lp_ids = product_input(p);
                 prod.add(lp_ids-1,p);
                 return this.category_id;
             }
         }
    }
    List<Product> getProd(Categoryy cg){
         return cg.prod;
    }
    String getCategory_name(Categoryy cg){
        return cg.category_name;

    }
    int getCategory_id(Categoryy cg){
        return cg.category_id;

    }
}
