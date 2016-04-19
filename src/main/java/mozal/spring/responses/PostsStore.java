package mozal.spring.responses;

import mozal.spring.entities.Post;

import java.util.List;

/**
 * Created by Monika on 2016-04-13.
 */
public class PostsStore {
    private String userName = null;
    private List<Post> posts = null;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "PostsStore{" +
                "userName='" + userName + '\'' +
                ", posts=" + posts.toString() +
                '}';
    }
}
