package Labs.lab14;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerFilter   {
    public static List<Customer> filterByCurrency(List<Customer> customers,
                                              String currency)
    {
        return customers.stream()
                .filter(customer->
                        customer.getCurrency().equalsIgnoreCase(currency))
                .collect(Collectors.toList());
    }
}
