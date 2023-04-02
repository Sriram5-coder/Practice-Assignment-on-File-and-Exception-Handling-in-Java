import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperations {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        do {
            System.out.println("\nMenu based app - File Operations in Java\n");
            System.out.println("1. Create a new folder");
            System.out.println("2. Create a new text file");
            System.out.println("3. Write into a text file");
            System.out.println("4. Append data to a text file");
            System.out.println("5. Rename a file");
            System.out.println("6. Delete a file");
            System.out.print("\nPlease enter the Menu: ");
            try {
                choice = reader.readLine();
                switch (choice) {
                    case "1":
                        createFolder(reader);
                        break;
                    case "2":
                        createFile(reader);
                        break;
                    case "3":
                        writeToFile(reader);
                        break;
                    case "4":
                        appendToFile(reader);
                        break;
                    case "5":
                        renameFile(reader);
                        break;
                    case "6":
                        deleteFile(reader);
                        break;
                    default:
                        System.out.println("\nInvalid Menu Option. Please choose a valid option from the menu.");
                }
            } catch (IOException e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
            System.out.print("\nPress 'Y' to go back to the Main File-Operations Menu: ");
            try {
                choice = reader.readLine();
            } catch (IOException e) {
                choice = "N";
            }
        } while (choice.equalsIgnoreCase("Y"));
    }

    private static void createFolder(BufferedReader reader) {
        System.out.print("\nPlease enter the Folder-name to be Created: ");
        try {
            String folderName = reader.readLine();
            System.out.print("\nPlease enter the Path where you wish to save a new folder: ");
            String path = reader.readLine();
            File file = new File(path + File.separator + folderName);
            if (file.exists()) {
                System.out.println("\nFolder already exists.");
            } else {
                if (file.mkdir()) {
                    System.out.println("\nFolder is created Successfully!");
                } else {
                    System.out.println("\nFailed to create Folder. Please try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("\nError occurred: " + e.getMessage());
        }
    }

    private static void createFile(BufferedReader reader) {
        System.out.print("\nPlease enter the File-Name to be Created: ");
        try {
            String fileName = reader.readLine();
            System.out.print("\nPlease enter the Path where you wish to save the new file: ");
            String path = reader.readLine();
            File file = new File(path + File.separator + fileName);
            if (file.exists()) {
                System.out.println("\nFile already exists.");
            } else {
                if (file.createNewFile()) {
                    System.out.println("\nFile is created Successfully!");
                } else {
                    System.out.println("\nFailed to create File. Please try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("\nError occurred: " + e.getMessage());
        }
    }

    private static void writeToFile(BufferedReader reader) {
        System.out.print("\nPlease enter the path: ");
        try {
            String path = reader.readLine();
            System.out.print("\nPlease enter the File-Name: ");
            String fileName = reader.readLine();
            System.out.print("\nPlease enter the content to write: ");
            String content = reader.readLine();
            Path filePath = Paths.get(path, fileName);
            Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE);
            System.out.println("\nData is written to file successfully!");
        } catch (IOException e) {
            System.out.println("\nError occurred while writing to file: " + e.getMessage());
        }
    }

    private static void appendToFile(BufferedReader reader) {
        System.out.print("\nPlease enter the path: ");
        try {
            String path = reader.readLine();
            System.out.print("\nPlease enter the File-Name: ");
            String fileName = reader.readLine();
            System.out.print("\nPlease enter the content to append: ");
            String content = reader.readLine();
            Path filePath = Paths.get(path, fileName);
            Files.write(filePath, content.getBytes(), StandardOpenOption.APPEND);
            System.out.println("\nData is appended to file successfully!");
        } catch (IOException e) {
            System.out.println("\nError occurred while appending to file: " + e.getMessage());
        }
    }

    private static void renameFile(BufferedReader reader) {
        System.out.print("\nPlease enter the path: ");
        try {
            String path = reader.readLine();
            System.out.print("\nPlease enter the File-Name: ");
            String oldFileName = reader.readLine();
            System.out.print("\nPlease enter new File-Name: ");
            String newFileName = reader.readLine();
            Path oldFilePath = Paths.get(path, oldFileName);
            Path newFilePath = Paths.get(path, newFileName);
            Files.move(oldFilePath, newFilePath);
            System.out.println("\nFile is renamed successfully!");
        } catch (IOException e) {
            System.out.println("\nError occurred while renaming the file: " + e.getMessage());
        }
    }

    private static void deleteFile(BufferedReader reader) {
        System.out.print("\nPlease enter the path: ");
        try {
            String path = reader.readLine();
            System.out.print("\nPlease enter the File-Name: ");
            String fileName = reader.readLine();
            Path filePath = Paths.get(path, fileName);
            Files.deleteIfExists(filePath);
            System.out.println("\nFile is deleted successfully!");
        } catch (IOException e) {
            System.out.println("\nError occurred while deleting the file: " + e.getMessage());
        }
    }
}
