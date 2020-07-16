package me.heumsi.samplewebpage.articles;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticlesRepositoryTest {
	
	@Autowired
	ArticlesRepository articlesRepository;
	
	
	@Test
	public void di() {
		Article article = new  Article();
		article.setContent("test");
		
		Article newArticle = articlesRepository.save(article);
	        assertThat(newArticle).isNotNull();
		
	}
	
	

}
