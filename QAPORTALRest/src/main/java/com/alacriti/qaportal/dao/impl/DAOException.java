package com.alacriti.qaportal.dao.impl;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.constants.ErrorConstants;
import com.alacriti.qaportal.exception.BaseException;

public class DAOException extends BaseException {
	public static final Logger log= Logger.getLogger(DAOException.class);

	public DAOException() {
	}

	public DAOException(String msg, Throwable th, String errorCode) {
		super(msg, th, errorCode);
	}

	public DAOException(Throwable th, String errorCode) {
		this(null, th, errorCode);
	}

	public DAOException(String msg, Throwable th) {

		this(msg, th, ErrorConstants.ERR_GENERIC_DAO);
	}

	public DAOException(Throwable th) {
		this(null, th, ErrorConstants.ERR_GENERIC_DAO);
	}

	public DAOException(String msg, String errorCode) {
		this(msg, null, errorCode);
	}

	public DAOException(String msg) {
		this(msg, null, ErrorConstants.ERR_GENERIC_DAO);
	}
}
