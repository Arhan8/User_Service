package com.visualpath.user.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import com.visualpath.user.model.User;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	@Autowired
	 EntityManager em;
	@Override
	public List<User> getUsersByNameAndCity(String name, String address) {
		// TODO Auto-generated method stub
		        CriteriaBuilder cb = em.getCriteriaBuilder();
		          CriteriaQuery<User> cq = cb.createQuery(User.class); 
		          Root<User> user = cq.from(User.class);
		          Predicate cityPredicate = cb.equal(user.get("address"), address);
		          Predicate namePredicate = cb.like(user.get("name"), "%" + name + "%");       
		         if(name!=null && address!=null)
		          cq.where(cityPredicate, namePredicate);
		         else if(name!=null && address==null)
		          cq.where(namePredicate);
		        else if(name==null && address!=null)
		          cq.where(cityPredicate); 
		          TypedQuery<User> query = em.createQuery(cq);
		          return query.getResultList();   
	}

}
