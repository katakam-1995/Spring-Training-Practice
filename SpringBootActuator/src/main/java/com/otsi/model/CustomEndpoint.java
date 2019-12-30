package com.otsi.model;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpoint implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		
	}

}
