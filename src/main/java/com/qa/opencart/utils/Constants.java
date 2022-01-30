package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final int ACC_PAGE_SECTION_COUNT = 4 ;
	
	public static List<String> expectedAccSecList () {
		List<String> accExecList = new ArrayList<String>();
		accExecList.add("My Account");
		accExecList.add("My Orders");
		accExecList.add("My Affiliate Account");
		accExecList.add("Newsletter");
		return accExecList;
	}
}
