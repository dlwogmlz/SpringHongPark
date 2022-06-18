package com.example.FirstProject.Controller;

import com.example.FirstProject.dto.ArticleForm;
import com.example.FirstProject.entity.Article;
import com.example.FirstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j // 로깅을 위한 골뱅이(어노테이션)
public class ArticleController {

    // 객체 주입하기(DI)
    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 자동 연결시켜준다.
    private ArticleRepository articleRepository;

    // @GetMapping으로 브라우저에서 접속하는 url주소를 연결한다.
    @GetMapping("/articles/new")
    public String newArticleForm() {
        // view 페이지 연결
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        log.info(form.toString());

        // System.out.println(form.toString()); → 로깅기능으로 대체

        // 1. DTO(form data)를 Entity로 변환!
        // form데이터를 toEntity메서드로 받아서 article에 저장
        Article article = form.toEntity();

        log.info(article.toString());
        // System.out.println(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);

        log.info(saved.toString());
        // System.out.println(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    // @PathVariable : url주소는 path로부터 입력이된다.
    public String show(@PathVariable Long id, Model model) { // Model을 사용하기 위해서 파라미터로 Model를 넣어준다.
        log.info("id = " + id);
        
        // 1. id로 데이터를 가져옴
        // id값을 통해서 찾았는데 만약에 해당 id가없으면 null을 반환해라
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 가져온 데이터를 모델이 등록!!, 위에서 만든 articleEntity 데이터를 모델이 등록해야한다.
        // 왜? view페이지에서 사용하기 위해서!!
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지를 설정!!
        return "articles/show"; // articles라는 디렉터리 안에 show라는 mustache를 만들어준다.
    }

    @GetMapping("/articles")
    public String index(Model model) {

        // 1. 모든 Article를 가져온다. repository가 필요하다
        // 첫번쨰. List<Article> articleEntityList = (List<Article>) articleRepository.findAll();
        // Iterable<Article> articleEntityList = articleRepository.findAll();
        List<Article> articleEntityList = articleRepository.findAll();

        // 2. 가져온 Article 묶음을 뷰로 전달! 모델을 사용한다.
        model.addAttribute("articleList", articleEntityList);

        // 3. 뷰 페이지를 설정!
        return "articles/index"; // articles/index.mustache
    }
}
