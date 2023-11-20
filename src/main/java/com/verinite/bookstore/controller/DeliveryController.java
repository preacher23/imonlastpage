package com.verinite.bookstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Delivery;
import com.verinite.bookstore.service.DeliveryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/delivery")
public class DeliveryController {
@Autowired
    DeliveryService deliveryService;
   @GetMapping("/getalldelivery")
    public List<Delivery> getdelivery(){
       return deliveryService.getdelivery();
   }
   @GetMapping("/viewDelivery/{id}")
    public Object getById(@PathVariable int id){
       return deliveryService.getById(id);
   }
   @PostMapping("/savedelivery")
    public Delivery createDelivery(@RequestBody Delivery delivery){
       return deliveryService.createDelivery(delivery);
   }
   @PutMapping("/updatedelivery/{id}")
    public Object updateDelivery(@PathVariable int id,@RequestBody Delivery delivery){
       return deliveryService.updateDelivery(id,delivery);
   }
   @DeleteMapping("/deletedelivery/{id}")
   public String deletedelivery(@PathVariable int id){
      return deliveryService.deletedelivery(id);
  }
   
   @GetMapping("/getAll/{username}")
   public List<Map<String,String>> getAllDeliveryWithCustomer(@PathVariable String username){
	   return deliveryService.getAllRecord(username);
	   
   }
}