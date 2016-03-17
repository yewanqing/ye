package reflection;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sh1 on 15-11-22.
 */
public class Test {
    public static void main(String[] args) {
//        Apple apple = new Apple("red",15.6);
//        Field[] fields = apple.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            try {
//                field.setAccessible(true);
//                System.out.println(field.get(apple));
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        FileInputStream fileInputStream = null;
//        Workbook workBook = null;
//        int index = 34;
//        try {
//            fileInputStream = new FileInputStream("F:/\\mobileInfo.xlsx");
//            workBook = new XSSFWorkbook(fileInputStream);
////            POIFSFileSystem fs = new POIFSFileSystem(fileInputStream);
////            workBook = new HSSFWorkbook(fs);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Sheet sheet = workBook.getSheetAt(0);
//        Iterator<Row> rows = sheet.rowIterator();
//        StringBuilder sb = new StringBuilder();
//        StringBuilder userDetail = new StringBuilder();
//        int i = 0;
//        while (rows.hasNext()) {
//            Row row = rows.next();
//            i++;
//            StringBuilder tem = new StringBuilder();
//            String card = row.getCell(2).getStringCellValue().trim();
//            String mobile = row.getCell(3).getStringCellValue().trim();
//            sb.append("update t_uc_user set mobile = '");
//            userDetail.append("update t_uc_user_detail set mobile = '");
//            tem.append(mobile).append("' ");
//            tem.append("where corp_code = 'cqrcpx' ");
//            tem.append("and id_card = '");
//            tem.append(card).append("' ");
//            tem.append("and (mobile = '' or mobile is null)");
//            tem.append(";\r\n");
//            sb.append(tem);
//            userDetail.append(tem);
//
//
//        }
//        BufferedWriter writer;
//        try {
//            writer = new BufferedWriter(new FileWriter(new File("F:/\\update/\\cqrcpcUpdateUser_" + index + ".sql"), true));
//            writer.write(sb.toString());
////            writer.write("\"101\",\"英语\",\"english\",\"100001\"\r\n");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            writer = new BufferedWriter(new FileWriter(new File("F:/\\update/\\cqrcpcUpdateUserDetail_" + index + ".sql"), true));
//            writer.write(userDetail.toString());
////            writer.write("\"101\",\"英语\",\"english\",\"100001\"\r\n");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Date now = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//        calendar.add(Calendar.MONTH, 2);
//        System.out.println(calendar.getTime());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String time = dateFormat.format(calendar.getTime());
//        System.out.println(time);
//            System.out.println(dateFormat.parse(time));

    }

}
