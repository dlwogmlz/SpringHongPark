package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


// CrudRepository -> create, read, update, delete를 추가코드 구현없이 extends 확장받아서 사용할수 있게 된다.
public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();
}
