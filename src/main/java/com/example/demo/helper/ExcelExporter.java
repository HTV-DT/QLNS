package com.example.demo.helper;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.model.NhanVien;

public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<NhanVien> listNhanVien;
     
    public ExcelExporter(List<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("NhanViens");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Tên Nhân Sự", style);      
        createCell(row, 1, "CCCD", style);       
        createCell(row, 2, "Email", style);    
        createCell(row, 3, "Ngày Sinh", style);
        createCell(row, 4, "Dân Tộc", style);
        createCell(row, 5, "Quốc Tịch", style);
        createCell(row, 6, "Ngày Ký Hợp Đồng", style);
        createCell(row, 7, "Số Tài Khoảng", style);
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (NhanVien NhanVien : listNhanVien) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, NhanVien.getTenNhanSu(), style);
            createCell(row, columnCount++, NhanVien.getCCCD(), style);
            createCell(row, columnCount++, NhanVien.getEmail(), style);
            createCell(row, columnCount++, NhanVien.getNgaySinh(), style);
            createCell(row, columnCount++, NhanVien.getDanToc(), style);
            createCell(row, columnCount++, NhanVien.getQuocTich(), style);
            createCell(row, columnCount++, NhanVien.getNgayKyHopDong(), style);
            createCell(row, columnCount++, NhanVien.getSoTK(), style);

        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
