import java.util.*;
public class Library {
    static Scanner sc = new Scanner (System.in);
    static  ArrayList<Books> boo=new ArrayList<Books>();
    static ArrayList<Borrowercls> stu=new ArrayList<Borrowercls>();

    static List<String>adminname =new ArrayList<>();
    static List<String>borrowername =new ArrayList<>();

    static List<String>cO =new ArrayList<>();
    static int fine=0;
    static List<String>bb =new ArrayList<>();
    static List<Integer>fi =new ArrayList<>();
    static int adminpass=2001;
    static String st;
    static int ps;
    
    public static void main (String args [])
    {
        adminname.add("adminkpr");
        stu.add(new Borrowercls("vidhya",2001,cO,fine));
        boo.add(new Books("AgniSiragu","isbn 26102001",10));
        boo.add(new Books("Alchemist","isbn 26101972",3));
        boo.add(new Books("HarryPorter","isbn 26102000",15));


        cls();
        frontpage();

    }
    public static void frontpage(){
        
        System.out.println("---------Welcome to KPRIET Library-------");
        System.out.printf("1.Admin\n2.Borrower\n3.exit\nEnter your choice(1/2/3) : ");
        int a=sc.nextInt();
        enter();
        cls();
        switch(a){
            case 1 :
                if(authadmin()){
                    Admin();
                    break;
                }
                else{
                
                    System.out.println("ONLY ADMIN ALLOWED , CONTACT MANAGEMENT");
                    enter();
                    cls();
                    frontpage();
                    
                    break;
                }
            case 2:
               if(authbor()){
                cls();
                Borrower();
                break;
                }
                else{
                    System.out.println("ONLY BORROWERS ALLOWED , CONTACT ADMIN");
                    enter();
                    cls();
                    frontpage();
                    break;
                }

            default:
                System.out.println("Sry Wrong Input");
                enter();
                cls();
                frontpage();
        }
    }
    public static boolean authbor(){
        System.out.println("WELCOME TO BORROWER VERFICATION !!");
        System.out.print("Enter your name : ");
        
        st=sc.nextLine();
        System.out.print("Enter Your Password: ");
        ps=sc.nextInt();
        for(int i=0;i<stu.size();i++){
            if(stu.get(i).name.equals(st) && ps==stu.get(i).pass){
                return true;
            }
        }
        return false;
    }
    public static boolean authadmin(){
        System.out.println("WELCOME TO ADMIN VERFICATION !!");
        System.out.print("ENTER YOUR NAME: ");
        String s1=sc.nextLine();
        System.out.print("ENTER THE PASSWORD: ");
        int lp=sc.nextInt();
        cls();
        if(adminname.contains(s1) && lp==adminpass)
                return true;
        return false;
        
        
    }
    public static void Admin()
        {
            System.out.println("WELCOME ADMIN !!");
            System.out.print("1.Add Books\n2.Modify Books\n3.View Books\n4.search Book\n5.addAdmin\n6.addBoorrower\n7.exit\nEnter your choice() : ");
            int b=sc.nextInt();
            cls();
            switch(b){
                case 1:
                    AddBook();
                    break;
                case 2:
                    ModifyBook();
                    break;
                case 3:
                    ViewBook(0);
                    break;
                case 4:
                    ViewBook(1);
                    break;
                case 5:
                    addAdmin();
                    break;
                case 6:
                    AddBor();
                    break;
                case 7:
                    cls();
                    frontpage();
                    break;
        
        }
            enter();
            
        }
    public static void AddBor(){
        System.out.println("YOU CAN ADD BORROWERS HERE !!");
        System.out.printf("Enter the name of the borrower");
        sc.nextLine();
        String n=sc.nextLine();
        System.out.print("Enter a password for him");
        int l=sc.nextInt();
        stu.add(new Borrowercls(n,l,cO,fine));
        System.out.print("\nNAME ADDED !!");
        enter();
        cls();
        Admin();
    }
    public static void Borrower()
    {
        System.out.println("-----Welcome Borrower----");
        System.out.printf("1.view Books\n2.checkout cart\n3.return book\n4.view data\n5.exit\nEnter your choice: ");
        int l=sc.nextInt();
        cls();
        switch(l){
            case 1:
                ViewBook(5);
                break;
            case 2:
                checkout();
                break;
            case 3:
                retBook();
                break;
            case 4:
                viewData();
                break;
            case 5:
                cls();
                frontpage();


        }
        
        
    }
    public static void addAdmin(){
        System.out.println("YOU CAN ADD ADMIN HERE");
        System.out.print("Enter the name of the admin");
        sc.nextLine();
        String lp=sc.nextLine();
        adminname.add(lp);
        System.out.println("ADMIN NAME ADDED!!");
        enter();
        cls();
        Admin();
    }
    public static void viewData(){
        System.out.println("YOU CAN VIEW THE HISTORY HERE  ");
       //System.out.println(cO);
                for(int k=0;k<stu.size();k++){
                   // System.out.println(stu.get(k).cOu);
                    if(stu.get(k).name.equals(st) && stu.get(k).pass==ps){
                        
                        System.out.println("TOTAL BOOKS BORROWED\n"+stu.get(k).cOu);
                        break;
                        
                    }
                    
                }
               enter();
               cls();
               Borrower(); 
                
        }
    
