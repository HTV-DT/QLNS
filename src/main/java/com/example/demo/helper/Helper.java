package com.example.demo.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.NhanVien;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {


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

    public static List<NhanVien> convertExcelToListOfProduct(InputStream is) {
        List<NhanVien> list = new ArrayList<>();

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

                NhanVien p = new NhanVien();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            p.setTenNhanSu(cell.getStringCellValue());
                            break;
                        case 1:
                            p.setCCCD(cell.getStringCellValue());
                            break;
                        case 2:
                            p.setEmail(cell.getStringCellValue());
                            break;
                        case 3:
                            p.setNgaySinh(cell.getStringCellValue());
                            break;
                        case 4:
                            p.setHinhAnh(cell.getStringCellValue());
                            break;
                        case 5:
                            p.setDanToc(cell.getStringCellValue());
                            break;
                        case 6:
                            p.setQuocTich(cell.getStringCellValue());
                            break;
                        case 7:
                            p.setNgayKyHopDong(cell.getStringCellValue());
                            break;
                        case 8:
                            p.setSoTK(cell.getStringCellValue());
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
