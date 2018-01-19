package com.ztech.vignesh.dao;

import com.ztech.vignesh.dbutils.*;
import java.sql.SQLException;

import com.ztech.vignesh.beans.*;

public class ServletDAO implements ServletDAOInterface{
	public Connectivity connectivity;
	
	public int insertUserDetails(UserBean userBean) throws SQLException  {
		try {
			connectivity = new Connectivity();
			connectivity.connect();
			connectivity.statement.setString(1, userBean.getFirstname());
			connectivity.statement.setString(2, userBean.getLastname());
			connectivity.statement.setString(3, userBean.getPassword());
			connectivity.statement.setString(4, userBean.getPhone());
			connectivity.statement.setString(5, userBean.getEmail());
			connectivity.statement.execute();
		}
		catch(Exception e) {
//			e.printStackTrace();
		}
		finally {
			connectivity.close();
		}
		return 0;
	}
}
