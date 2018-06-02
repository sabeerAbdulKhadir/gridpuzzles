package com.wordament.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.myworks.gridpuzzle.components.Cell;
import com.myworks.gridpuzzle.components.Grid;
import com.myworks.gridpuzzle.constants.GridPuzzleConstants;
import com.myworks.gridpuzzle.fileio.FileReaderWriter;
import com.wordament.exception.WordamentFileException;

public class WordamentReaderWriter implements FileReaderWriter {

	private String deLimiter;

	public WordamentReaderWriter(String fileDelimiter) {
		deLimiter = fileDelimiter;
	}

	/**
	 * {@inheritDoc}
	 */
	public Grid readFileToGrid(String filePath) throws WordamentFileException {

		File file = new File(filePath);
		/**
		 * Use 4x4 array to hold the Wordament board.
		 */
		Grid grid = new Grid(4, 4);

		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			int row = 0;
			while (scanner.hasNext()) {
				int column = 0;
				String line = scanner.nextLine();

				/**
				 * to read values separated by delimiter.
				 */
				StringTokenizer st = new StringTokenizer(line, deLimiter);
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					Cell cell = new Cell(token);
					grid.getGrid()[row][column] = cell;
					column++;
				}
				row++;
			}

		} catch (FileNotFoundException e) {
			throw new WordamentFileException("Error reading message from file '" + file.getAbsolutePath() + "'.", e);
		} finally {
			if(scanner!=null){
				scanner.close();
			}
		}

		return grid;

	}

	/**
	 * {@inheritDoc}
	 */
	public void writeFileFromGrid(Grid grid, String outputPath) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void writeExceptionFile(String message, String outputPath, String inputPath) {

		try {
			write(message, outputPath, inputPath);
		} catch (IOException e) {
			throw new WordamentFileException("Unable to write error message to file '" + outputPath + "'.", e);
		}
	}

	/**
	 * Writes the content to the file.
	 * 
	 * @param content
	 *            content to write.
	 * @param outputFile
	 *            the fully qualified output file name
	 * @throws IOException
	 *             if unable to write the file.
	 */
	private void write(String content, String outputPath, String inputPath) throws IOException {
		FileWriter fileWriter = null;
		try {
			File outputFile = new File(outputPath);
			outputFile.createNewFile();
			fileWriter = new FileWriter(outputFile);
			fileWriter.write(content);
		} catch (IOException e) {
			if (inputPath == null) {
				throw e;
			}
			String outputDir = new File(inputPath).getParentFile().getAbsolutePath();
			outputDir += "\\" + GridPuzzleConstants.DEFAULT_OUTPUT_FILENAME;
			fileWriter = new FileWriter(outputDir);
			fileWriter.write(content);
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}
	}
}
