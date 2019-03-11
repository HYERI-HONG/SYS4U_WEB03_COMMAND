package com.bory.company.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailCommand extends AbstractCommand {

	private static final String DETAIL_VIEW_NAME = "/WEB-INF/view/empDetail.jsp";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		return DETAIL_VIEW_NAME;
	}

	

}
