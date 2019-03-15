package com.bory.company.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bory.company.dao.CompanyDAOImpl;
import com.bory.company.dto.Employee;
import com.bory.company.exception.CommandExecutionException;
import com.bory.company.pool.Constants;

public class AddCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String redirectUrl = "/company/empDetail.do?empno="+request.getParameter("empNo");
		
		Employee employee = new Employee();
		employee.create(request);	
	
		int successed = new CompanyDAOImpl(connection).insert(employee);
		if(successed==1) {
			request.setAttribute("redirectUrl", redirectUrl);
			request.setAttribute("message", "성공적으로 등록되었습니다.");
			return Constants.REDIRECT_VIEW;
		}
		//실패 했을 경우
		//conn.rollback();
		
		throw new CommandExecutionException("Employee data[" + employee.geteName() + "] not inserted.");
	}
}
