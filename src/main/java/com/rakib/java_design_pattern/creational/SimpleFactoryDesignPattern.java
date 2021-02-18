//simple factory ---> Provides a Static method to get a instance of product subclass
//its help to get instance which instance i need from multiple implementation of a abstract class or interface
//Like---> simple-factory from product interface from productA and productB impl

package com.rakib.java_design_pattern.creational;

import lombok.*;

import java.time.Instant;

@Data
abstract class Post{
    private int id;
    private String content;
    private String createdOn;
    private String publishedOn;
}
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class NewsPost extends Post{
    private String newsTitle;
    private Instant newsTime;
}
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BlogPost extends Post{
    private String blogTitle;
    private Instant postTime;
}
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ProductPost extends Post{
    private String productName;
    private String imageURL;
}

class PostFactory{
    public static Post createPost(String type){
        switch (type){
            case "blog":
                return new BlogPost();
            case "news":
                return new NewsPost();
            case "product":
                return new ProductPost();
            default:
                throw new IllegalArgumentException("Not Valid Type");
        }
    }
}
public class SimpleFactoryDesignPattern {
    public static void main(String[] args) {
        Post post = PostFactory.createPost("news");
        System.out.println(post);
        Post post1 = PostFactory.createPost("blog");
        System.out.println(post1);
        Post post2 = PostFactory.createPost("product");
        System.out.println(post2);
        Post post3 = PostFactory.createPost("some_else");
        System.out.println(post3);

    }
}
