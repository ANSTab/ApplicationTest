package AppFirst;

import org.apache.poi.ss.formula.functions.Columns;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ApplicitionFirst {

    public static void main(String[] args) throws IOException {
        ZZR zzr = null;
        FileInputStream fis = new FileInputStream("D:\\ApplicationTest\\ZZR.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        String a = "Перидіам";

        HashSet<ZZR> zzrSet = new HashSet<ZZR>();
        for (Row row : workbook.getSheet("Global")) {
            for (Cell cell : row) {

                DataFormatter format = new DataFormatter();
                zzr.setName(cell.toString());

                System.out.println(zzr);
                // System.out.println(cell);

            }

        }


    }
}
