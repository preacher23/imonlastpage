package com.verinite.bookstore.service;

import com.verinite.bookstore.entity.Delivery;
import com.verinite.bookstore.entity.Invoice;
import com.verinite.bookstore.entity.Payment;

public interface InvoiceService {

	Invoice save(Delivery delivery, Payment payment);

}
