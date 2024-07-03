package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataSupplier {

	public static Object[][] readDataFromExcel() throws IOException {

		File excel = new File(".\\src\\main\\resources\\DataExcels\\Applicant names.xlsx");
		System.out.println(excel.exists());
		FileInputStream file = new FileInputStream(excel);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int numberofcolumns = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows - 1][numberofcolumns];
		System.out.println(rows);
		System.out.println(numberofcolumns);
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < numberofcolumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j)); // System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
			}
		}
		workbook.close();
		file.close();
		for (Object[] arr : data) {
			System.out.println(Arrays.toString(arr));
		}

		return data;
	}
	
	public static int getRows() throws IOException {

		File excel = new File(".\\src\\main\\resources\\DataExcels\\Applicant names.xlsx");
		System.out.println(excel.exists());
		FileInputStream file = new FileInputStream(excel);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int numberofcolumns = sheet.getRow(0).getLastCellNum();
		return rows;
	}
	
	public static int getNumberOfColumns() throws IOException {

		File excel = new File(".\\src\\main\\resources\\DataExcels\\Applicant names.xlsx");
		System.out.println(excel.exists());
		FileInputStream file = new FileInputStream(excel);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int numberofcolumns = sheet.getRow(0).getLastCellNum();
		return numberofcolumns;
	}
	
	
	public static void main(String[] args) throws IOException {
		 String apltype="";
		 String ApplicantLastName="";
		 String gender = "";
		 String ApplicantFirstName ="";
       Object data[][] = ExcelDataSupplier.readDataFromExcel();
		
		int rows = ExcelDataSupplier.getRows();
		int columns = ExcelDataSupplier.getNumberOfColumns();
		for(int i =0; i<rows-1 ; i++) {
			for(int j = 0; j<columns; j++) {
				
				//System.out.println(data[i][j]);	
				
				apltype = data[i][0].toString(); 
				ApplicantFirstName = data[i][1].toString();
			}
			System.out.println("Value of app type is " + apltype + "and first name is "+ApplicantFirstName+"");
		}
		
	}
}
