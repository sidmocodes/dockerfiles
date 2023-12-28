import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.xml.bind.DatatypeConverter;

public class HexToPdfJava8 {

    public static void main(String[] args) {
        String inputHexFilePath = "path/to/your/samplehex.txt"; // Path to the hex file
        String outputPdfPath = "path/to/your/output.pdf"; // Path to the output PDF file

        try {
            String hexString = new String(Files.readAllBytes(Path.of(inputHexFilePath)));
            byte[] pdfBytes = DatatypeConverter.parseHexBinary(hexString);
            Files.write(Path.of(outputPdfPath), pdfBytes);
            System.out.println("Hex string converted to PDF and saved to " + outputPdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
