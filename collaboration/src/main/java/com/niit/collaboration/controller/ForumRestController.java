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

import com.niit.collaboration.dao.ForumDao;
import com.niit.collaboration.model.Forum;

@RestController
public class ForumRestController {
	

    @Autowired
    ForumDao forumDao;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Blogs--------------------------------------------------------
     
    @RequestMapping(value = "/ForumDetails/", method = RequestMethod.GET)
    public ResponseEntity<List<Forum>> listAllForums() {
        List<Forum> forumList = forumDao.forumlist();
        if(forumList.isEmpty()){
            return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Forum>>(forumList, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Forum--------------------------------------------------------
     
    @RequestMapping(value = "/ForumDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Forum> getForum(@PathVariable("id") int id) {
        System.out.println("Fetching Forum with id " + id);
        Forum forum = forumDao.getforumById(id);
        if (forum == null) {
            System.out.println("forum with id " + id + " not found");
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Forum>(forum, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Forum--------------------------------------------------------
     
    @RequestMapping(value = "/ForumDetails/", method = RequestMethod.POST)
    public ResponseEntity<Void> createForum(@RequestBody Forum forum,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating blog " + forum.getForumTitle());
 
        if (forumDao.isForumExist(forum)) {
            System.out.println("A Blog with name " + forum.getForumTitle() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        forumDao.saveOrUpdate(forum);;
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Forum/{id}").buildAndExpand(forum.getForumId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Forum --------------------------------------------------------
     
    @RequestMapping(value = "/ForumDetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Forum> updateForum(@PathVariable("id") int id, @RequestBody Forum forum) {
        System.out.println("Updating Forum " + id);
         
        Forum currentForum = forumDao.getforumById(id);
         
        if (currentForum==null) {
            System.out.println("Forum with id " + id + " not found");
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
 
                
        forumDao.saveOrUpdate(currentForum);;
        return new ResponseEntity<Forum>(currentForum, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Forum --------------------------------------------------------
     
    @RequestMapping(value = "/ForumDetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Forum> deleteForum(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Forum with id " + id);
 
        Forum forum = forumDao.getforumById(id);
        if (forum == null) {
            System.out.println("Unable to delete. forum with id " + id + " not found");
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
 
        forumDao.delete(id);;
        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
    }
 
     

}
