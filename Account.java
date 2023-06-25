public class Account {
    static BankData bd = new BankData();
    static AccountHolder ah = new AccountHolder();
    public void deposit(int amount, Bank account){
        account.addBalance(amount);
        System.out.println("₹." + amount + " Deposited Sucessfully.");
        System.out.println("Updated Balance: ₹." + account.getBalance());
        bd.updateCustomer();
    }

    public void withdraw(int amount, Bank account){
        boolean success;
        success = account.reduceBalance(amount);
        if(success){
            System.out.println("₹." + amount + " Withdrawn Sucessfully.");
            System.out.println("Updated Balance: ₹." + account.getBalance());
            bd.updateCustomer();
        }
        else{
            System.out.println("Insufficient Balance.");
            System.out.println("Balance : ₹." + account.getBalance());
        }
    }

    public void transfer(int amount, int ref_id, Bank account){
        boolean result;
        result = ah.checkAccount(ref_id);

        if (result && account.getBalance() > amount){
            Bank ref_account = new Bank();
            ref_account = ah.getAccount(ref_id);
            account.transfer(amount, ref_account);
            System.out.println("₹." + amount + " Transferred Sucessfully.");
            System.out.println("Updated Balance: ₹." + account.getBalance());
            bd.updateCustomer();
        }
        else{
            System.out.println("Transaction Unsucessfull");
            System.out.println("Balance: ₹. " + account.getBalance());
        }
        
    }

    public void transactionHistory(Bank account){
        account.showTransaction();
    }

    public int showBalance(Bank account){
        return account.getBalance();
    }
}
