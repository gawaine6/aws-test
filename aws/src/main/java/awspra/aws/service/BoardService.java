package awspra.aws.service;

import awspra.aws.domain.entity.BoardEntity;
import awspra.aws.domain.repository.BoardRepository;
import awspra.aws.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> getBoardList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
    // BoardEntity 에 있는 값들 전부 찾아온다
        List<BoardDto> boardDtoList = new ArrayList<>();
    // BoardList 를 새로운 ArrayList로 선언하고 보드엔티티에 있는 속성들을 다 집어넣어준다
        for(BoardEntity boardEntity : boardEntities) {
            BoardDto boardDto = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .modifiedDate(boardEntity.getModifiedDate())
                    .build();
            boardDtoList.add(boardDto);
    // 보드 디티오에 있는 속성들을 전부 보드 리스트에 넣어준다
        }
        return boardDtoList;
    // 보드 리스트 반환
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
