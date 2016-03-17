package mail;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.unzip.UnzipUtil;

import java.io.*;
import java.util.List;

/**
 * Created by sh1 on 16-3-15.
 */
public class ExtractAllFiles {
    public ExtractAllFiles() {

        try {
            ZipFile zipFile = new ZipFile("D:\\tmp\\email\\20160307.zip");
            if (zipFile.isEncrypted()) {
                // if yes, then set the password for the zip file
                zipFile.setPassword("123");
            }
//            zipFile.extractAll("D:\\tmp\\email");

            List fileHeaderList = zipFile.getFileHeaders();

            for (int i = 0; i < fileHeaderList.size(); i++) {
                FileHeader fileHeader = (FileHeader)fileHeaderList.get(i);
                if (fileHeader != null) {

                    String outFilePath = "D:\\ZipTest3\\" + System.getProperty("file.separator") + fileHeader.getFileName();
                    File outFile = new File(outFilePath);

                    if (fileHeader.isDirectory()) {
                        outFile.mkdirs();
                        continue;
                    }

                    File parentDir = outFile.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    ZipInputStream is = zipFile.getInputStream(fileHeader);
                    OutputStream os = new FileOutputStream(outFile);

                    int readLen = -1;
                    byte[] buff = new byte[4096];

                    while ((readLen = is.read(buff)) != -1) {
//                        System.out.write(readLen);
                        os.write(buff, 0, readLen);
                    }

                    os.close();
                    os = null;
                    is.close();
                    is = null;

                    UnzipUtil.applyFileAttributes(fileHeader, outFile);

                    File file = new File(outFilePath);
                    BufferedReader reader = null;
                    try {
                        System.out.println("以行为单位读取文件内容，一次读一整行：");
                        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
                        String tempString = null;
                        int line = 1;
                        // 一次读入一行，直到读入null为文件结束
                        while ((tempString = reader.readLine()) != null) {
                            // 显示行号
                            System.out.println("line " + line + ": " + tempString);
                            line++;
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException e1) {
                            }
                        }
                    }

                    System.out.println("Done extracting: " + fileHeader.getFileName());
                } else {
                    System.err.println("fileheader is null. Shouldn't be here");
                }


            }




    } catch (ZipException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        /**
     * @param args
     */
    public static void main(String[] args) {
        new ExtractAllFiles();
    }
}
