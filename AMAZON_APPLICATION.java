import java.util.*;
 class list{
     static  List<String> arr = new  ArrayList<String>();
  static List<String> brr = new ArrayList<String>();
  static List<String> crr = new ArrayList<String>();
  static List<String> drr = new ArrayList<String>();
  static List<Integer> err = new ArrayList<Integer>();
  static List<Integer> frr = new ArrayList<Integer>();
  static List<String> grr = new ArrayList<String>();
  static List<Integer> hrr = new ArrayList<Integer>();
  static List<Integer> irr = new ArrayList<Integer>();
  static List<String> jrr = new ArrayList<String>();
  static List<String> krr = new ArrayList<String>();
  static List<String> lrr=new  ArrayList<String>();
  static List<Integer> mrr= new ArrayList<Integer>();
  static List<Integer> nrr = new ArrayList<Integer>();
  static List<String> cart = new ArrayList<String>();
  static List<Integer> cart1= new ArrayList<Integer>();
  static List<Integer> cart3=new ArrayList<Integer>();
  static List<String> buys=new ArrayList<String>();
  static List<Integer> buys1=new ArrayList<Integer>();
  static List<Integer> buys2=new ArrayList<Integer>();
 }
class Admin extends list{
    static Scanner sca = new Scanner(System.in);
 
     
    static void admin1(){
   
    System.out.println("--WELCOME ADMIN--");
    int ch=0;
    do{
        System.out.println("Please select options");
       
        System.out.println("1.APPROVE VENDOR");
        System.out.println("2.REMOVE VENDOR");
        System.out.println("3.ADD VENDOR");
        System.out.println("4.APPROVED VENDORS");
        System.out.println("5.EXIT");
         ch=sca.nextInt();
         switch(ch){
             case 1:
                 if((brr.size())==0)System.out.println("No requests for Approval");
                 else{
                 for(int i=0;i<brr.size();i++){
                     System.out.println("Request"+ i +brr.get(i));
                     System.out.println("Enter 1 to Approve or Enter 0 to Deny");
                     int decide=sca.nextInt();
                     if(decide==1){
                         arr.add(brr.get(i));
                     }
                     else{
                         crr.add(brr.get(i));
                     }
                 }
                 }
        case 4:
            if(arr.size()==0)System.out.println("No Approvd Vendors");
            else{
            for(int i=0;i<arr.size();i++ )
    System.out.println("Request"+ i +"is"+ arr.get(i));
         
    }
         }
       
    }while(ch!=5);
   
   
}

       

}
class Vendor extends list{
    static int ca;
   static product prox= new product();
    static Scanner scb=new Scanner(System.in);
   static  Admin ad = new Admin();
    static void vendor1(){
        System.out.println("--WELCOME VENDOR--");
        int ch=0;
    do{
        if(ch==3)break;
        System.out.println("Please select options");
        System.out.println("1.NEW VENDOR");
        System.out.println("2.EXISTING VENDOR");
        System.out.println("3.END");
         ch=scb.nextInt();
          switch(ch){
        case 1:
            System.out.println("--Hello New Vendor--");
            System.out.println("Please Enter your name:");
            String name=scb.next();
            System.out.print("Please Enter your Password");
            String password=scb.next();
            brr.add(name);
            break;
        case 2:
            if(arr.size()==0)System.out.println("No Existing Vendors");
            else{
            int flag=0;
            do{
               
                System.out.println("Please Enter your Login id:");
                String nam=scb.next();
                for(int i=0;i<arr.size();i++){
                    if(nam.equals(arr.get(i))){
                        do{
                            System.out.println("Welcome "+arr.get(i));
                            System.out.println("1.ADD PRODUCTS");
                            System.out.println("2.COMPARE PRODUCTS");
                            System.out.println("3.SHOW PRODUCTS");
                            System.out.println("4.END");
                            System.out.println("Please select the options:");
                             ca=scb.nextInt();
                            switch(ca){
                                case 1:
                                   prox.product1();
                                    break;
                                case 2:
                                    prox.product2();
                                    break;
                                case 3:
                                    for(int m=0;m<err.size();m++){
                                        System.out.println("Name:"+drr.get(m)+" "+"ID:"+err.get(m)+" "+"Cost"+frr.get(m));
                                    }
                               
                                case 4:
                                    break;
                            }
                        }while(ca!=4);
                        flag=1;
                        break;
                    }
                }
                if(flag==0)System.out.println("User not Found");
            }while(flag==0);
            
    }
          }
    }while(ch!=3);
   
}
}
class User extends list{
    static Scanner usq=new Scanner(System.in);
    static int ca;
    static int inp;
    static void user1(){
     System.out.println("-----Welcome to Amazon-----");
     do{
         System.out.println("1.New User");
         System.out.println("2.Existing User");
         System.out.println("3.End");
         System.out.println("Please select options:");
          inp=usq.nextInt();
         switch(inp){
             case 1:
            System.out.println("--Hello New User--");
            System.out.println("Please Enter your name:");
            String name=usq.next();
            System.out.print("Please Enter your Password");
            String password=usq.next();
            jrr.add(name);
            krr.add(password);
            break;
            case 2:
                if(jrr.size()==0)System.out.println("No users found");
                else{
            int flag=0;
            do{
               
                System.out.println("Please Enter your Login id:");
                String nam=usq.next();
                for(int i=0;i<jrr.size();i++){
                    if(nam.equals(jrr.get(i))){
                        do{
                            System.out.println("Welcome "+jrr.get(i));
                            System.out.println("1.Search products");
                            System.out.println("2.CART");
                            System.out.println("3.Buy products");
                            System.out.println("4.Wallet");
                            System.out.println("5.End");
                            System.out.println("Please select the options:");
                             ca=usq.nextInt();
                            switch(ca){
                                case 1:
                                  search();
                                    break;
                                case 2:
                            for(int ia=0;ia<cart.size();ia++){
                                 System.out.println("Product 1 "+cart.get(ia)+"Id "+cart3.get(ia)+"Cost "+cart1.get(ia));
                            }
                                    break;
                                case 3:
                                    int abb=1;
                                    
                                while(abb==1){
                                 System.out.println("Enter the id of the product you want to buy");
                                 int idp=usq.nextInt();
                                 for(int ib=0;ib<cart.size();ib++){
                                     if(cart3.get(ib)==idp){
                                         buys.add(cart.get(ib));
                                         buys1.add(cart3.get(ib));
                                         buys2.add(cart1.get(ib));
                                     }
                                 }
                                 System.out.println("Enter 1 to buy new products or 0 to leave");
                                 abb=usq.nextInt();
                                 
                                }
                                   break;
                               
                                case 4:
                                    int sum=0;
                                 for(int ic=0;ic<buys.size();ic++){
                                     sum+=cart3.get(ic);
                                 }
                                 System.out.println(sum);
                                    break;
                                case 5:
                                    break;
                            }
                        }while(ca!=4);
                        flag=1;
                        break;
                    }
                }
                if(flag==0)System.out.println("User not Found");
            }while(flag==0);
            
    }
         }
     }while(inp!=3);
         }
         static void search(){
             System.out.println("Enter the Name of the item you want to search:");
             String s=usq.next();
             for(int i=0;i<err.size();i++){
                 if(drr.get(i).equals(s)){
            
                lrr.add(drr.get(i));
                mrr.add(frr.get(i));
                nrr.add(err.get(i));
                
            }
                 }
            System.out.println("Related products to your search is:");
            for(int b=0;b<lrr.size();b++){
                System.out.println("Product Name: "+lrr.get(b)+" "+"Id is: "+nrr.get(b)+"Cost is "+" "+mrr.get(b));
            }
            cart2();
        }
        static void cart2(){
            System.out.println("If you want proceed to cart-Enter 1 or Enter 0");
            int aa=usq.nextInt();
            while(aa==1){
            System.out.println("Enter the id of the product you want to add :");
            int s=usq.nextInt();
            for(int i=0;i<lrr.size();i++){
                if(nrr.get(i)==s){
                    cart.add(lrr.get(i));
                    cart1.add(mrr.get(i));
                    cart3.add(nrr.get(i));
                }
            }
            System.out.println("Enter 1 or 0");
            aa=usq.nextInt();
        }
        
        if(aa==0){
            System.out.println("You are out of the cart option");
        }
    
    }
        
}
class product extends list
{
    static Scanner prz= new Scanner(System.in); 
    
