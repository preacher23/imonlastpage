package com.verinite.bookstore.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Publisher;
import com.verinite.bookstore.repository.PublisherRepository;
import com.verinite.bookstore.service.PublisherService;
@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository repository;
    private Publisher publisherData;
//Method to Retrieve all data from table publisher
    @Override
    public List<Publisher> getAllPublishers() {
        return repository.findAll();
    }
//Method for  Retrieve particular record from table based on publisherId
    @Override
    public Object getPublisherById(int publisherId) {
        try {
            publisherData=repository.findById(publisherId).get();
        } catch (Exception e) {

            return "Error:  no data is present with  publisherId :"+  publisherId;
        }
        if(Boolean.FALSE.equals(publisherData.getIsDeleted()))
        {
            return publisherData;
        }else if (Boolean.TRUE.equals(publisherData.getIsDeleted()))
        {
            return "Error:   data is already  Deleted ";
        }

        return publisherData;

    }
//Method for insert operation
    @Override
    public Publisher savePublisher(Publisher publisher) {
        publisher.setUpdateOn(new Date());
        return repository.save(publisher);
    }
//method for delete operation
    @Override
    public String deletePublisher(int publisherId) {
        try {
            publisherData = repository.findById(publisherId).get();
        } catch (Exception e) {
            return "Error:\t publisherId :  " +publisherId+" is not present on Database";
        }
        if(Boolean.FALSE.equals(publisherData.getIsDeleted()))
        {
            publisherData.setIsDeleted(true);
            repository.save(publisherData);
            return "Successfully Deleted";
        }else if (Boolean.TRUE.equals(publisherData.getIsDeleted()))
        {
            return "Error:\t publisherId :  " +publisherId+" is not present on Database";
        }
        else{
            return "no data is present with this publisherId "+  publisherId;
        }
    }
//method for Full update operation
    @Override
    public Object fullUpdate(int publisherId,Publisher publisher) {
        try {
            publisherData=repository.findById(publisherId).get();
        } catch (Exception e) {

            return "Error:  no data is present with  publisherId :"+  publisherId;
        }
         if (Boolean.TRUE.equals(publisherData.getIsDeleted()))
        {
            return "Error:   data is already  Deleted ";
        }
        publisherData.setUpdateOn(new Date());
        publisherData.setPublisherName(publisher.getPublisherName());
        publisherData.setAddress(publisher.getAddress());
        publisherData.setCity(publisher.getCity());
        publisherData.setPincode(publisher.getPincode());
        publisherData.setCountry(publisher.getCountry());
        publisherData.setState(publisher.getState());
        return repository.save(publisherData);

    }
//method for partial update operation
    @Override
    public Object partialUpdate(int publisherId, Publisher publisher) {
        try {
            publisherData=repository.findById(publisherId).get();
        } catch (Exception e) {

            return "Error:  no data is present with  id :"+  publisherId;
        }
        if(publisher.getAddress()!=null || publisher.getCity()!=null || publisher.getCountry()!=null || publisher.getPincode()!=null || publisher.getState()!=null)
        {
            publisherData.setUpdateOn(new Date());
        	if (Boolean.TRUE.equals(publisherData.getIsDeleted()))
            {
                return "Error:  no data is present with  id :"+  publisherId;
            }
            if(publisher.getAddress()!=null)
            {
             publisherData.setAddress(publisher.getAddress());
            }
            if(publisher.getCity()!=null) 
            {
            	publisherData.setCity(publisher.getCity());
            }
            if(publisher.getPincode()!=null)
            {
            	  publisherData.setPincode(publisher.getPincode());
            }
            if(publisher.getCountry()!=null) 
            {
                publisherData.setCountry(publisher.getCountry());
            }
            if(publisher.getState()!=null) 
            {
            	publisherData.setState(publisher.getState());
            }
            return repository.save(publisherData);
        }
        else 
        {
        	return "Give atleast one field to update  ";
        }
        

    }
}