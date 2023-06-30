package com.globits.da.rest;

import com.globits.da.dto.MyFirstApiDto;
import com.globits.da.service.impl.MyFirstApiServiceImpl;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/myFirstApiService")
public class RestExcelMyFirstApiController {
    @Autowired
    MyFirstApiServiceImpl myFirstApiService;
    @PostMapping
    public void exportData (HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Stt");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Code");
        header.createCell(3).setCellValue("Age");
        List<MyFirstApiDto> myFirstApiDtoList = myFirstApiService.getAllMyFirstApi();
        int rowNum = 1;
        for (MyFirstApiDto myFirstApiDto : myFirstApiDtoList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum-1);
            row.createCell(1).setCellValue(myFirstApiDto.getName());
            row.createCell(2).setCellValue(myFirstApiDto.getCode());
            row.createCell(3).setCellValue(myFirstApiDto.getAge());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("myFirstApiService.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
