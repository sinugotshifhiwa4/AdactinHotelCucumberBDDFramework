package adactinHotel.webUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileGenerator {

    private final String filePath = "src/test/resources/orderNumber.txt";

    // Exception handling methods
    private void handleException(String methodName, Exception e){

        throw new CustomExceptions("Exception occurred in " + methodName + ": " + e.getMessage(),e);
    }

    public void writeToFile(String orderNumber) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(orderNumber);
        } catch (IOException e) {
           handleException("writeToFile", e);
        }
    }

    public String readFromFile() {
        String orderNumFromFile = null;

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            if (myReader.hasNextLine()) {
                orderNumFromFile = myReader.nextLine();
            }

        } catch (FileNotFoundException e) {
            handleException("readFromFile", e);
        }

        return orderNumFromFile;
    }
}
