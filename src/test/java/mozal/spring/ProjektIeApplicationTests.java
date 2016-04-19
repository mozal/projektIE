package mozal.spring;

import mozal.spring.entities.Post;
import mozal.spring.entities.User;
import mozal.spring.services.DataBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjektIeApplication.class)
@WebAppConfiguration
public class ProjektIeApplicationTests {

    @Autowired
    private DataBaseService dataBaseService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void DBtest() {
        User user = new User();
        user.setName("Andrzej");
        user.setSurname("Kowalski");
        String email = "musial123@onet.pl";
        user.setEmail(email);

        Post post = new Post();
        post.setTekst("siema ziom co tam");
        post.setTitle("DZIALAJ PLEASE!");

        Post post1 = new Post();
        post1.setTekst("siema ziom co tam jeste 2");
        post1.setTitle("Drugi");

        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post1);

        user.setPosts(posts);

        dataBaseService.saveUser(user);
        User user2 = null;
        user2 = dataBaseService.findByEmail(email);
        assertNotNull(user2);

        assertEquals(2, user2.getPosts().size());
        System.out.println(user2.toString());
        System.out.println(user2.getPosts().toString());

    }

}
