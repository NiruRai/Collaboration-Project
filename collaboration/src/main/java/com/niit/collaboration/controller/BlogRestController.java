package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.BlogDao;
import com.niit.collaboration.model.Blog;


@RestController
public class BlogRestController {
	

    @Autowired
    BlogDao blogDao;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Blogs--------------------------------------------------------
     
    @RequestMapping(value = "/BlogDetails/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllBlogs() {
        List<Blog> bloglist = blogDao.bloglist();
        if(bloglist.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(bloglist, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Blog--------------------------------------------------------
     
    @RequestMapping(value = "/BlogDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
        System.out.println("Fetching Blog with id " + id);
        Blog blog = blogDao.getblogById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Blog--------------------------------------------------------
     
    @RequestMapping(value = "/BlogDetails/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating blog " + blog.getBlogTitle());
 
        if (blogDao.isBlogExist(blog)) {
            System.out.println("A Blog with name " + blog.getBlogTitle() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        blogDao.saveOrUpdate(blog);;
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/BlogDetails/{id}").buildAndExpand(blog.getBlogId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Blog --------------------------------------------------------
     
    @RequestMapping(value = "/BlogDetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") int id, @RequestBody Blog blog) {
        System.out.println("Updating Blog " + id);
         
        Blog currentBlog = blogDao.getblogById(id);
         
        if (currentBlog==null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
 
                
        blogDao.saveOrUpdate(currentBlog);;
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Blog --------------------------------------------------------
     
    @RequestMapping(value = "/BlogDetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Blog with id " + id);
 
        Blog blog = blogDao.getblogById(id);
        if (blog == null) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
 
        blogDao.delete(id);;
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
 
     

}
