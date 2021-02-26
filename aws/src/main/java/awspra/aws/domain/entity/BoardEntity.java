package awspra.aws.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
// 디폴트 생성자 추가
@Getter
// 모든 필드에 getter 자동생성, getter와 setter 모두 해결해주는 Data도 있음
@Entity
// 객체를 테이블과 매핑할 엔티티라고 jpa에 알려주는 역할
@Table
// 테이블 정보 명시
public class BoardEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @Builder
    public BoardEntity(Long id, String writer, String title, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
