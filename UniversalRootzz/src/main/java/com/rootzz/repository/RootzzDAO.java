package com.rootzz.repository;

import com.rootzz.model.FamilyRootzzVO;
import com.rootzz.model.ParentVO;

public interface RootzzDAO {
	
	public void insert(ParentVO parent);

	public void insert(FamilyRootzzVO vo);

}
