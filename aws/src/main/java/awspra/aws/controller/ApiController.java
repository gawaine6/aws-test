package awspra.aws.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor

public class ApiController {

    @GetMapping("/")
    public String main() {
        return "main";
    }
}
