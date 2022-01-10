package repos;

import models.Kunde;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KundeFileRepo implements ICrudRepo<Kunde> {

    private File file;

    public KundeFileRepo(){
        file = new File("kunden.txt");
    }
    
    public List<Kunde> getAll(){
        List<Kunde> toReturn = new ArrayList<Kunde>();
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                List<String> values = new ArrayList<String>();
                try (Scanner rowScanner = new Scanner(scanner.nextLine())){
                    rowScanner.useDelimiter(",");
                    while(rowScanner.hasNext()){
                        values.add(rowScanner.next());
                    }
                    if(values.size() > 0){
                        Kunde toAdd = new Kunde(Integer.parseInt(values.get(0)),values.get(1),enums.Grosse.valueOf(values.get(2)),Integer.parseInt(values.get(3)),Integer.parseInt(values.get(4)),values.get(5));
                        toReturn.add(toAdd);
                    }

                }

            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        return toReturn;
    }
}
