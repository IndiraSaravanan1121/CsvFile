package com.atmecs.testscript;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used to read and write data
 * 
 * @author indira.saravanan
 *
 */
public class CsvFile {
	static Scanner scan;
	static String name;
	BufferedReader csvReader;
	String[] data;

	public static void main(String[] args) throws Exception {
		CsvFile csv = new CsvFile();
		scan = new Scanner(System.in);
		System.out.println("Enter the Name or City which you want to see");
		name = scan.next();
		File file = new File("csvfile.csv");
		csv.WriteCSVData(file);
		csv.ReadCsvData(file);

	}

	/**
	 * This method is used read data from csv file.
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public void ReadCsvData(File file) {
		String row;
		try {
			csvReader = new BufferedReader(new FileReader(file));
			while ((row = csvReader.readLine()) != null) {

				if (row.contains(name)) {
					System.out.println(row);
					data = row.split(",");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is used to write data into csv file.
	 * 
	 * @param file
	 * @throws Exception
	 */
	public void WriteCSVData(File file) throws Exception {
		List<List<String>> rows = Arrays.asList(Arrays.asList("1", "indira", "chennai"),
				Arrays.asList("2", "ranjitha", "chennai"), Arrays.asList("3", "magesh", "chennai"),
				Arrays.asList("4", "anusha", "bangalore"), Arrays.asList("5", "nischal", "vijayawada"),
				Arrays.asList("6", "suraj", "vijayawada"), Arrays.asList("7", "siva", "hyderabad"),
				Arrays.asList("8", "david", "chennai"), Arrays.asList("9", "mohit", "lucknow"),
				Arrays.asList("10", "kishore", "bangalore"), Arrays.asList("11", "rishav", "Jharkand"),
				Arrays.asList("12", "arjun", "lucknow"), Arrays.asList("13", "david", "chennai"),
				Arrays.asList("14", "sakthi", "chennai"), Arrays.asList("15", "ajith", "chennai"),
				Arrays.asList("16", "amruth", "lucknow"));

		FileWriter csvWriter;
		csvWriter = new FileWriter(file);
		csvWriter.append("EmpId");
		csvWriter.append(",");
		csvWriter.append("Name");
		csvWriter.append(",");
		csvWriter.append("Address");
		csvWriter.append("\n");

		for (List<String> rowData : rows) {
			csvWriter.append(String.join(",", rowData));
			csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}

}