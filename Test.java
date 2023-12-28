import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HexFormat;

public class HexToPdfJava11 {

    public static void main(String[] args) {
        String inputHexFilePath = "path/to/your/samplehex.txt"; // Path to the hex file
        String outputPdfPath = "path/to/your/output.pdf"; // Path to the output PDF file

        try {
            String hexString = Files.readString(Path.of(inputHexFilePath));
            byte[] pdfBytes = HexFormat.of().parseHex(hexString);
            Files.write(Path.of(outputPdfPath), pdfBytes);
            System.out.println("Hex string converted to PDF and saved to " + outputPdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
