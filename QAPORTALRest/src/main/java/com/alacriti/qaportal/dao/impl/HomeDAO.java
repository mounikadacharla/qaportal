package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.alacriti.qaportal.model.vo.HomeVO;

public class HomeDAO extends BaseDAO{
	public HomeDAO(Connection connection){
		super(connection);
	}
	public HomeDAO(){
		
	}
	public HomeDAO(HomeVO homeVO){
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
	}
	

}
