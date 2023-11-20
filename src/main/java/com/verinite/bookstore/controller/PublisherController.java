package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Publisher;
import com.verinite.bookstore.serviceimpl.PublisherServiceImpl;
@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    PublisherServiceImpl service;

    //Method for get mapping to retrieve all data from table
    @GetMapping("/getAllPublishers")
    public List<Publisher> getAllPublishers()
    {
        return service.getAllPublishers();
    }

    //Method for get mapping to retrieve a particular record from table
    @GetMapping("/getPublisher/{publisherId}")
    public Object getOnePublisher(@PathVariable int publisherId)
    {
        return service.getPublisherById(publisherId);
    }

    //Method for post mapping to store a data in table
    @PostMapping("/savePublishers")
    public Publisher instertIntoDb(@RequestBody Publisher publisher)
    {
        return service.savePublisher(publisher);
    }

    //Method for delete mapping
    @DeleteMapping("/deletePublishers/{publisherId}")
    public String deletePublisher(@PathVariable int publisherId)
    {
        return service.deletePublisher(publisherId);
    }

    //Method for Put mapping
    @PutMapping("/updatePublishers/{publisherId}")
    public Object updateByPutMapping(@RequestBody Publisher publisher,@PathVariable int publisherId)
    {
        return service.fullUpdate(publisherId,publisher);
    }

    //Method for patch mapping
    @PatchMapping("/updatePublishers/{publisherId}")
    public Object updateByPatch(@RequestBody Publisher publisher,@PathVariable int publisherId )
    {
        return service.partialUpdate(publisherId,publisher);
    }

}
