package com.naver.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능 포함시키기
public abstract class BaseTimeEntity { // new BaseTimeEntity() 이건 안 되고 무조건 상속 받아서 써야 함
        // 이 경우에는 Posts 가 entity로서 이걸 상속받겠지
    @CreatedDate // entity가 생성되어 저장될 때 시간이 자동 저장 된다.
    private LocalDateTime createdDate;

    @LastModifiedDate // entity 조회 후 변경할 때 시간이 자동 저장 된다.
    private LocalDateTime modifiedDate;
}
