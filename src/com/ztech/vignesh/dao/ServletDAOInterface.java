package com.ztech.vignesh.dao;

import java.sql.SQLException;

import com.ztech.vignesh.beans.UserBean;

public interface ServletDAOInterface {
	public int insertUserDetails(UserBean userBean) throws SQLException;
}
