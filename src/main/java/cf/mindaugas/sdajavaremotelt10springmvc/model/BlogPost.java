package cf.mindaugas.sdajavaremotelt10springmvc.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class BlogPost {
    private int id;
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-z]+$", message = "Must match pattern: ^[A-Z]{1}[a-z]+$")
    private String author;
    private String post;

    public BlogPost() {}

    public BlogPost(int id, String author, String post) {
        this.id = id;
        this.author = author;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
