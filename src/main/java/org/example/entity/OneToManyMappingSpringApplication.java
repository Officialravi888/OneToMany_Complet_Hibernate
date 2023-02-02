package org.example.entity;
import org.example.entity.repoestory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyMappingSpringApplication implements CommandLineRunner {
    public static void main(String[] args) {

        SpringApplication.run(OneToManyMappingSpringApplication.class, args);
    }
@Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        Post post= new Post("one to manny", "description");
        Comment comment1=new Comment("very use");
        Comment comment2=new Comment("very ");
        Comment comment3=new Comment("very hh");
        post.getComments().add(comment1);
        post.getComments().add(comment2);
        post.getComments().add(comment3 );
        this.postRepository.save(post);

    }
}
