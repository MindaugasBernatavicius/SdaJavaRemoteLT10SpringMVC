package cf.mindaugas.sdajavaremotelt10springmvc.repository;

import cf.mindaugas.sdajavaremotelt10springmvc.model.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogPostRepository {
    private List<BlogPost> posts = new ArrayList<>(){{
        add(new BlogPost(35511125, "Mindaugas", "Post 1"));
        add(new BlogPost(35511566, "Kazys", "Post 2"));
        BlogPost bp3 = new BlogPost();
        bp3.setId(36511566);
        bp3.setAuthor("Pranas");
        bp3.setPost("Post3");
        add(bp3);
    }};

    public List<BlogPost> getAllBlogPosts(){
        return this.posts;
    }

    public void addBlogPost(BlogPost blogpost){
        this.posts.add(blogpost);
    }

    public void deleteById(Integer id) {
        var blogPostToDelete = posts.stream()
                .filter(blogPost -> blogPost.getId() == id)
                .findFirst()
                .get();
        this.posts.remove(blogPostToDelete);
    }
}
