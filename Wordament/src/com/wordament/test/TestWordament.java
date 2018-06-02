package com.wordament.test;

import java.io.FileNotFoundException;

import com.wordament.Wordament;

public class TestWordament {

	public static void main(String[] args) throws FileNotFoundException {

		Wordament wordament = new Wordament("C:\\Users\\sabeer\\Desktop\\inputWordament.txt", "output.txt", ",");
		wordament.findWords();

	}

}
