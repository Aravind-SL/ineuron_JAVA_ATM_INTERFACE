import java.util.Scanner;

public class Atm {

    Scanner sc = new Scanner(System.in);
    static String PH_NO_PATTERN = "^[0-9]{10}$";
    static String USER_ID_PATTERN = "^[0-9]{4}$";
    static String PIN_PATTERN = "^[0-9]{4}$";
    static AccountHolder ah = new AccountHolder();
    static BankData bd = new BankData();

    public void signUp(){
        String l_name, ph_no;
        int age, pin, userid, balance=0;
        System.out.println("Thank you for choosing our bank to create your account.");
        System.out.println("Please enter all of the following details to create a account.");
        System.out.println("Enter your first name: ");
        String f_name = sc.nextLine();
        System.out.println("Enter your last name: ");
        l_name = sc.nextLine();
        System.out.println("Enter your age: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your userid: ");
        userid = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your pin: ");
        pin = Integer.parseInt(sc.nextLine());
        do{
            System.out.println("Enter your phone number(should be 10 digits): ");
            ph_no = sc.nextLine();
        }while(!ph_no.matches(PH_NO_PATTERN));
        ah.addAccount(f_name, l_name, age, userid, pin, ph_no, balance);
        bd.writeAccount(f_name, l_name, age, userid, pin, ph_no);
    }

    public void login(){
        int userid, pin;
        int tries=0;
        boolean success;
        do{
            if (tries>3){
                System.out.println("You have reached maximum amount of tries try again later.");
                return ;   
            }
            System.out.print("Enter your User id: ");
            userid = Integer.parseInt(sc.nextLine());
            System.out.println("Enter your Pin: ");
            pin = Integer.parseInt(sc.nextLine());
            success = ah.checkAccount(userid, pin);
            tries ++;
        }while(!success);
        this.operations(userid, pin);
    }

    public void operations(int userid, int pin){
        int choice;
        int amount;
        Account object = new Account();
        Bank account = new Bank();
        account = ah.getAccount(userid);
        System.out.println(  " Welcome " + account.getName());
        System.out.println("---------------------------------");
        do{
            System.out.println("1.Deposit\t4.Transaction History");
            System.out.println("2.Withdraw\t5.Show Balance");
            System.out.println("3.Transfer\t6.Exit");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    amount = Integer.parseInt(sc.nextLine());
                    object.deposit(amount, account); 
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    amount = Integer.parseInt(sc.nextLine());
                    object.withdraw(amount, account);
                    break;
                case 3:
                    int ref_id;
                    System.out.println("Enter account to transfer: ");
                    ref_id = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter amount to transfer: ");
                    amount = Integer.parseInt(sc.nextLine());
                    object.transfer(amount, ref_id, account);
                    break;
                case 4:
                    object.transactionHistory(account);
                    break;
                case 5:
                    int balance = object.showBalance(account);
                    System.out.println("Balance : " + balance);
                case 6:
                    System.out.println("Thank you for accessing.");
                    break;
                default:
                    System.out.println("Enter a valid option.");
                    break;
            }
        }while(choice!=6);
    }

}