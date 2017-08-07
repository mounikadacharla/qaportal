package com.alacriti.qaportal.bz.delegate;
import java.sql.Connection;

import com.alacriti.qaportal.bo.imp.LoginBO;
import com.alacriti.qaportal.model.vo.UserLoginVO;
public class LoginDelegate extends BaseDelegate {
		public boolean loginRoleBO(UserLoginVO loginDetails){
			boolean rollBack=false;
			boolean flag=false;
			Connection connection=null;
			try{
			connection = startDBTransaction();
			setConnection(connection);
			System.out.println("database connected..in LoginDelegate");
			LoginBO loginBO=new LoginBO(getConnection());
			System.out.println("Still in LoginDelegate");
			flag=loginBO.loginRoleBO(loginDetails);
			System.out.println("Still in LoginDelegate..2");
			} catch (Exception e) {
				System.out.println("Exception in LoginDelegate");
				e.printStackTrace();
				rollBack = true;
			} finally {
				endDBTransaction(connection, rollBack);
				return flag;
			}
			
		}
	}
