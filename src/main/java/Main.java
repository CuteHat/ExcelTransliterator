import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

public class Main {
   static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args){
        BasicConfigurator.configure(); // for logger

        ConsoleParams userParams = ConsoleParams.parseParams(args);

        try {
            InputStream excelFile = new FileInputStream(userParams.getFilePath());
            HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();
            int i = userParams.isIgnoreFirstRow() ? 1 : 0;

            for (; i < rowsCount; i++) {
                HSSFRow currentRow = sheet.getRow(i);

                for (int cellIndex:userParams.getColumnsToEdit()) {
                    HSSFCell currentCell = currentRow.getCell(cellIndex);
                    String translatedValue = Transliteration.translateToGeo(currentCell.getStringCellValue());
                    currentCell.setCellValue(translatedValue);
                }
            }

            FileOutputStream outputStream = new FileOutputStream(userParams.getFilePath());
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            LOG.error("File not found",e);
        } catch (IOException e) {
            LOG.error("Workbook exception",e);
        }

    }
}
