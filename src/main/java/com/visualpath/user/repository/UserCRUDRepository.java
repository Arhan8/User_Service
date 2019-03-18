package com.visualpath.user.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.visualpath.user.model.User;
//@Repository
public interface UserCRUDRepository extends JpaRepository<User, Long>,UserRepositoryCustom{
	
//List<User> findByName(String name);
	List<User>  findByName(String name);
	public List<User> findByLowerName(String name);
	@Query("SELECT u FROM User u WHERE LOWER(u.address) = LOWER(:address)")
    public List<User> findByLocation(@Param("address") String address);
	


}
