package com.qa.utilities;

import java.io.IOException;
import java.util.ArrayList;
import com.qa.test.BaseClass;

public class ExcelDataReader extends BaseClass {
	// public static void main(String[] args) {
	// Path to your Excel file
	public String excelFilePath = System.getProperty("user.dir") + "//excel//testdata22.xlsx";

	public ArrayList<ArrayList<String>> getXl_Data(String SheetName) throws IOException {

		int xlrowcount = XLUtils.getRowCount(excelFilePath, SheetName);

		int xlcellcount = XLUtils.getCellCount(excelFilePath, SheetName, 0);

		ArrayList<String> Data = new ArrayList<String>();

		ArrayList<ArrayList<String>> DataSet = new ArrayList<ArrayList<String>>();

		for (int row = 1; row <= xlrowcount; row++) {

			for (int column = 0; column < xlcellcount; column++) {

				String value = XLUtils.getCellData(excelFilePath, SheetName, row, column).trim();

				Data.add(value);
			}

			DataSet.add(new ArrayList<String>(Data));

			Data.clear();

		}

		return DataSet;

	}

	public ArrayList<ArrayList<String>> getXl_Customer1() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data("Sheet1");

		// System.out.println("Data:" + XlData);

		return XlData;

	}
	

	

}