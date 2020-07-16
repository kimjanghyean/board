package me.heumsi.samplewebpage.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    // articles 뷰를 보여줌.
    @GetMapping("/articles")
    public String getArticles(Model model) {
        return "page/articles";
    }

    // page 의 size 만큼 Article 리스트를 Json 으로 리턴함.
    @GetMapping("/articles/list")
    public @ResponseBody
    List<Article> getArticles(@RequestParam Integer page, @RequestParam Integer size) {
        return articlesService.getArticles(page, size);
    }

    // id 에 해당하는 article detail 뷰를 보여줌.
    @GetMapping("/article-detail/{id}")
    public String getArticleDetail(@PathVariable(value = "id") Long id, Model model) {
        Article article = articlesService.getArticle(id);
        model.addAttribute("article", article);
        return "page/article_detail";
    }

    // id 에 해당하는 article 을 삭제함.
    @DeleteMapping("/article-detail/{id}")
    public void deleteArticle(@PathVariable(value = "id") Long id) {
        articlesService.deleteArticle(id);
    }

    // id 에 해당하는 article 을 수정하는 뷰를 보여줌.
    @GetMapping("/article-edit/{id}")
    public String getArticleEdit(@PathVariable(value = "id") Long id, Model model) {
        Article article = articlesService.getArticle(id);

        model.addAttribute("article", article);
        model.addAttribute("is_update", true);
        return "page/article_edit";
    }

    // id 에 해당하는 article 을 업데이트 함.
    @PutMapping("/article-edit/{id}")
    public @ResponseBody
    Article putUpdateArticle(@PathVariable(value = "id") Long id, @RequestBody Article article) {
        return articlesService.updateArticle(id, article);
    }

    // 새로운 article 을 만드는 뷰를 보여줌.
    @GetMapping("/article-edit")
    public String getArticleEdit(Model model) {
        model.addAttribute("is_update", false);
        return "page/article_edit";
    }

    // 새로운 article 을 만듬.
    @PostMapping("/article-edit")
    public @ResponseBody
    Article postNewArticle(@RequestBody Article article) {
        return articlesService.insertArticle(article);
    }
}
