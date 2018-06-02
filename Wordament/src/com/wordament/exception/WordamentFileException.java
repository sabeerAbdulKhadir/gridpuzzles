package com.wordament.exception;

import com.myworks.gridpuzzle.exception.FileException;

/**
 * Exception class to handle the error scenarios during the WordamentFile
 * operations.
 *
 */
public class WordamentFileException extends FileException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Wordament Wrapper to {@link RuntimeException} (String message)
	 * 
	 * @param message
	 *            error message
	 */
	public WordamentFileException(String message) {
		super(message);
	}

	/**
	 * Wordament wrapper to {@link RuntimeException} (String message, Throwable e).
	 * 
	 * @param message
	 *            error message
	 * @param e
	 *            exception
	 */
	public WordamentFileException(String message, Throwable e) {
		super(message, e);
	}

}
