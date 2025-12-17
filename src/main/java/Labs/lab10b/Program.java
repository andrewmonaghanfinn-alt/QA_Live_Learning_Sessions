package Labs.lab10b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Program {
    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(100, "Bob", 1000));
        accounts.add(new Account(500, "Linda", 3000));
        accounts.add(new Account(300, "David", 2000));

        accounts.forEach((account) -> System.out.println(account.getDetails()));

        Collections.sort(accounts);

        accounts.forEach((account) -> System.out.println(account.getDetails()));
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

class Account implements Comparable<Account> {
    int id;
    String owner;
    double balance;

    Account(int id, String owner, double balance) {
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

    @Override
    public int compareTo(Account other) {
        return (int)(this.balance - other.balance);
    }
}