    static void product1(){
     System.out.println("Enter number of products to add");
     int s=prz.nextInt();
     for(int i=0;i<s;i++){
         System.out.println("Please Enter the name of the product:");
         String pr=prz.next();
         prz.nextLine();
         System.out.println("Please Enter the Id of the product:");
         int id=prz.nextInt();
         
         System.out.println("Plese Enter the Cost of the product:");
         int cost=prz.nextInt();
         drr.add(pr);
         err.add(id);
         frr.add(cost);
     }
     
}
static void product2(){
    for(int i=0;i<err.size();i++){
        for(int j=i+1;j<err.size();j++){
        if(drr.get(i).equals(drr.get(j))){
            if(err.get(i)!=err.get(j)){
                grr.add(drr.get(i));
                grr.add(drr.get(j));
                hrr.add(err.get(i));
                hrr.add(err.get(j));
                irr.add(frr.get(i));
                irr.add(frr.get(j));
            }
        }
    }
    }
    for(int l=0;l<grr.size();l++){
        System.out.println(grr.get(l)+" "+hrr.get(l)+" "+irr.get(l));
    }
}
}

class orderedList{
    static void orderedList(){
    System.out.println("This is orederdlist");
}
}
class Main{
   
     static int category=0;
     
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
       
        do{
           
            System.out.println("-------WELCOME TO AMAZON-------");
            System.out.println("--Please select the category--");
            System.out.println("1.ADMIN");
            System.out.println("2.VENDOR");
            System.out.println("3.USER");
            System.out.println("4.PRODUCT");
            System.out.println("5.ORDERED LIST");
            System.out.println("6.END");
            Admin adm=new Admin();
            Vendor ven=new Vendor();
            User use= new User();
            product pro= new product();
            orderedList ord = new orderedList();
            category=sc.nextInt();
            switch(category){
                case 1:
                    System.out.print("\033[H\033[2J");
                    adm.admin1();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    ven.vendor1();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    use.user1();
                    break;
                    
                   
                   
            }
           
           
        }while(category!=6);
    }
}