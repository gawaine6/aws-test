package awspra.aws.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// 테이블로 매핑하지않고 자식 클래스에 매핑정보 상속(여기서는 BoardEntity에 상속)
@EntityListeners(AuditingEntityListener.class)
// jpa에 해당 엔티티 auditing 기능 사용 명시
// auditing 기능 : 스프링 데이터 jpa에서 시간에 대해 자동으로 값을 넣어주는 기능, audit를 하면 자동으로 시간을 매핑해서 테이블에 넣어준다
public class TimeEntity {
    @CreatedDate
// 엔티티가 처음 저장될 때 생성일 주입, 이거는 수정 안되니까 속성 넣어줘야됨 안그러면 null로 나오드라
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
