package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.qaportal.datasource.MySqlDataSource;

public class BaseDelegate {

	private Connection connection;

	public void setConnection(Connection _connection) {

		this.connection = _connection;
	}

	public Connection getConnection() {

		return connection;
	}

	protected void endDBTransaction(Connection connection) {

		try {
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error while commiting");

			try {
				connection.rollback();
			} catch (SQLException e1) {

			e1.printStackTrace();
			System.out.println("error while rollbacking");

			}
		} catch (Exception e) {
			e.printStackTrace();
			
			
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("error while connection closing");
			}
		}

	}

	protected void endDBTransaction(Connection connection, boolean isRollback) {
		

		if (isRollback) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				System.out.println("SQLException in endDBTransaction " + e.getMessage());
						
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					System.out.println("SQLException in endDBTransaction "
									+ e.getMessage());
				}
			}
		}
							
			
		else {
			endDBTransaction(connection);
		}

	}

	protected Connection startDBTransaction() {
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				conn = MySqlDataSource.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("SQLException in startDBTransaction " + e.getMessage());
		}
		return conn;

	}
}