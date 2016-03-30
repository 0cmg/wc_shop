package com.lichking.exception;

import org.apache.log4j.Logger;

public class ButtonArraySizeOutOfRange extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(ButtonArraySizeOutOfRange.class);
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
		logger.info("传入button数组不应大于3!");
	}
	
}
