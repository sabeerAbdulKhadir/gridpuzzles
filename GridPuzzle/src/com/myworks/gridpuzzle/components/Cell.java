package com.myworks.gridpuzzle.components;

public class Cell {

	private String emptyValue;

	private String value;

	/**
	 * Constructor with value and default value
	 * @param value
	 * @param emptyValue
	 */
	public Cell(String value, String emptyValue) {
		this.value = value;
		this.emptyValue = emptyValue;

	}
	
	public Cell(String value){
		this(value,null);
		
	}

	/**
	 * Getter for value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter for value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the emptyValue
	 */
	public String getEmptyValue() {
		return emptyValue;
	}

	public boolean isEmpty() {

		return value == null || value.equals(getEmptyValue());
	}

}
