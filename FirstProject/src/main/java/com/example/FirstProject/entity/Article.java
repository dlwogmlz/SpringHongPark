package com.example.FirstProject.entity;

// DB에서 Article클래스를 인식을 하게 해주려면 @Entity를 써줘야한다.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식가능!
@NoArgsConstructor // default생성자를 추가!!
@AllArgsConstructor // 모든 필드에 있는 생성자를 만들어준다.
@ToString
@Getter
public class Article {
    
    /* Entity클래스를 생성해줌 */
    
    // 기본적으로 Entity에는 대표값을 넣어줘야한다, ex) 주민등록번호
    @Id
    @GeneratedValue // 자동생성하기 위한 어노테이션, 1,2,3 자동생성된다.
    private Long id;

    @Column // DB에서 이해할수 있게! @Column를 써줘야한다.
    private String title;
    @Column
    private String content;



    // default생성자 - 생성자인데 파라미터가 없는 생성자
//    Article () {
//
//    }

}
