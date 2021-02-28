package awspra.aws.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor

public class ApiController {

    private BoardController boardController;
    private MemberController memberController;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/board")
    public String board() {
        return "/board/list.html";
    }

    @GetMapping("/member")
    public String member_list() {
        return "/member/member_list.html";
    }

}
