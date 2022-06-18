package com.example.FirstProject.dto;

import com.example.FirstProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

// Form데이터를 받을 그릇

//Refactoring
@AllArgsConstructor
@ToString
public class ArticleForm {

        private String title;
        private String content;

        public Article toEntity() {
                return new Article(null, title, content);
        }
}
