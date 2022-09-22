package util;

import java.io.IOException;

public class ExcelUtil {
    /**
     * @author Claw
     * @date 2022/1/4 21:13.
     */

    public static void main(String[] args) {
        // 创建工作簿对象
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook("C:\\Users\\Administrator\\Documents\\test2.xlsx");
            // 获取工作表 getSheet 指定sheet名字获取
            //  XSSFSheet sheet = xssfWorkbook.getSheet("sheet1");
            // 获取工作表 getSheetAt 从第一个sheet获取,一般用这个
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            // 获取行
            for (Row cells : sheet) {
                // 获取单元格
                for (Cell cell : cells) {
                    // 获取单元格内容 假设此时单元格内容都是文本格式，用getStringCellValue获取
                    String value = cell.getStringCellValue();
                    System.out.println(value);
                }
            }
            xssfWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
