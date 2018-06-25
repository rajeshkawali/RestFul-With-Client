package com.restful.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restful.model.RestModel;

public class RestDao {

	private static Map<Long, RestModel> user = new HashMap<Long, RestModel>();

	public RestDao() {
		user.put(1L, new RestModel(1, "Rajesh", "Koli"));
		user.put(2L, new RestModel(2, "Jay Prakash", "etc"));
		user.put(3L, new RestModel(3, "Hari", "Singh"));
		user.put(4L, new RestModel(4, "Ramesh", "Tiwari"));

	}

	public List<RestModel> getAllUser() {
		return new ArrayList<RestModel>(user.values());
	}

	public RestModel getUser(Long userId) {
		System.out.println("user Id==>" + userId);
		return user.get(userId);
	}

	public RestModel addUser(RestModel restmodel) {
		restmodel.setId(user.size() + 1);
		user.put(restmodel.getId(), restmodel);
		return restmodel;
	}

	public RestModel updateUser(RestModel restmodel) {
		if (restmodel.getId() <= 0) {
			return null;
		}
		user.put(restmodel.getId(), restmodel);
		return restmodel;
	}

	public RestModel deleteUser(Long userId) {
		return user.remove(userId);
	}
}
