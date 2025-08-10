import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise5 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("source.jpg");
             FileOutputStream fos = new FileOutputStream("copy.jpg")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Image copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}