package com.verinite.bookstore.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

	@Query(value="select * from tbl_registration where is_delete=false", nativeQuery = true)
    List<Registration> getAllUser(boolean isDelete);
	
	@Query(value="select * from tbl_registration where user_name IN(:userName)", nativeQuery = true)
	List<Registration> findByUserNames(@Param("userName") String userName);
	
	//
	
	
	
	/*
	 * @Query(value="select * from tbl_registration where user_name IN(:userName)",
	 * nativeQuery = true) List<Registration> findByUserName(@Param("userName")
	 * String userName);
	 */

	Optional<Registration> findByEmailaddress(String email);
	@Query(value="select * from tbl_registration where emailaddress=?1", nativeQuery = true)
	Optional<Registration> findByEmail(String email);

	Optional<Registration> findByUserName(String user);
	 @Query(value="select c.customer_id from tbl_customer c inner join tbl_registration r on r.register_id=c.reg_id and r.user_name=?1",nativeQuery = true)
	List<Map<String, String>> getAllRecord(String username );
}
