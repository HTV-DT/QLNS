package com.example.demo.helper;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.text.SimpleDateFormat;

import com.example.demo.model.BangCong;
import com.example.demo.model.PhongBan;


public class BangCongImport {
    

    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of nhanvien

    public static List<BangCong> convertExcelToListOfProduct(InputStream is) {
        List<BangCong> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                BangCong p = new BangCong();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                           // p.setNgay(SimpleDateFormat("dd/MM/yyyy").parse(cell.getStringCellValue()));
                            break;
                       
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(p);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
