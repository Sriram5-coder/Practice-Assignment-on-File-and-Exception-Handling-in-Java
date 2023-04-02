import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Characters_count {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Display the total number of characters of a Text File\n");

        try {
            System.out.print("Enter the file name: ");
            String fileName = reader.readLine();

            File file = new File(fileName);

            if (!file.exists() || !file.isFile()) {
                System.out.println("Error: Invalid file name or file does not exist.");
                return;
            }

            FileReader fileReader = new FileReader(file);

            int charCount = 0;
            int charValue;

            while ((charValue = fileReader.read()) != -1) {
                charCount++;
            }

            System.out.println("Total number of characters in file are: " + charCount);
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
