package com.rootzz.service;

import java.util.List;

import com.rootzz.model.Parent;

public interface RootzzService {
	
	List<Parent> saveParentDetails(List<Parent> parent);
	
	List<Parent> saveParentRelationDetails(List<Parent> parent);

}
