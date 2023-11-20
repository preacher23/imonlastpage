package com.verinite.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.verinite.bookstore.entity.InvoiceDatabaseEntity;
public interface InvoiceDatabaseRepository extends JpaRepository<InvoiceDatabaseEntity,Integer> {

}
