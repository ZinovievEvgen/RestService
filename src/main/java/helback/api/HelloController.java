package helback.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * REST API (api) - default
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@Api(value = "/", tags = {"Контроллер default"})
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "/")
    public String index() {
        return "<html><body><h2>Unknown Page</h2>"
                + "<div>Please explain or contact administrator</div><body></html>";
    }

    public String getHelloMessage(String name) {
        return String.format("Hello, %s", name);
    }
}
