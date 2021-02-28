package awspra.aws.service;

import awspra.aws.domain.entity.MemberEntity;
import awspra.aws.domain.repository.MemberRepository;
import awspra.aws.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Transactional
    public List<MemberDto> getMemberList() {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        List<MemberDto> memberDtoList = new ArrayList<>();

        for(MemberEntity memberEntity : memberEntities) {
            MemberDto memberDto = MemberDto.builder()
                    .memberNo(memberEntity.getMemberNo())
                    .memberId(memberEntity.getMemberId())
                    .memberName(memberEntity.getMemberName())
                    .password(memberEntity.getPassword())
                    .build();
            memberDtoList.add(memberDto);
        }
        return memberDtoList;
    }

    @Transactional
    public Long saveMember(MemberDto memberDto) {
        return memberRepository.save(memberDto.toEntity()).getMemberNo();
    }
}
