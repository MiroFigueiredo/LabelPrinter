package utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelTemplate {

	public static void fileDownload(String filePatch) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Java Books");

		Object[][] bookData = { { "Packing List", "Box Name", "Nome do Processo", "Nota Fiscal", "Peso", "Dimensão",
				"Tipo do material" } };

		int rowCount = -1;

		for (Object[] aBook : bookData) {
			rowCount += 1;
			Row row = sheet.createRow(rowCount);

			int columnCount = -1;

			for (Object field : aBook) {
				columnCount += 1;
				Cell cell = row.createCell(columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		try (FileOutputStream outputStream = new FileOutputStream(filePatch)) {
			workbook.write(outputStream);
		}
		workbook.close();
	}

}