package DrawableProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


@SuppressWarnings("unused")
public class DrawableTestFile {
    public static void main(String[] args) {
        Scanner inputScanner = null;
        PrintWriter outputWriter = null;

        try {
            inputScanner = new Scanner(new File("C:\\Users\\Ahmed\\eclipse-workspace\\DrawableProject\\src\\DrawableProject\\input.txt"));
            outputWriter = new PrintWriter(new File("C:\\Users\\Ahmed\\eclipse-workspace\\DrawableProject\\src\\DrawableProject\\output.txt"));

            int numDrawables;
            try {
                if (!inputScanner.hasNextInt()) { 
                    throw new IllegalArgumentException("Input file is empty or invalid number of drawables.");
                }
                numDrawables = inputScanner.nextInt();
                if (numDrawables < 2) {
                    throw new IllegalArgumentException("At least 2 drawables are required.");
                }
            } catch (IllegalArgumentException e) {
                writeErrorToOutput(outputWriter, "Error: " + e.getMessage());
                System.err.println("Error occurred, check 'output.txt' for details.");
                return; 
            }

            Drawable[] drawables = new Drawable[numDrawables];

            for (int i = 0; i < numDrawables; i++) {
                String shapeType;
                double size;

                try {
                    shapeType = inputScanner.next();  
                    size = inputScanner.nextDouble();      
                    if (size <= 0) {
                        throw new IllegalArgumentException("Size must be a positive number for " + shapeType);
                    }

                    if (shapeType.equalsIgnoreCase("circle")) {
                        drawables[i] = new Circle(size);
                    } else if (shapeType.equalsIgnoreCase("cube")) {
                        drawables[i] = new Cube(size);
                    } else {
                        throw new IllegalArgumentException("Invalid shape type: " + shapeType);
                    }
                } catch (NoSuchElementException e) { 
                    writeErrorToOutput(outputWriter, "Error: Fewer shapes provided than specified in the input file. Expected " + numDrawables + ", but got " + i + ".");
                    System.err.println("Error occurred, check 'output.txt' for details.");
                    return;
                } catch (IllegalArgumentException e) {
                    writeErrorToOutput(outputWriter, "Error: " + e.getMessage() + " in object " + (i+1) + ".");
                    System.err.println("Error occurred, check 'output.txt' for details.");
                    return;
                }
            }


            if (inputScanner.hasNext()) {
                writeErrorToOutput(outputWriter, "Error: Extra input found after processing all specified shapes.");
                System.err.println("Error occurred, check 'output.txt' for details.");
                return;
            }

            double totalArea = 0;
            for (Drawable drawable : drawables) {
                totalArea += drawable.getArea();
            }

 
            writeResultToOutput(outputWriter, "Sum of areas: " + totalArea);
            System.out.println("Result written in 'output.txt' .");

        } catch (FileNotFoundException e) {
            writeErrorToOutput(outputWriter, "Error: Input file not found.");
            System.err.println("Error occurred, check 'output.txt' for details.");
        } finally {
        	
            if (inputScanner != null) {
                inputScanner.close();
            }
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }

   
    private static void writeErrorToOutput(PrintWriter writer, String message) {
        if (writer != null) {
            writer.println(message);
        }
    }

    
    private static void writeResultToOutput(PrintWriter writer, String message) {
        if (writer != null) {
            writer.println(message);
        }
    }
}
