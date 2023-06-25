import java.util.LinkedList;

public class AccountHolder {
    static LinkedList<Bank> ACCOUNT_HOLDERS = new LinkedList<>();
    void addAccount(String f_name, String l_name, int age, int userid, int pin, String mobile_no, int balance){
        Bank new_account = new Bank(f_name, l_name, age, userid, pin, mobile_no, balance);
        System.out.println("before add");
        ACCOUNT_HOLDERS.add(new_account);
        System.out.println("After add");
    }
    
    boolean checkAccount(int userid, int pin){
        boolean user_flag = false;
        System.out.println("in check account");
        for (Bank account: ACCOUNT_HOLDERS){
            System.out.println(account.getUserId() + " " + userid);
            System.out.println(account.getPin() + " " + pin);
            if(account.getUserId() == userid)
                user_flag = true;
            if(account.getUserId() == userid && account.getPin() == pin){
                return true;
            }
        }
        if (user_flag == true)
            System.out.println("Invalid Password.");
        else
            System.out.println("User id and password doesn't exist try checking the userid and password or create a new account");
        return false;
    }

    boolean checkAccount(int userid){
        for (Bank account: ACCOUNT_HOLDERS){
            if(account.getUserId() == userid){
                return true;
            }
        }
        return false;
    }

    Bank getAccount(int userid){
        for (Bank account: ACCOUNT_HOLDERS){
            if(account.getUserId() == userid){
                //Do something
                return account;
            }
        }
        return null;
    }

}