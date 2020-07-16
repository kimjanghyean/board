package me.heumsi.samplewebpage.articles;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticlesServiceTest {
	
	@Autowired
	ArticlesService articlesService;
	
	
	  @Test
	    public void getArticles() {
	        Article article = new Article();
	        article.setContent("test");

	        articlesService.insertArticle(article);
	       
	    }
	}

	
	