    public static void retBook(){
        System.out.println("YOU CAN RETURN THE BOOKS  HERE");
        System.out.print("Enter the name of the book returning: ");
        sc.nextLine();
        String ag=sc.nextLine();
        
        for(int i=0;i<boo.size();i++){
                if(boo.get(i).name.equals(ag)){
                    boo.get(i).quanity=boo.get(i).quanity+1;
                }

            }
        System.out.println("BOOk RETURNED SUCCESFULLY");
        enter();
        cls();
        Borrower();



    }
    public static void checkout(){
        System.out.println("YOU CAN ADD THE BOOKS TO THE CART AND BORROW  HERE");
        System.out.print("1.addToCart\n2.DeleteInCart\n3.BorrowCart\n4.exit");
        int o=sc.nextInt();
        cls();
        switch(o){
            case 1:
                System.out.print("Enter the book name that adds to cart: ");
                sc.nextLine();
                String kk=sc.nextLine();
                if(!cO.contains(kk) && cO.size()<=3)
                    cO.add(kk);
                else if(cO.size()>3)
                    System.out.println("Cart Is Full...Delete Some Books");
                else
                    System.out.println("YOU CANNOT HAVE A BOOK TWICE");
                    
                
                enter();
                cls();
                checkout();
                break;
            case 2:
                System.out.print("Enter the book name that delete in cart: ");
                sc.nextLine();
                String pp=sc.nextLine();
                cO.remove(pp);
                System.out.println("BOOK REMOVED !!!");
                enter();
                cls();
                checkout();
                break;
            case 3:
                System.out.print("Do you wanna borrow the books in the cart(yes/no): ");
                sc.nextLine();
                String j=sc.nextLine();
                if(j.equals("yes")){

                    for(String k:cO){
                    for(int i=0;i<boo.size();i++){
                        if(boo.get(i).name.equals(k)){
                            boo.get(i).quanity=boo.get(i).quanity-1;
                        }

                    }
                }
                for(int k=0;k<stu.size();k++){
                    if(stu.get(k).name.equals(st) && stu.get(k).pass==ps){
                        System.out.println(cO);
                        stu.get(k).cOu.addAll(cO);
                       

                        
                    
                            
                        
                        
                       //stu.set(k,new Borrowercls(st, ps, cO, fine));
                        break;

                        
                    }
                    
                }
            }
                else  if(j.equals("no"))System.out.println("Okay!");
                enter();
                cls();
                checkout();
                break;
            case 4:
                System.out.println("EXIT");
                enter();
                cls();
                cO.clear();
                Borrower();
                break;



                
                

        }
        
    }
    public static void AddBook(){
                            System.out.println("YOU CAN ADD BOOKS HERE");
                            System.out.print("Enter the book name: ");
                            sc.nextLine();
                            String bkname=sc.nextLine();
                            System.out.print("Enter the ISBN Book: ");
                            String isbnname=sc.nextLine();
                            System.out.print("Enter the Quanity of  the book: ");
                            int qua=sc.nextInt();
                            boo.add(new Books(bkname,isbnname,qua));
                            enter();
                            cls();
                            Admin();

    }
    public static void ViewBook(int k){
            System.out.println("YOU CAN SEE BOOKS HERE");
            String op="";
            int flag=1;
            if(k==1){
                System.out.print("Enter the name of the Book/ISBN: ");
                sc.nextLine();
                op=sc.nextLine();
            }
            for (int i=0;i<boo.size();i++){
                if(k==0 || k>1){
                    System.out.println(boo.get(i).name +" "+boo.get(i).isbn +" " +boo.get(i).quanity);
                    flag=0;
                }
                if(k==1 && (op.equals(boo.get(i).name) || op.equals(boo.get(i).isbn))){
                        System.out.println("The Book is Available!!");
                        System.out.println(boo.get(i).name +" "+boo.get(i).isbn +" " +boo.get(i).quanity);
                        flag=0;
                        break;

                }
                if(flag==1)System.out.println("BOOK NOT IN LIBRARY");
            }
                enter();
                cls();
               if(k==0 || k==1) Admin();
               else Borrower();

    }
    public static void ModifyBook(){
        System.out.println("YOU CAN MODIFY BOOKS HERE");
        System.out.printf("1.delete a book\n2.change quanity of a book\n3.exit\nEnter Your choice");
        int c=sc.nextInt();
        cls();
        switch(c){
            case 1:
                delBook();
                break;
            case 2:
                quaBook();
                break;
            case 3:
                Admin();
                break;
        }
    }
    public static void delBook(){
        System.out.println("YOU CAN DELETE A BOOK HERE");
        System.out.print("enter the name of the book want to deleted: ");
        sc.nextLine();
        String namee=sc.nextLine();
        int flag=0;
        for (int i=0;i<boo.size();i++){
            if(boo.get(i).name.equals(namee)){
                boo.remove(boo.get(i));
                System.out.println("BOOK REMOVED");
                flag=1;
            }
        }
        if(flag==0)
            System.out.println("BOOK  NOT IN LIBRARY");
        
        enter();
        cls();
        ModifyBook();


    }
    public static void quaBook(){
        System.out.println("YOU CAN CHANGE THE QUANITY OF THE BOOK HERE");
        System.out.println("Enter the name of the book");
        sc.nextLine();
        String l=sc.nextLine(); 
        System.out.println("Enter the quanity to be changed");
        int lo=sc.nextInt();
        int flag=0;
        for(int i=0;i<boo.size();i++){
            if(boo.get(i).name.equals(l)){
                boo.get(i).quanity=lo;
                flag=1;
            }
        }
        if(flag==0)System.out.println("BOOK NOT IN LIBRARY");
        else
        System.out.println("QUANITY CHANGED");
        enter();
        cls();
        ModifyBook();
    


    }


    
    public static void cls(){
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public static void enter(){
        System.out.println("-----------press enter to continue --------");
        sc.nextLine();
        String s=sc.nextLine();
        s+=s;

    }

}
class Books{
    String name;
    String isbn;
    int quanity;
    public Books(String name,String isbn,int quanity){
        this.name=name;
        this.isbn=isbn;
        this.quanity=quanity;
    }
}
class Borrowercls{
     List<String> totalbookborrowed=new ArrayList<>();
     String tbb="",tfines="";
     List<String> cOu=new ArrayList<>();

    int balance=2000,pass;
    String name,yda="";
    public Borrowercls(String name,int pass,List<String> cO,int fine){
        this.name=name;
        this.pass=pass;
        this.balance=balance-fine;
        this.cOu.addAll(cO);
        for(int i=0;i<cO.size();i++){
            this.tbb+=cO.get(i);
            this.tbb+="\n";
        }
        if(fine!=0)this.tfines+=fine;
        
    }
    
    

}