package com.springboot2.admin.domain.posts;

import com.springboot2.admin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dom4j.swing.XMLTableColumnDefinition;


import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity //테이블과 링크될 클래스, 기본값으로 카멜 케이스 이름을 언더 스커어 네이밍으로 테이블 네임 매칭
        // Entity 클래스에서는  Setter 메소드를 만들지 말 것
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //테이블의 컬럼
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private  String content;
    private String author;

    //빌더 패턴 클래스 생성
    @Builder
    public Posts(String title, String content, String author){
        this.title      = title;
        this.content    = content;
        this.author     = author;

    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }



}
