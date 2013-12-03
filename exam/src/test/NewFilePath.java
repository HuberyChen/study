package test;

import java.io.File;

public class NewFilePath {

    public static void main(String args[]) {

        String filePath = "D:/rarTest";
        File file = new File(filePath);
        file.mkdirs();
        System.out.println("success");
    }
}
