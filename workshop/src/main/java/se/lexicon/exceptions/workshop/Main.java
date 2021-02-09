package se.lexicon.exceptions.workshop;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;



public class Main {



	public static void main(String[] args) throws IOException {

        System.out.println(" *****************************\n" +
                " *** Best App ever created *** \n" +
                " *****************************\n");

        // some heap testing
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        Scanner sc = new Scanner(System.in);
        List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        List<String> lastNames = null;

        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            System.out.println(" Error message: " + e.getMessage());
        }
        NameService ns = new NameService(maleFirstNames, femaleFirstNames, lastNames);

        // Uncomment if you want to try out Custom exceptions
        //ns.addFemaleFirstName("Nora");
        //ns.addMaleFirstName("Jocko");
        //ns.addLastName("Samuelsson");

	    while(true) {
            NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);
            Person test = nameService.getNewRandomPerson();
            System.out.println(test);

            System.out.println("Do you want to add a male name to the list? \n Y/N");
            String input = sc.nextLine();
            System.out.println(input);

            if(input.equalsIgnoreCase("y")) {
                // Add to the males
                System.out.println(" Type a name that you want to add a name: ");
                //System.out.println(heapFreeSize);
                input = sc.nextLine();
                //System.out.println(heapFreeSize - Runtime.getRuntime().freeMemory());
                boolean nameIsAdded = addNewName(input);

                if(nameIsAdded) {
                    System.out.println(" Name " + input + " was added to the list.");
                } else {
                    System.out.println(" Error accrued ");
                }
            }
            //sc.close();
        }
	}



    public static boolean addNewName(String name) {

	    boolean result = false;

        FileSystem fileSystem= FileSystems.getDefault();
        Path path= fileSystem.getPath("C:\\Users\\deltagare\\Desktop\\workshop-exception\\workshop\\firstname_males.txt");
        //StringBuffer str = new StringBuffer(name);
        //str.append(',').toString();
        //System.out.println(str);

        try {
            Files.write(path, name.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }



}
