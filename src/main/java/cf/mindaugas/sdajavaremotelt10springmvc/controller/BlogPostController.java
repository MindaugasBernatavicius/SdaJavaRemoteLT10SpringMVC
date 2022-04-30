package cf.mindaugas.sdajavaremotelt10springmvc.controller;

import cf.mindaugas.sdajavaremotelt10springmvc.model.BlogPost;
import cf.mindaugas.sdajavaremotelt10springmvc.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BlogPostController {
    @Autowired
    private BlogPostRepository bpr;

    @GetMapping(path = "/posts")
    public String getAllPosts(Model model, BlogPost blogPost){
        model.addAttribute("posts", bpr.getAllBlogPosts());
        return "posts";
    }

    @PostMapping(path = "/posts/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //public String createPost(
    //        @RequestParam("author_ssn") Integer id,
    //        @RequestParam("author") String author,
    //        @RequestParam(value = "post") String post
    //){
    //    bpr.addBlogPost(new BlogPost(id, author, post));
     public String createPost(Model model, @Valid BlogPost blogPost, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("posts", bpr.getAllBlogPosts()); // Add this for table not to be empty
            return "posts";
        }
        bpr.addBlogPost(blogPost);
        return "redirect:/posts";

        // bad way to handle HTTP Post action
        // model.addAttribute("posts", bpr.getAllBlogPosts());
        // return "posts";
    }

    @GetMapping(path="/posts/delete/{id}")
    public String deleteById(Model model, @PathVariable Integer id){
        bpr.deleteById(id);
        // http://localhost/posts/delete/35511566
        // model.addAttribute("posts", bpr.getAllBlogPosts());
        // return "posts";
        return "redirect:/posts";
    }
}
