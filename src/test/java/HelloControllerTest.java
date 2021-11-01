import helback.api.HelloController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {

    @Test
    public void getHelloMessage() throws Exception {
        HelloController hello = new HelloController(); //Arrange
        String response = hello.getHelloMessage("Peter"); //Act

        assertEquals("Hello, Peter", response);
    }
}