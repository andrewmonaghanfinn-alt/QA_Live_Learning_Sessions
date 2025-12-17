package Labs.lab14;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class JSONReader {
    public static List<Customer> readCustomers(String filePath)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath),
                new TypeReference<List<Customer>>() {
                });
    }
}