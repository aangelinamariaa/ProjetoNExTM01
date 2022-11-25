package br.org.cesar.expPratica;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxConverter {

  private static String[] columns = { "Name", "Equipment", "Defect",
    "Description" };

  public static void generateXlsx(TechnicalReport technicalReport) throws IOException, 
	InvalidFormatException {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Technical Report");

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);

    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
      cell.setCellStyle(headerCellStyle);
    }

    Row row = sheet.createRow(1);
    row.createCell(0).setCellValue(technicalReport.getName());
    row.createCell(1).setCellValue(technicalReport.getEquipment());
    row.createCell(2).setCellValue(technicalReport.getDefect());
    row.createCell(3).setCellValue(technicalReport.getDescription());

    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    FileOutputStream fileOut = new FileOutputStream("technical_report.xlsx");
    workbook.write(fileOut);
    fileOut.close();
    workbook.close();
  }

}