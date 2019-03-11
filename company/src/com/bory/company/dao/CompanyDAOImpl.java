package com.bory.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.bory.company.dto.Employee;
import static com.bory.company.dao.DTOFactory.*;
import static com.bory.company.dao.DataResourceCloser.*;

public class CompanyDAOImpl implements CompanyDAO {
	
	protected final Connection connection;
	
	public CompanyDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int insert(Employee employeeBean) {
		return 0;
	}

	@Override
	public int update(Employee employeeBean) {
		return 0;
	}

	@Override
	public List<Employee> findAll() {
		
		List<Employee> list = new ArrayList<Employee>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			pstmt = connection.prepareStatement(QueryFactory.getQuery("all"));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(fromResultSet(rs, Employee.class));
			}

		} catch (Exception e) {
			
		} finally {
			close(rs,pstmt);
		}

		return list;
	}

	@Override
	public List<Employee> findSome(Map<String, String> findOption) {
		return null;
	}

	@Override
	public List<Employee> findOne(String readOption) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}



}
