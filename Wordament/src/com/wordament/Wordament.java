
package com.wordament;

import com.myworks.gridpuzzle.components.Grid;
import com.myworks.gridpuzzle.fileio.FileReaderWriter;
import com.wordament.fileio.WordamentReaderWriter;

public class Wordament {

	private String outputFilePath = "";

	private String inputFilePath = "";

	private String delimiter = "";

	/**
	 * 2D representation to hold the elements.
	 */
	private Grid grid;

	/**
	 * Reader to read input from file.
	 */
	private FileReaderWriter readerWriter;

	/**
	 * Initializes the class by reading the input file.
	 * 
	 * @param inFilePath
	 *            path of the inputFile.
	 * @param outFilePath
	 *            path of the outputFile.
	 * @param delimiter
	 *            delimiter of the input file(which will be used in output file
	 *            as well).
	 * 
	 */
	public Wordament(String inFilePath, String outFilePath, String delimiter) {
		outputFilePath = outFilePath;
		inputFilePath = inFilePath;
		readerWriter = new WordamentReaderWriter(delimiter);
	}

	/**
	 * Solves the wordament puzzle.
	 */
	public void findWords() {
		grid = readerWriter.readFileToGrid(inputFilePath);
		System.out.println(grid);
	}

	/**
	 * Getter for the grid.
	 * 
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Setter for the grid.
	 * 
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * Getter for outputFilePath.
	 * 
	 * @return the outputFilePath
	 */
	public String getOutputFilePath() {
		return this.outputFilePath;
	}

	/**
	 * Setter for outputFilePath.
	 * 
	 * @param outputFilePath
	 *            the outputFilePath to set
	 */
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	/**
	 * Getter for inputFilePath.
	 * 
	 * @return the inputFilePath
	 */
	public String getInputFilePath() {
		return inputFilePath;
	}

	/**
	 * Setter for inputFilePath.
	 * 
	 * @param inputFilePath
	 *            the inputFilePath to set
	 */
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	/**
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * @param delimiter
	 *            the delimiter to set
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
}
