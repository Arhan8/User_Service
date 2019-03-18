package com.visualpath.user.repository;
import java.util.List;

import com.visualpath.user.model.User;

public interface UserRepositoryCustom{
	 List<User> getUsersByNameAndCity(String name,String address);

}
