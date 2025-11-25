package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void writeProductToFile(String filePath, String productName, String productPrice) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // true -> mevcut dosyaya ekleme yapar, yoksa oluşturur
            writer.write("Ürün Adı: " + productName);
            writer.newLine();
            writer.write("Ürün Fiyatı: " + productPrice);
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
