package com.or.reports;

import java.util.Map;

public class ReportsServiceImpl {
	
	public String getFile(String table) {
		return "jasper\\" + table;
	}

	public Map<String, Object> generateTable() {
		return null;
	}

}
