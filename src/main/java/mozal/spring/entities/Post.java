package mozal.spring.entities;

import javax.persistence.Entity;

/**
 * Created by Monika on 2016-04-13.
 */
@Entity
public class Post extends AbstractEntity {
    private String tekst;
    private String title;

    public Post(String tekst, String title) {
        this.tekst = tekst;
        this.title = title;
    }

    public Post() {
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "tekst='" + tekst + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
