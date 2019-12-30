package com.rootzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rootzz.model.FamilyRootzzVO;
import com.rootzz.model.ParentVO;
import com.rootzz.repository.ParentDAO;

@SpringBootApplication
@EntityScan(basePackages = { "com.rootzz" })
@ComponentScan(basePackages = { "com.rootzz" })
public class UniversalRootzzApplication {

	public static void main(String[] args) {
		
		  SpringApplication.run(UniversalRootzzApplication.class, args);
		
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("Spring-Module.xml");
		 * System.out.println("Connected Successfully...." + context.getClassLoader());
		 * 
		 * // byName ParentVO parent = context.getBean("parent", ParentVO.class);
		 * parent.setName("Koteswara Rao"); parent.showParentDetails();
		 * 
		 * ParentDAO parentDAO = (ParentDAO) context.getBean("parentDAO");
		 * FamilyRootzzVO vo=new FamilyRootzzVO(1,"Katakam"); parentDAO.insert(vo);
		 * 
		 * ParentVO prnt = new ParentVO(); parentDAO.insert(prnt);
		 */
	}

}
