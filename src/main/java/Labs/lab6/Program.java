package Labs.lab6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {

        Account account01 = new Account(1, 100.00, "Bobert");

        try {
            account01.withdraw(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Transaction failed: " + e.getMessage());
            try {
                log(e.getMessage());
            } catch (IOException ex) {
                System.out.println(e.getMessage());
            }
        } finally {
            account01 = null;
        }


    }



    private static void log(String msg) throws IOException {
        File file = new File("log.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(msg + "\r\n");
        br.close();
        fr.close();
    }
}

class Account {
    int id;
    double balance;
    String owner;

    Account(int id, double balance, String owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    void withdraw(double amount) {
        if (balance <= 0) {
            throw new IllegalArgumentException("account does not have overdraft");
        }
        if (balance - amount < 0) {
            throw new IllegalArgumentException("withdrawal amount exceeds balance");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("cannot withdraw negative sum");
        }
        //i thought i would need an else clause, but apparently the thrown exception
        //exits the block immediately
        balance -= amount;
    }

    void deposit(double amount) {
        balance += amount;
    }

    String getDetails() {
        return "ID: " + id + "\n" +
                "Balance: " + balance + "\n" +
                "Owner: " + owner;
    }
}



