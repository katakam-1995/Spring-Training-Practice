package com.rootzz.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootzz.model.Parent;
import com.rootzz.repository.ParentRootDao;
import com.rootzz.service.RootzzService;


@Service
public class RootzzServiceImpl implements RootzzService {
	
	@Autowired
    private ParentRootDao parentDAO;


	public List<Parent> saveParentDetails(List<Parent> parent) {
		List<Parent> list=parentDAO.saveAll(parent);
		return list;
	}


	public List<Parent> saveParentRelationDetails(List<Parent> parent) {
		List<Parent> list=parentDAO.saveAll(parent);
		return list;
	}

}
