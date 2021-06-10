package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import entities.BoxLabel;

public class ExcelLoad {

	public static int getTotalLines(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(new File(fileName));
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);

		int maxCell = sheet.getLastRowNum() + 1;
		wb.close();
		return maxCell;
	}

	public static int getTotalColumns(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(new File(fileName));
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);

		int maxCell = sheet.getRow(0).getLastCellNum();
		wb.close();
		return maxCell;
	}

	public static BoxLabel[] getFileInfo(String fileName) throws IOException {
		String boxName = null;
		String size = null;
		String weight = null;
		String processType = null;
		String packingList = null;
		String processName = null;
		String invoice = null;

		FileInputStream fis = new FileInputStream(new File(fileName));
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);

		// FormulaEvaluator formulaEvaluator =
		// wb.getCreationHelper().createFormulaEvaluator();
		int totalRow = 0;
		int rowNum = 0;
		for (Row row : sheet) {
			for (Cell cell : row) {
				switch (cell.getColumnIndex()) {
				case 3: {
					totalRow += 1;
				}
				}

			}
		}
		BoxLabel[] boxList = new BoxLabel[totalRow - 1];

		for (Row row : sheet) {
			boxName = "";
			packingList = "";
			processName = "";
			invoice = "";
			weight = "";
			size = "";
			processType = "";

			for (Cell cell : row) {

				DataFormatter df = new DataFormatter();
				switch (cell.getColumnIndex()) {
				case 0: {
					packingList = df.formatCellValue(cell);
					break;
				}
				case 1: {

					boxName = df.formatCellValue(cell);
					break;
				}
				case 2: {

					processName = df.formatCellValue(cell);
					break;
				}
				case 3: {

					invoice = df.formatCellValue(cell);
					rowNum = cell.getRowIndex();
					break;
				}
				case 4: {

					weight = df.formatCellValue(cell);
					break;
				}
				case 5: {

					size = df.formatCellValue(cell);
					break;
				}
				case 6: {

					processType = df.formatCellValue(cell);
					break;
				}

				default:
					break;
				}

			}
			if (boxName != "" && rowNum != 0) {
				boxList[row.getRowNum() - 1] = new BoxLabel(packingList, boxName, processName, invoice, weight, size,
						processType);
			}
		}
		wb.close();
		return boxList;
	}
}