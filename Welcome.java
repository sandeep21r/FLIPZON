package FLIPZON;
import java.util.*;

interface  WelFunction{
    void sign();
    void login();
}
public class Welcome implements WelFunction {

    private  String  enter_input;
    private String input_taker;
    private int int_input_taker;
    private int mode_input;
    private  Admin adm;
    private Customerr cust;
    private Normall norm;
    private int rem = 0;
    private List<Elitee> elites = new ArrayList<Elitee>();
    private List<Normall> normal = new ArrayList<Normall>();
    private  List<Primee> prime = new ArrayList<Primee>();
    private int login_input;
    Normall n;
    Elitee e;
    Primee p;
    String input_name;
    String input_psw;
    int i;
    int j = 0;
    int m;
    int k = 0;
    int add = 0;
    static Welcome wel;
    static List<Categoryy> cat_list;
    static List<Product> pro_list;
    static Categoryy cate;
    static  Product prod;


    Welcome(){
        adm= new Admin(this);
    }

    Scanner sc = new Scanner(System.in);
    Scanner scc = new Scanner(System.in);

    String string_input(){
        input_taker = sc.next();
        return input_taker;
    }
    String string_input1(){
        input_taker = scc.nextLine();
        return input_taker;
    }
    int integer_input(){
        int_input_taker = sc.nextInt();
        return int_input_taker;
    }

    @Override
    public void sign() {
        add =0;
        norm = new Normall(wel);
        norm.input();
        for( i =0 ;i< normal.size();i++){
            n = wel.normal.get(i);
            if(n.getName(n).equals(norm.getName(norm)) && n.getPsw(n).equals(norm.getPsw(norm))){
                System.out.println("You have already registered");
                j = prime.size();
                k = elites.size();
                add = 1;
                break;
            }
        }
        for( ;j< prime.size();j++){
            p = wel.prime.get(i);
            if(p.getName(p).equals(norm.getName(norm)) && p.getPsw(p).equals(norm.getPsw(norm))){
                System.out.println("You have already registered");
                k = elites.size();
                add =1;
                break;
            }
        }
        for( ;k< elites.size();k++){
            e= wel.elites.get(k);
            if(e.getName(e).equals(norm.getName(norm)) && e.getPsw(e).equals(norm.getPsw(norm))){
                System.out.println("You have already registered");
                add =1;
                break;
            }
        }
        if(add != 1){
            normal.add(norm);
            System.out.println("You have Register Succesfull");
        }

    }

    @Override
    public void login(){
        System.out.print("Enter Your Name: ");
        input_name = string_input1();
        System.out.print("Enter Your psw: ");
        input_psw = string_input1();
        j = 0;
        k =0;
        add = 0;
        for( i =0 ;i< normal.size();i++){
            n = normal.get(i);
            if(n.getName(n).equals(input_name) && n.getPsw(n).equals(input_psw)){
                j = prime.size();
                k = elites.size();
                add = 1;
                break;
            }
        }
        for( ;j< prime.size();j++){
            p = prime.get(i);
            if(p.getName(p).equals(input_name) && p.getPsw(p).equals(input_psw)){
                k = elites.size();
                add =2;
                break;
            }
        }
        for( ;k< elites.size();k++){
            e = elites.get(k);
            if(e.getName(e).equals(input_name) && e.getPsw(e).equals(input_psw)){
                add =3;
                break;
            }
        }
        if(add == 1){
            n.run(n);
        } else if (add ==2) {
            p.run(p);
        }
        else {
            e.run(e);
        }
    }

    void customer_login(WelFunction wlf){
        while(true){
            System.out.println("1) Sign up\n"+
            "2) Log in\n" +
                "3) Back");
            System.out.println();
            System.out.print("what do you want do: ");
            login_input = integer_input();
            if(login_input == 1){
                wlf.sign();
                System.out.println();
            } else if (login_input == 2) {
              wlf.login();
            } else if (login_input == 3) {
                break;
            }
            else{
                System.out.println("wrong Input");
            }
        }
    }
    void Product_catalog(Welcome wel){
        wel.cat_list = adm.getCat_list(adm);
        for (m =0;m < wel.cat_list.size() ; m++){
            wel.cate = wel.cat_list.get(m);
            System.out.println("Product of "+wel.cate.getCategory_name(wel.cate));
            System.out.println();
            wel.pro_list = cate.getProd(cate);
            for (i =0;i < wel.pro_list.size();i++){
                wel.prod = wel.pro_list.get(i);
                if(wel.prod == null){
                    continue;
                }
                else{
                    System.out.println("Product Name: "+wel.prod.getProduct_Name(wel.prod));
                    System.out.println("Product Id: "+wel.prod.getProduct_id(wel.prod));
                    System.out.println("Product Price: "+wel.prod.getProduct_price(wel.prod));
                    System.out.println("Product Quantity: "+wel.prod.getProduct_quantity(wel.prod));
                    System.out.println("product other info: "+wel.prod.getProduct_allin(wel.prod));
                    System.out.println();
                }

        }
    }}
    void show_available_deal(Welcome wel){
        if(wel.rem == 0){
            System.out.println("Dear User, there are no deals for now!!! Please check regularly for exciting deals.");
        } else if (wel.adm.getDeal_setter(wel.adm) == 0) {
            System.out.println("Dear User, there are no deals for now!!! Please check regularly for exciting deals.");
        }
        else{
            System.out.println(wel.adm.getInfo_deals(wel.adm));
        }

    }
    Admin getAdm(){
        return wel.adm;
    }

    public static void main(String[] args){
         wel = new Welcome();
        System.out.print("Enter Input to Run Flipzone(FLIPZON to run/NO to stop: ");
        wel.enter_input = wel.string_input();
        if(wel.enter_input.equals("FLIPZON")){
        while(true){
            System.out.println(" ");
            System.out.println("WELCOME TO FLIPZON");
            System.out.println("\t1) Enter as Admin\n"+
            "\t2) Explore the Product Catalog\n"+
            "\t3) Show Available Deals\n"+
            "\t4) Enter as Customer\n"+
            "\t5) Exit the Application\n");
            System.out.print("Which Mode Do you want to use: ");
           wel.mode_input = wel.integer_input();
           if(wel.mode_input == 1){
               wel.adm.admin_run();
               wel.rem = 1;
           } else if (wel.mode_input == 2) {
               wel.Product_catalog(wel);
           } else if (wel.mode_input == 3) {
            wel.show_available_deal(wel);
           } else if (wel.mode_input == 4) {
               wel.customer_login(wel);
           } else if (wel.mode_input == 5) {
               System.out.println("Thanks For Using FLIPZON");
               break;
           }
           else{
               System.out.println("Wrong Input Try Again");
           }
        }
        } else if (wel.enter_input.equals("NO")) {
            System.out.println("Application stop");
        }
        else{
            System.out.println("Wrong Input");
        }
}
int getrem(Welcome w){
        return wel.rem;
}
List<Elitee> getElites(Welcome wel){
        return wel.elites;
}
    List<Primee> getPrime(Welcome wel){
        return wel.prime;
    }
    List<Normall> getNormall(Welcome wel){
        return wel.normal;
    }
}
