package awspra.aws.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberNo;

    @Column(length = 30, nullable = false)
    private String memberId;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String memberName;

    @Builder
    public MemberEntity(Long memberNo, String memberId, String password, String memberName) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.password = password;
        this.memberName = memberName;
    }
}
