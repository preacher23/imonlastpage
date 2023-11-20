package com.verinite.bookstore.repository;

import java.util.List;
import java.util.Map;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.verinite.bookstore.entity.Invoice;
@Repository
public interface InvoiceRepo  extends JpaRepository<Invoice,Integer>{
	@Query(value="select i.invoice_id, i.address_1,o.ordered_date, i.city, i.country, i.customer_id, i.customer_name,r.user_name, i.mobile_number, i.payment_id,o.order_id,o.book_id,o.book_qty,o.book_title,o.book_price,pa.amount, i.pincode, i.state FROM invoice_t i inner join tbl_orderbook o on o. payment_id=i.payment_id inner join tbl_customer c on c.customer_id=i.customer_id inner join tbl_registration r on r.register_id=c.reg_id and r.user_name=?1 inner join payments pa on pa.payment_id=i.payment_id and pa.payment_id=?2",nativeQuery=true)
	List<Map<String, String>> getAllDataOfInvoice(String username, int paymentid);

}
