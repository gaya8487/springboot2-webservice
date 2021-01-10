package com.springboot2.admin.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//DB Layer 접근자. PA에선 Repository라고 부르며인터페이스로 생성
//JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
public interface  PostsRepository  extends  JpaRepository<Posts,Long>{
   //SpringDataJpa에서 제공하지 않는 메소드는 @Query로 작성해서 사용하면 된다
    @Query("SELECT p From Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
