import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
    public static void main(String[] args) {

        String inputImagePath = "C:/Dog2.jpeg";
        String outputImagePath1 = "C:/ImageCopies";

        try (
            FileInputStream fis = new FileInputStream(inputImagePath);
            FileOutputStream fos1 = new FileOutputStream(outputImagePath1);
            
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos1.write(buffer, 0, bytesRead); // Write to first copy
                
            }

            System.out.println("Image copied successfully to both Outputdog1.jpeg and Outputdog2.jpeg in C:/ImageCopies!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
