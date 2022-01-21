import java.util.*;
public class SplitWise {
    static Scanner sc = new Scanner(System.in);
    static int choice;
    static List<String> arr =new ArrayList<String>();
    static List<String> brr = new  ArrayList<String>();
    static List<Integer> wallet =  new ArrayList<Integer>();
    static List<Integer> debt=new ArrayList<Integer>();
    static String email1;
    static String password1;
    static int wallet1;
    static int i;
    static int ch;
    static int amount2; 
    static int deb;
    static int us;
    static String Transaction;
  
    static String name;

    public static void  main(String[] args){
        Transaction="";
        arr.add("sakthidanie007@gmail.com");
        arr.add("vidhyapathimnr@gmail.com");
        brr.add("123456");
        brr.add("654321");
        wallet.add(2000);
        wallet.add(2000);
        debt.add(0);
        debt.add(0);

    do{
        System.out.println("WELCOME TO THE SPLITWISE APPLICATION:");
        System.out.println("1.Group");
        System.out.println("2.Expenses");
        System.out.println("3.Exit");
        System.out.println("Please Enter your Choice:-");
        choice=sc.nextInt();
        switch(choice){
            case 1:
             group();
             break;
            case 2:
            System.out.println(Transaction);
             break;
            case 3:
             System.out.println("Thank you");
             break;
        }
    }while(choice!=3);
    }
    static void group(){
        System.out.println("Welocome to the Group-MGSquad:");
        System.out.println("Please Enter your Name:");
         name=sc.next();
        System.out.println("Please Enter your e-mail Id");
        String email=sc.next();
        System.out.println("Please  Enter your Password:");
        String password=sc.next();
        for( i=0;i<arr.size();i++){
            if(arr.get(i).equals(email) && brr.get(i).equals(password)){
                      
                do{
                    wallet1=wallet.get(i);
                    
                    System.out.println("1.Pay the Expenses:");
                    System.out.println("2.See the Debt");
                    System.out.println("3.Pay the Debt");
                    System.out.println("4.Update Wallet Amount:");
                    System.out.println("5.Add Friends");
                    System.out.println("6.Remove Friends");
                    System.out.println("7.Exit");
                    System.out.println("Please Enter your Choice:");
                     ch=sc.nextInt();
                    switch(ch){
                        case 1:
                         payexpense();
                         break;
                        case 2:
                         System.out.println(debt.get(i));
                         break;
                        case 3:
                         paydebt();
                         break;
                        case 4:
                        System.out.println("Enter the amount to add:");
                        int addamount=sc.nextInt();
                        addamount+=wallet.get(i);
                        wallet.set(i,addamount);
                         break;
                        case 5:
                         addfriends();
                         break;
                        case 6:
                         removefriends();
                         break;
                        case 7:
            
                         break;
                    }
                }while(ch!=7);
            }
        } 
    }
    static void payexpense(){
        System.out.println("Enter the amount to pay:");
        int amount=sc.nextInt();
        if(amount<=wallet1){
            String Trans="The amount paid by "+name+" is "+amount+"";
            Transaction+=Trans;
            amount2=amount/arr.size();
            for(int j=i+1;j<arr.size();j++){
               int debts=amount2;
               debt.set(j,debts);
               
            }
            System.out.println("Amount of "+amount+"is paid");
            wallet1=wallet.get(i)-amount;
            wallet.set(i,wallet1);
        }
    }
  static void paydebt(){
      System.out.println("Debts in your account is:");
      System.out.println(debt.get(i));
      System.out.println("Enter the amount to pay:");
      int pa=sc.nextInt();
      deb=debt.get(i)-pa;
      debt.set(i,deb);
      

  }
  static void addfriends(){
      System.out.println("Enter the no of Friends to add:");
      int no=sc.nextInt();
      for(int s=0;s<no;s++){
          System.out.println("Enter the name of your Friend:");
          String name13=sc.next();
          System.out.println("Enter  the email id of your Friend:");
          String email12=sc.next();
          arr.add(email12);
          System.out.println("Enter the password for your Friend:");
          String password2b=sc.next();
          brr.add(password2b);
          wallet.add(0);
          debt.add(0);
      }
  }
  static void removefriends(){
      System.out.println("Enter the email id of your friend to remove:");
      String na=sc.next();
      us=0;
      for(int a=0;a<arr.size();a++){
          if(arr.get(a).equals(na)){
              arr.set(a,"0");
              brr.set(a,"0");
              wallet.set(a,us);
              debt.set(a,us);

          }
      }
  }
}
