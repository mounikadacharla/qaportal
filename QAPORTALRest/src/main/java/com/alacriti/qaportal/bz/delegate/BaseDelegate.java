package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.datasource.MySqlDataSource;

public class BaseDelegate {
	public static final Logger log = Logger.getLogger(BaseDelegate.class);

	protected Connection connection;

	public void setConnection(Connection _connection) {
		log.debug("BaseDelegate=====>setConnection");

		this.connection = _connection;
	}

	public Connection getConnection() {
		log.debug("BaseDelegate=====>getConnection");

		return connection;
	}

	protected void endDBTransaction(Connection connection) {
		
		log.debug("BaseDelegate=====>endDBTransaction");
		try {
			connection.commit();

		} catch (SQLException e) {
			log.error("SQLException in endDBTransaction " + e.getMessage(), e);

			try {
				connection.rollback();
			} catch (SQLException e1) {
				log.error("SQLException in endDBTransaction" + e1.getMessage(),
						e1);

			}
		} catch (Exception e) {
			log.error("Exception in endDBTransaction" + e.getMessage(), e);

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				log.error("SQLException in endDBTransaction" + e.getMessage(), e);
			}
		}

	}

	protected void endDBTransaction(Connection connection, boolean isRollback) {
		log.debug("BaseDelegate=====>endDBTransaction with rollback");

		if (isRollback) {
			try {
				connection.rollback();
				log.info("Rolled Back on some exception....!!!");
			} catch (SQLException e) {
				log.error(
						"SQLException in endDBTransaction " + e.getMessage(), e);
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					log.error(
							"SQLException in endDBTransaction "
									+ e.getMessage(), e);
				}
			}
		}

		else {
			endDBTransaction(connection);
		}

	}

	protected Connection startDBTransaction() {
		log.debug("BaseDelegate=====>startDBTransaction");
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				conn = MySqlDataSource.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return conn;

	}
}