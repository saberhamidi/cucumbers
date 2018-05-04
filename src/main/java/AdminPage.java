import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AdminPage {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
    private static XSSFRow row;

    public static void setFile(String path){

        try {
            FileInputStream file = new FileInputStream(path);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeReportResult(String result, int rowNum, int column){

        row = sheet.getRow(rowNum);
        cell = row.getCell(column, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

        if(cell == null){
            cell = row.createCell(column);
            cell.setCellValue(result);
        }
        else cell.setCellValue(result);

        try {
            FileOutputStream fileOutput = new FileOutputStream("/Users/Saber/Desktop/QA Training/Week9/cucumbers/src/main/resources/assessmentData.xlsx");
            workbook.write(fileOutput);
            fileOutput.flush();
            fileOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
