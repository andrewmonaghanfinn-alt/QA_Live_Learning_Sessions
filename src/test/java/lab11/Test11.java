package lab11;
import Labs.lab11.Security;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Test11 {

    @Test
    public void testLoginEmptyUserId() {
        String userId = "", password = "Freddy99";
        Security security = new Security();
        boolean actual = security.login(userId, password);
        boolean expected = false;
        assertEquals(expected, actual);
// assertFalse(actual);   // can also use this assert
    }
        @Test
        public void testInvalidUserId() {
            String userId = "\\^%£", password = "Freddy99";
            Security security = new Security();
            boolean actual = security.login(userId, password);
            boolean expected = false;
            assertEquals(expected, actual);

    }

}
