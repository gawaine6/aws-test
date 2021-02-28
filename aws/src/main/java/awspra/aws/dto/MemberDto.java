package awspra.aws.dto;

import awspra.aws.domain.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class MemberDto {
    private Long memberNo;
    private String memberId;
    private String password;
    private String memberName;

    public MemberEntity toEntity() {
        MemberEntity memberEntity = MemberEntity.builder()
                .memberNo(memberNo)
                .memberId(memberId)
                .memberName(memberName)
                .password(password)
                .build();
        return memberEntity;
    }

    @Builder
    public MemberDto(Long memberNo, String memberId, String memberName, String password) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberName = memberName;
        this.password = password;
    }
}
