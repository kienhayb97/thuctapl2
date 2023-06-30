package com.globits.da.rest;

import com.globits.da.dto.EmployeeDto;
import com.globits.da.service.EmployeeService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/excelWriter")
public class RestExcelWriterController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = "", method = RequestMethod.POST)
        public void exportData (HttpServletResponse response) throws IOException {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Data");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Stt");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Code");
            header.createCell(3).setCellValue("Email");
            header.createCell(4).setCellValue("Phone");
            header.createCell(5).setCellValue("Age");
            List<EmployeeDto> employeeDtoList = employeeService.getAllEmployee();
            int rowNum = 1;
            for (EmployeeDto employeeDto : employeeDtoList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rowNum-1);
                row.createCell(1).setCellValue(employeeDto.getName());
                row.createCell(2).setCellValue(employeeDto.getCode());
                row.createCell(3).setCellValue(employeeDto.getEmail());
                row.createCell(4).setCellValue(employeeDto.getPhone());
                row.createCell(5).setCellValue(employeeDto.getAge());
            }
        try {
            FileOutputStream outputStream = new FileOutputStream("employee.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
