package awspra.aws.controller;

import awspra.aws.dto.BoardDto;
import awspra.aws.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
// 컨트롤러 명시, RestController도 있는데 controller + responsebody
@AllArgsConstructor
// 클래스에 존재하는 모든 필드에 대한 생성자 자동 생성
public class BoardController {

    private BoardService boardService;

    @GetMapping("/board")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }
}
