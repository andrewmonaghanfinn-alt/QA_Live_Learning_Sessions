package Labs.lab02;

public class Program {
    public static void main(String[] args) {

//        Account a1 = new Account(23, "Michael Jordan", 127123.24);
//        a1.Deposit(19783.00);
//        System.out.println(a1.getDetails());
//        a1.Withdraw(74238443);
//        System.out.println(a1.getDetails());
//
//
//        Account[] bank = {a1, new Account(24, "Sam Green", 2379.28), new Account(25, "Ellen Jenkins", 97832.40)};
//
//        for (Account account : bank) {
//            System.out.println(account.getDetails());
//        }


        Account myAccount = new Account(1, "Jeff", 100.00);



       myAccount.addInterest();
        System.out.println(myAccount.getDetails());

        Account partnerAccount = myAccount;
        partnerAccount.addInterest();
        System.out.println(myAccount.getDetails());

        processAccount(myAccount);
        System.out.println(myAccount.getDetails());

        int k = 100;

        incInt(k);

        System.out.println(k);


    }

    static void processAccount(Account acc){
        acc.addInterest();
    }

    private static void incInt(int x){
        x++;
    }


}


class Account {
    int id;
    String owner;
    double balance;

    Account(int id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    String getDetails() {
        return "Account ID: " + id  +"\n" +
                "Account name: " + owner + "\n" +
                "Account balance: " + balance;
    }




    void Deposit(double amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit a negative sum");
        } else {
            balance += amount;
        }
    }

    void Withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Cannot withdraw a negative sum");
        } else if (amount > balance) {

        } else {
            balance -= amount;
        }
    }

    public void addInterest() {
        balance += balance * 0.025;
    }
}