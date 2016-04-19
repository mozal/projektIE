package mozal.spring.services;

import mozal.spring.entities.Post;
import mozal.spring.entities.User;
import mozal.spring.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monika on 2016-04-11.
 */

@Service
@Transactional //uprawnienia do wykonywania transakcji (?)
public class DataBaseService {
    @Autowired
    private UserRep userRep;

    @PostConstruct
    public void Init() //do niej odwl. sie kontrolery zeby wykonac operacje na bazie danych
    {
        User uno = new User();
        String email = "huehue@aha.pl";
        uno.setEmail(email);
        uno.setName("Andrzej");
        uno.setSurname("Janusz");
        uno.setPassword("ahahhaah");

        Post post = new Post();
        post.setTekst("siema ziom co tam");
        post.setTitle("DZIALAJ PLEASE!");

        Post post1 = new Post();
        post1.setTekst("siema ziom co tam jeste 2");
        post1.setTitle("Drugi");

        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post1);

        uno.setPosts(posts);

        userRep.save(uno);
        User dos = null;
        dos = userRep.findByEmail(email);
        System.out.println(dos.toString());
    }

    public User findById(long id) {
        return userRep.findOne(id);
    }

    public User findByEmail(String email) {
        return userRep.findByEmail(email);
    }

    public User saveUser(User user) {
        return userRep.save(user);
    }

}
