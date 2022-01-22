import java.util.*;
class Main{
    static Scanner sc = new Scanner(System.in);
    static int choice;
    static int ch;
    static int chi;
    static int chq;
    static String usname;
    static List<String> book = new ArrayList<String>();
    static List<Integer> quantity=new ArrayList<Integer>();
    static List<String> borrowers = new ArrayList<String>();
    static List<String> waitingborrower = new  ArrayList<String>();
    static List<String> waitingborrower1 = new ArrayList<String>();
    static List<String> borrowedBooks=new ArrayList<String>();
    static List<Integer> borrowedBooks1=new ArrayList<Integer>();
    static List<String> borrowedBooksname=new ArrayList<String>();
    static List<Integer> date=new ArrayList<Integer>();
    static List<Integer> fine = new ArrayList<Integer>();
    public static void main(String[] args){
        do{
            System.out.println("WELCOME TO THE KPR LIBRARY");
            System.out.println("1.ADMIN");
            System.out.println("2.USER");
            System.out.println("3.Exit");
            System.out.println("Please Enter your Choice:");
            choice =sc.nextInt();
            switch(choice){
                case 1:
                admin();
                break;
                case 2:
                user();
                break;
                case 3:
                break;
            }
        }while(choice!=3);
    }
    static void admin(){
        System.out.println("Please Enter your username");
        String adname=sc.next();
        System.out.println("Please Enter your password");
        String adpass=sc.next();
        if(adname.equals("sakthivel") && adpass.equals("123456")){
            do{
                System.out.println("Hello Admin");
                System.out.println("1.Add Books");
                System.out.println("2.Show Books");
                System.out.println("3.Show Borrowers");
                System.out.println("4.Approve Borrowers");
                System.out.println("5.Borrowed Books");
                System.out.println("6.Exit");
                System.out.println("Please Enter your Choice");
                ch=sc.nextInt();
                switch(ch){
                    case 1:
                    addbooks();
                    break;
                    case 2:
                    showbooks();
                    break;
                    case 3:
                   showborrowers();
                    break;
                    case 4:
                    approveborrower();
                    break;
                    case 5:
                    for(int ij=0;ij<borrowedBooks.size();ij++){
                        System.out.println(borrowedBooks.get(ij));
                        System.out.println(borrowedBooks1.get(ij));
                    }
                    break;
                    case 6:
                    break;
                }
            }while(ch!=6);
        }
    }
    static void addbooks(){
       System.out.println("Enter the number of Books to add:");
       int no=sc.nextInt();
       for(int i=0;i<no;i++){
           System.out.println("Enter the name of the Book");
           String bookname=sc.next();
           System.out.println("Enter the quantity of the Book");
           int quan=sc.nextInt();
           book.add(bookname);
           quantity.add(quan);
       }
    }
    static void showbooks(){
        for(int i=0;i<book.size();i++){
            System.out.println("Book Name "+book.get(i)+" "+"Quantity "+quantity.get(i));
        }
    }
    static void showborrowers(){
        for(int i=0;i<borrowers.size();i++){
            System.out.println(borrowers.get(i));
        }
    }
    static void approveborrower(){
        for(int i=0;i<waitingborrower.size();i++){
            System.out.println("REQUEST NO "+i+" Borrower Name: "+waitingborrower.get(i)+"");
            System.out.println("Enter 1 to approve or 0 to deny");
            int ap=sc.nextInt();
            if(ap==1){
            borrowers.add(waitingborrower.get(i));
            }
        }
    }
    static void user(){
        do{
            System.out.println("Hello User");
            System.out.println("1.New user");
            System.out.println("2.Existing User");
            System.out.println("3.End");
            System.out.println("Please Enter your Choice");
            chi=sc.nextInt();
            switch(chi){
                case 1:
                newuser();
                break;
                case 2:
               existinguser();
                break;
                case 3:
                break;
            }
        }while(chi!=3);
    }
    static void newuser(){
        System.out.println("Please Enter your Name:");
        String username=sc.next();
        System.out.println("Please set your Password:");
        String userpass=sc.next();
        waitingborrower.add(username);
        waitingborrower1.add(userpass);
    }
    static void existinguser(){
        System.out.println("Please Enter your username");
         usname=sc.next();
        System.out.println("Please Enter your password");
        String pas=sc.next();
        for(int i=0;i<borrowers.size();i++){
            if(borrowers.get(i).equals(usname)){
                System.out.println("Hello User");
                do{
                    System.out.println("1.Get Books");
                    System.out.println("2.Return Books");
                    System.out.println("3.List of Books Present");
                    System.out.println("4.Borrowed Books");
                    System.out.println("5.See Fine Amount:");
                    System.out.println("6.End");
                    System.out.println("Please Enter your choice:");
                    chq=sc.nextInt();
                    switch(chq){
                        case  1:
                        getbooks();
                        break;
                        case 2:
                        rebooks();
                        break;
                        case  3:
                        System.out.println(book);
                        break;
                        case 4:
                        for(int ij=0;ij<borrowedBooks.size();ij++){
                            System.out.println(borrowedBooks.get(ij));
                            System.out.println(borrowedBooks1.get(ij));
                        }
                        break;
                        case 5:
                            
                            break;
                        case 6:
                           
                        break;
                    }
                }while(chq!=5);
            }
        }

    }
    static void getbooks(){
        System.out.println("Enter the name  of the Book you want:");
        String bookname=sc.next();
        System.out.println("Enter the quantity of the Book:");
        int qt=sc.nextInt();
        System.out.println("Enter the number of days after which you will return the book:");
        int da=sc.nextInt();
        date.add(da);
        for(int i=0;i<book.size();i++){
            if(book.get(i).equals(bookname)){
                if(quantity.get(i)>=qt){
                    borrowedBooks.add(bookname);
                    borrowedBooks1.add(qt);
                    borrowedBooksname.add(usname);
                    int redquan=quantity.get(i)-qt;
                    quantity.set(i,redquan);
                    
                }
            }
        }
    }
    static void  rebooks(){
        System.out.println("Enter  the title of the Book");
        String title=sc.next();
        System.out.println("Enter the no of books to return");
        int n=sc.nextInt();
        System.out.println("Enter the no of days after which you are returning the book:");
        int reda=sc.nextInt();
        for(int i=0;i<borrowedBooks.size();i++){
            if(borrowedBooks.get(i).equals(title)){
                if(borrowedBooks1.get(i)<=n){
                    int co=borrowedBooks1.get(i)-n;
                    borrowedBooks1.set(i,co);
                    int inde=book.indexOf(title);
                    int pos=quantity.get(inde)+n;
                    quantity.set(inde,pos);
                   
                }
            }
        }
    }
}
