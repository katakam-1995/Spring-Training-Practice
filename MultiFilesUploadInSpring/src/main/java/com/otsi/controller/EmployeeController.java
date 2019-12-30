package com.otsi.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.otsi.model.Employee;
import com.otsi.service.EmployeeService;

@Controller
public class EmployeeController {
	
	public static  String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";
	
	//public static final String path=null;

	private String employeeId=null;
		
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmployee")
	public String getEmployee(Model model) {
		List<Employee> employees=employeeService.getEmployeesList();
		model.addAttribute("employees", employees);
		return "index";
	}

	@GetMapping("/getListOfFiles")
	public String uploading(@RequestParam("id") Integer id,Model model) {
		employeeId=id.toString();
		File file = new File(uploadingDir);
		model.addAttribute("files", file.listFiles());
		return "uploading";
	}
	
	@RequestMapping(value = "/getListOfFiles", method = RequestMethod.POST)
	public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
		String files=null;
		if(employeeId!=null) {
		   files=uploadingDir+"/"+employeeId+"/";
		}
		Path path = Paths.get(files);
		if(!Files.exists(path)) {
			 Files.createDirectories(path);
		}else {
			 employeeService.getEmployee(employeeId, path);
		}
		for (MultipartFile uploadedFile : uploadingFiles) {
			File file = new File(files+uploadedFile.getOriginalFilename());
			uploadedFile.transferTo(file);
		}

		return "redirect:/getListOfFiles";
	}
}
