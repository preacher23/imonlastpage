package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Delivery;
import com.verinite.bookstore.repository.DeliveryRepository;
import com.verinite.bookstore.service.DeliveryService;
@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepo;


    @Override
    public List<Delivery> getdelivery() {
        List<Delivery> deliveryList = new ArrayList<>();
        deliveryRepo.findAll().forEach(deliveryList::add);
        return deliveryList;
    }


    @Override
    public Object getById(int id) {
        try {
            deliveryRepo.findById(id).get();
            return deliveryRepo.getById(id);
        } catch (Exception e) {
            return "Id not Found";
        }
    }

    @Override
    public Delivery createDelivery(Delivery delivery) {
        delivery.setCreatedon(new Date());
        delivery.setUpdatedon(new Date());
        return deliveryRepo.save(delivery);
    }

    @Override
    public Object updateDelivery(int id, Delivery delivery) {
        try {
            Delivery deliveryg = (Delivery) deliveryRepo.findById(id).get();

            deliveryg.setAddress1(delivery.getAddress1());
            deliveryg.setAddress2(delivery.getAddress2());
            deliveryg.setCity(delivery.getCity());
            deliveryg.setCountry(delivery.getCountry());
            deliveryg.setCustomername(delivery.getCustomername());
            deliveryg.setState(delivery.getState());
            deliveryg.setPincode(delivery.getPincode());
            deliveryg.setUpdatedon(delivery.getUpdatedon());
            return deliveryRepo.save(deliveryg);
        } catch (Exception e) {
            return "record is not present to update with id of " + id;
        }
    }

        @Override
        public String deletedelivery(int id) {
            Delivery delivery1 = new Delivery();
            try {
                delivery1 = deliveryRepo.getById(id);
            }catch (Exception e){
                return "id" + id + "is not present";
            }
            if (0 != delivery1.getId() && !delivery1.getIsDeleted()){
                delivery1.setIsDeleted(true);
                deliveryRepo.save(delivery1);
                return "deleted successfully";
            } else  if (delivery1.getIsDeleted()){
                return "data deleted successfully";
            }else{
                return "no data found";
            }
        }


		@Override
		public List<Map<String, String>> getAllRecord(String username) {
			
			return deliveryRepo.getAllRecord(username);
		}
    }
