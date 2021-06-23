package com.example.utils;

/*
 * 解析excel工具类
 * */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelUtil {


    static public List<Map<String,String>> AnalysisExcel(InputStream is, String fileName) throws IOException {

        List<Map<String, String>> list = new ArrayList<>();
        Workbook workbook = createWorkbookByExcelType(is, fileName); // 创建工作簿

        for(int a = 0; a < workbook.getNumberOfSheets(); a++){
            Sheet sheet = workbook.getSheetAt(a);
            Row row = null;

            // 获取最大行数
            int maxRowNum = sheet.getLastRowNum();

            // 获取第一行
            row = sheet.getRow(0);

            // 获取最大列数
            int maxColNum = 8;

            //定义表头属性
            List<String> arrayList = new ArrayList<>();
            arrayList.add("busid");
            arrayList.add("title");
            arrayList.add("introduction");
            arrayList.add("salary");
            arrayList.add("workdate");
            arrayList.add("position");
            arrayList.add("nums");
            arrayList.add("requirement");


            // 循环遍历excel表格，把每条数据封装成 map集合，再放入list集合中
            for (int i = 1; i <= maxRowNum; i++) {
                Map<String, String> map = new HashMap<>();

                row = sheet.getRow(i);

                if (row != null){
                    boolean isok=true;
                    for (int j = 0; j < maxColNum; j++) {
                        String cellData = (String)getCellFormatValue(row.getCell(j));
                        map.put(arrayList.get(j), cellData); // map 封装
                        if(cellData==""){
                            isok=false;
                            break;
                        }
                    }
                    if(isok){
                        list.add(map); // map存入list
                    }

                }
            }
        }

        return list;
    }


    //根据传入的文件名后缀判断是xls还是xlsx
    public static Workbook createWorkbookByExcelType(InputStream inputStream,String fileName){
        Workbook wb = null;
        if(fileName == null){
            return null;
        }
        String extString = fileName.substring(fileName.lastIndexOf("."));
        InputStream is = null;
        try {
            is = inputStream;
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is); // 2003版本 .xls
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is); // 2007版本 .xlsx
            }else{
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wb;
    }

    // 用于获取表格中的数据方法
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

}
