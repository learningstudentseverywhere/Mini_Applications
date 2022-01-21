import java.util.*;
class Main{
    static Scanner sc = new Scanner(System.in);
 static  List<Integer> crr = new ArrayList<Integer>();
static    List<Integer> brr = new ArrayList<Integer>();
    static int[] arr={1,1,1,1} ;
    static int amount;
    static int value;
    static int orgamount;
    static int bal1=arr[0]*2000;
    static int bal2=arr[1]*500;
    static int bal3=arr[2]*200;
    static int bal4=arr[3]*100;
    static int total=(bal1+bal2+bal3+bal4);
    static int count1=0;
     static String user="sakthivel";
      static   String pass="123456";
      static String AdminName="sakthivel";
      static String passwords="123456";
      static int balance=600000;
      static int bca;
    public static void main(String[] args){
       
        System.out.println("WELCOME TO CANARA BANK");
        int ch=0;
        do{
            System.out.println("1.ADMIN");
            System.out.println("2.USER");
            System.out.println("3.EXIT");
            System.out.println("Enter your choice");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                System.out.println("Please enter your AdminNamename");
                String AdminNames=sc.next();
                System.out.println("Please enter your password");
                String password=sc.next();
                if(AdminName.equals(AdminNames) && passwords.equals(password)){
                         System.out.println("HELLO ADMIN");
                         int bcab=0;
                     do{
                         System.out.println("1.LOAD");
                         System.out.println("2.SHOW");
                         System.out.println("3.END");
                         bcab=sc.nextInt();
                         switch(bcab){
                             case 1:
                              returnans1();
                              break;
                             case 2:
                              returnans3();
                              break;
                             case 3:
                                 System.out.println("Thank you for visiting our bank");
                                 break;
                                   
                         }
                         
                     }while(bcab!=3);
                     break;
                    }
                case 2:
                    boolean user=returnans();
                    if(user){
                      System.out.println("HELLO USER");
                      int bca=0;
                      do{
                          System.out.println("1.PIN CHANGE");
                          System.out.println("2.CASH WITHDRAWL");
                          System.out.println("3.BALANCE ENQUIRY");
                          System.out.println("4.Transaction History");
                          System.out.println("5.EXIT");
                          bca=sc.nextInt();
                          switch(bca){
                              case 1:
                                   pass=pinchange();
                                    System.out.println(pass);
                                     break;
                             case 2:
                                 withdrawl();
                                 break;
                              case 3:
                                  System.out.println(balance);
                                  break;
                              case 4:
                                  history();
                                  break;
                              case 5:
                                  System.out.println("Thank you for visiting our bank");
                                   break;
                                   
                                       
                             
                          }
                         
                         
                      }while(bca!=5);
                     
                    }
                     
                case 3:
                    System.out.println("Thank you for visiting our bank");
                   
                   
                    break;
                default:
                System.out.println("Invalid Input");
            }
           
        }while(ch!=3);
    }
    static boolean returnans(){
       System.out.println("Please enter your username");
        String username=sc.next();
        System.out.println("Please enter your password");
        String password=sc.next();
        if(username.equals(user) && pass.equals(password)){
            return true;
        }
        else{
            count1++;
    }
    return false;
    }
   
    static void returnans1(){
        System.out.println("How many 2000 500 200 100 notes you want to deposit");
        for(int i=0;i<4;i++){
            arr[i]=sc.nextInt();
           
        }
        arr[0]=2000*arr[0];
        arr[1]=500*arr[1];
        arr[2]=200*arr[2];
        arr[3]=100*arr[3];
        total=arr[0]+arr[1]+arr[2]+arr[3];
       
        System.out.println("Thank you for visiting our bank sir"+total);
       
    }
    static String pinchange(){
        System.out.println("Please enter your new password");
       String newpass=sc.next();
       String k="";
       if(pass.equals(newpass)){
           System.out.println("You have entered the same password");
       }
       else
        return newpass;
    return k;
    }
    static void returnans3(){
    total-=value;
       System.out.println(total);
    }
    static void withdrawl(){
        System.out.print("Enter the amount to withdraw:");
        amount=sc.nextInt();
        orgamount=0;
         if(amount>((arr[0]*2000)+(arr[1]*500)+(arr[2]*200)+(arr[3]*100))){
             System.out.println("No required no of notes in ATM");
             
         }
         else {
        int h = 1;
        if(amount%100 !=0){
            System.out.println("Enter amount only in 100's");
            h = 0;
        }
        if (h==1)
        {
             orgamount=0 ;
            int count=0, diff=0, sum=0, minf=0, checkref=0, checkref1=0, checkref2=0,checkref3=0,checkref4=0,checkref5=0;
            if(amount<=balance){
                int refamount;
               
                orgamount=amount;
                refamount=amount;
                checkref=refamount/2000;
                checkref1=refamount%2000;
               
                if(checkref>0 && arr[0]>0){
                   
                   do{
                       
                        checkamt();
                        count++;
                        amount-=2000;
                        checkref--;
                       
                       
                    }while( checkref>0 && amount >0 &&arr[0] >0);
                }
                checkref2=checkref1/500;
                checkref3=checkref1%500;
                if(checkref2>0 && arr[1]>0){
                    do{
                        checkamt1();
                        diff++;
                        amount-=500;
                        checkref2--;
                    }while(checkref2>0 && amount >0 &&arr[1]>0);
                }
                checkref4=checkref3/200;
                if(checkref4>0 && arr[2]>0){
                    do{
                        checkamt2();
                        sum++;
                        amount-=200;
                        checkref4--;
                    }while(checkref4>0 && amount >0 && arr[2]>0);
                }
                checkref5=checkref3%200;
                if(checkref5>0 && arr[3]>0){
                    do{
             
                       checkamt3();
                        minf++;
                        amount-=100;
                        checkref5--;
                       
                    }while(checkref5>0 && amount>0 && arr[3]>0);
                }
               value+= (count*2000)+(diff*500)+(sum*200)+(minf*100);
                    if(orgamount==((count*2000)+(diff*500)+(sum*200)+(minf*100))){
                         balance-=orgamount;
                System.out.println("No of 2000 notes is"+count);
                System.out.println("No of 500 notes is"+diff);
                System.out.println("No of 200 notes is"+sum);
                System.out.println("No of 100 notes is"+minf);
                System.out.println((orgamount)+"is your amount");
                System.out.println("Please Collect your cash");
                crr.add(orgamount);
                brr.add(balance);
               
                    }
                    else{
                        System.out.println("No notes");
                    }
               
            }
            else
         System.out.println("INSUFFICIENT BALANCE");
        }
         }
        
    }
    
    static void checkamt(){
        arr[0]-=1;
    }
    static void checkamt1(){
        arr[1]-=1;
    }
    static void checkamt2(){
        arr[2]-=1;
    }
    static void checkamt3(){
        arr[3]-=1;
    }
    static void history(){
        if(crr.size()==0){
            System.out.println("No new Transactions");
            }
            else{
                for(int i=0;i<crr.size();i++){
                    System.out.println("Amount is "+crr.get(i)+"Balance is "+brr.get(i));
                }
            }
        }
    }