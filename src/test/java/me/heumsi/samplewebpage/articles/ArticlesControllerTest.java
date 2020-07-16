package me.heumsi.samplewebpage.articles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import me.heumsi.samplewebpage.about.AboutService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticlesController.class)
public class ArticlesControllerTest {

    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    ArticlesService articleService;

    /** GET /articles 요청에 대한 테스트
     * 응답하는 뷰 템플릿이 page/articles 이어야 합니다.
     **/
    @Test
    public void getArticles() throws Exception {
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(view().name("page/articles"));
    }

    /** GET /article-detail 요청에 대한 테스트
     * 응답하는 뷰 템플릿이 page/article_detail 이어야 합니다.
     **/
 
    /** GET /article-edit 요청에 대한 테스트
     * 응답하는 뷰 템플릿이 page/article_edit 이어야 합니다.
     **/
    @Test
    public void getArticleEdit() throws Exception {
        mockMvc.perform(get("/article-edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("page/article_edit"));
    }
}
