package controllers;

import models.Kunde;
import repos.ICrudRepo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KundeController {
    private ICrudRepo<Kunde> kundeRepo;

    public KundeController(ICrudRepo<Kunde> kundeRepo) {
        this.kundeRepo = kundeRepo;
    }

    public void generateSortedList(){

        List<Kunde> all = kundeRepo.getAll();
        all.sort((t,tother)->Integer.compare(t.getAnzahlMitarbeiter(),tother.getAnzahlMitarbeiter()));

        try{
            FileWriter myWriter = new FileWriter("kundensortiert.txt",false);
            for(Kunde t : all){
                myWriter.write(t.toCSV());
            }
            myWriter.close();
        }catch (IOException e){
            System.out.println("Error");
        }
    }

    public void generateStatistik(){
        Map<String,Integer> orte = new HashMap<String,Integer>();
        List<Kunde> all = kundeRepo.getAll();
        for(Kunde k : all){
            if(!orte.containsKey( k.getOrt())){
                orte.put(k.getOrt(),k.getEinkommen());
            }else{
                orte.put(k.getOrt(),orte.get(k.getOrt())+k.getEinkommen());
            }
        }
       orte = (Map<String, Integer>) orte.entrySet().stream().sorted(Map.Entry.comparingByValue());
        try{
            FileWriter myWriter = new FileWriter("statistic.txt",false);
          for(Map.Entry<String,Integer> entry : orte.entrySet()){
              myWriter.write(entry.getKey() + ": " +entry.getValue());
          }
            myWriter.close();
        }catch (IOException e){
            System.out.println("Error");
        }
    }


    
}
