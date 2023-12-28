import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encode {

    public static void main(String[] args) {
        String sourcePdfPath = "path/to/your/source.pdf"; // Path to the PDF file
        String outputTxtPath = "path/to/your/output.txt"; // Path to the output text file

        try {
            byte[] pdfBytes = Files.readAllBytes(Paths.get(sourcePdfPath));
            String hexString = bytesToHex(pdfBytes);
            writeStringToFile(hexString, outputTxtPath);
            System.out.println("PDF converted to hex and saved to " + outputTxtPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    private static void writeStringToFile(String str, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(str);
        }
    }
}
