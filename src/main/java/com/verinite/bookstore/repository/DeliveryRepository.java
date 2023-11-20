package com.verinite.bookstore.repository;

import java.util.List;
import java.util.Map;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {


	 @Query(value="select d.customer_name,d.address_1,d.city,d.state,d.country,d.pincode,c.customer_id,c.first_name,c.last_name,c.mobile_number from tbl_delivery d inner join tbl_customer c on c.customer_id=d.customer_id inner join tbl_registration r on r.register_id=c.reg_id and r.user_name=?1",nativeQuery = true)
	 //@Query(value="select b.book_id,b.book_title,b.description,b.book_price,b.pic_byte,s.stock_id,s.quantity from tbl_book b inner join stock s on b.book_id=s.book_id",nativeQuery = true)
	List<Map<String, String>> getAllRecord(String username );
}
