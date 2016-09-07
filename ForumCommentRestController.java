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

import com.niit.collaboration.model.ForumComment;
import com.niit.collaboration.dao.ForumCommentDao;

@RestController
public class ForumCommentRestController {
	
	@Autowired
	ForumCommentDao forumDao;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All forumcomment--------------------------------------------------------
     
    @RequestMapping(value = "/forumcomment/", method = RequestMethod.GET)
    public ResponseEntity<List<ForumComment>> listAllForumComment() {
        List<ForumComment> forumComment = forumDao.forumCommentlist();
        if(forumComment.isEmpty()){
            return new ResponseEntity<List<ForumComment>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ForumComment>>(forumComment, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single forumcomment--------------------------------------------------------
     
    @RequestMapping(value = "/forumcomment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ForumComment> getForumComment(@PathVariable("id") int id) {
        System.out.println("Fetching forumcomment with id " + id);
        ForumComment forumcomment = forumDao.getforumCommentById(id);
        if (forumcomment == null) {
            System.out.println("forumcomment with id " + id + " not found");
            return new ResponseEntity<ForumComment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ForumComment>(forumcomment, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a forumcomment--------------------------------------------------------
     
    @RequestMapping(value = "/forumcomment/", method = RequestMethod.POST)
    public ResponseEntity<Void> createForumComment(@RequestBody ForumComment forumcomment,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating forumcomment " + forumcomment.getfCommentId());
 
      /*  if (forumDao.isUserExist(forumcomment)) {
            System.out.println("A User with name " + forumcomment.getfCommentId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
 
        forumDao.saveOrUpdate(forumcomment);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/forumcomment/{id}").buildAndExpand(forumcomment.getfCommentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ForumComment> updateUser(@PathVariable("id") int id, @RequestBody ForumComment forumcomment) {
        System.out.println("Updating User " + id);
         
        ForumComment currentfcomment = forumDao.getforumCommentById(id);
         
        if (currentfcomment==null) {
            System.out.println("currentfcomment with id " + id + " not found");
            return new ResponseEntity<ForumComment>(HttpStatus.NOT_FOUND);
        }
 
        
         
        forumDao.saveOrUpdate(currentfcomment);;
        return new ResponseEntity<ForumComment>(currentfcomment, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/currentfcomment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ForumComment> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting currentfcomment with id " + id);
 
        ForumComment fcomment = forumDao.getforumCommentById(id);
        if (fcomment == null) {
            System.out.println("Unable to delete. currentfcomment with id " + id + " not found");
            return new ResponseEntity<ForumComment>(HttpStatus.NOT_FOUND);
        }
 
        forumDao.delete(id);;
        return new ResponseEntity<ForumComment>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
   /*  
    @RequestMapping(value = "/forumcomment/", method = RequestMethod.DELETE)
    public ResponseEntity<ForumComment> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        forumDao.deleteAllUsers();
        return new ResponseEntity<ForumComment>(HttpStatus.NO_CONTENT);
    }*/

}
