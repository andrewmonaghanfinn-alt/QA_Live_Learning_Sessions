package Labs.lab14;

import java.io.IOException;
import java.util.List;

public class Program {
    public static void main(String[] args)
    {
        String jsonFile = "C:\\Users\\fandrewmonaghan\\QA_Live_Learning_Labs\\Week_1\\src\\main\\java\\Labs\\lab14\\customers.json";

        try
        {
            // Read the JSON file
            List<Customer> customers = JSONReader.readCustomers(jsonFile);

            // Filter customers by city
            String targetCurrency = "Euro";
            List<Customer> filteredCustomers =
                    CustomerFilter.filterByCurrency(customers, targetCurrency);

            // Display the filtered customers
            System.out.println("Customers who use " + targetCurrency + ":");
            filteredCustomers.forEach(customer->
                    System.out.println(customer.getName() + " (Capital city: " + customer.getCapital() + ")")
            );
        }
        catch (IOException e)
        {
            System.err.println("Error reading the JSON file: " + e.getMessage());
        }
    }

}

