import java.util.*;

public class Railway {
    static Scanner sc = new Scanner(System.in);
    static int choice;
    static int ch;
    static int arr[][];
    static List<String> brr = new ArrayList<String>();
    static List<String> train = new ArrayList<String>();
    static int seat;
    static int city;
    static int opt;
    static int start1;
    static int end1;
    static int count;
    static int row1;
    static int column1;
  public static void main(String[] args){
      count=-1;
      row1=-1;
      column1=-1;
      do{ 
          System.out.println("HELLO, WELCOME TO INDIAN RAILWAYS:");
          System.out.println("1.Admin");
          System.out.println("2.Passenger");
          System.out.println("3.Exit");
          System.out.println("Enter your Choice:");
           choice=sc.nextInt();
          switch(choice){
              case 1:
              admin();
              break;
              case 2:
              passenger();
              break;
              case 3:
              break;

          }

      }while(choice!=3);
  }
  static void admin(){
      System.out.println("Please Enter your Username:");
      String name=sc.next();
      System.out.println("Please Enter your Password:");
      String Password=sc.next();
      if(name.equals("sakthivel") && Password.equals("123456")){
           do{
               System.out.println("WELCOME ADMIN:");
               System.out.println("1.Add Trains");
               System.out.println("2.Check Seat Availablity");
               System.out.println("3.Exit");
               System.out.println("Please enter your choice:");
               ch=sc.nextInt();
               switch(ch){
                   case 1:
                    addtrains();
                    break;
                   case 2:
                    checkseat();
                    break;
                  case 3:
                    break;
               }
           }while(ch!=3);
      }
  }
  static void addtrains(){
      System.out.println("Enter the name of the Train:");
      String trainname=sc.next();
      train.add(trainname);
      System.out.println("Enter the  number of seats you want in your Train:");
      seat=sc.nextInt();
      System.out.println("Enter the  number of Cities your train want to travel:");
      city=sc.nextInt();
      for(int i=0;i<city;i++){
          String city1=sc.next();
          brr.add(city1);
      }
       arr= new int[seat][city];
      

  }
  static void checkseat(){
      for(int i=0;i<seat;i++){
          for(int j=0;j<city;j++){
              System.out.print(arr[i][j]+" ");
          }
          System.out.println();
      }
  }
  static  void passenger(){
      System.out.println("Hello Passenger-Welcome to Indian Railways:");
      System.out.println("Please enter your Username:");
      String username=sc.next();
      System.out.println("Please enter your Password:-");
      String userpassword=sc.next();
      if(username.equals("sakthivel") && userpassword.equals("123456")){
          do{
              System.out.println("Welcome User");
              System.out.println("1.Display Trains:");
              System.out.println("2.Check Seats:");
              System.out.println("3.Book Seats:");
              System.out.println("4.Display My Seat:");
              System.out.println("5.Exit");
              System.out.println("Please  Enter your option:");
               opt=sc.nextInt();
              switch(opt){
                  case 1:
                  for(int i=0;i<train.size();i++){
                      System.out.println(train.get(i));
                  }
                  break;
                  case 2:
                  for(int i=0;i<seat;i++){
                    for(int j=0;j<city;j++){
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println();
                }
                  break;
                case 3:
                 bookseat();
                 break;
                case 4:
                 //displaymyseat();
                 break;
                case 5:
                 break;
              }
          }while(opt!=5);
      }
  }
  static void bookseat(){
    
      for(int i=0;i<brr.size();i++){
          System.out.println(brr.get(i));
      }
      System.out.println("Enter the Starting point of the travel:");
      String start=sc.next();
      System.out.println("Enter the Ending point of the travel:");
      String end=sc.next();
      start1=brr.indexOf(start);
      end1=brr.indexOf(end);
      int flag=0;
      for(int i=0;i<20;i++){
          for(int j=start1;j<end1;j++){
              if(arr[i][j]==0){
                    flag=1;
                    
              }
              else{
                   flag=0;
                   break;
             }

          }
          if(flag==1){
              System.out.println("YOU BOOK SEAT NO : "+i);
              for(int k=start1;k<end1;k++){
                  arr[i][k]=1;
              }
              break;
          }
      }
    }}
