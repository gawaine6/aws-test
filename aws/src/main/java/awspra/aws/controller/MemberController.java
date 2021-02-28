package awspra.aws.controller;

import awspra.aws.dto.MemberDto;
import awspra.aws.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor

public class MemberController {

    private MemberService memberService;

    @GetMapping("/member")
    public String member(Model model) {
        List<MemberDto> memberList = memberService.getMemberList();
        model.addAttribute("memberList", memberList);
        return "member/member_list.html";
    }

    @GetMapping("/join")
    public String join() {
        return "member/member_join.html";
    }

    @PostMapping("/join")
    public String join(MemberDto memberDto) {
        memberService.saveMember(memberDto);

        return "redirect:/member";
    }
}
