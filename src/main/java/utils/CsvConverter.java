package utils;

import models.*;
import utils.validators.ContractValidator;
import utils.validators.MobileValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvConverter {
    public Repository csvToRepository(String file,Repository repository){
        String line;
        String[] arr;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ContractValidator contractValidator=new ContractValidator();
        MobileValidator mobileValidator=new MobileValidator();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while (!Objects.equals(line = br.readLine(), "")){
                arr=line.split(";");
                List<String> valresult;
                Person person=new Person(Integer.parseInt( arr[4]),arr[5],
                        LocalDate.parse(arr[6],formatter),arr[7],arr[8]);
                switch (arr[9]){
                    case ("Internet"):
                        InternetContract internetContract= new InternetContract(Integer.parseInt( arr[0]),
                                LocalDate.parse(arr[1],formatter),LocalDate.parse(arr[2],formatter),
                                Integer.parseInt( arr[3]),person, Integer.parseInt( arr[10]));
                         valresult= contractValidator.validate(internetContract);
                        if (valresult.isEmpty()){
                            repository.add(internetContract);
                        }

                        break;
                    case ("Mobile"):
                        MobileContract mobileContract=new MobileContract(Integer.parseInt( arr[0]),
                                LocalDate.parse(arr[1],formatter),LocalDate.parse(arr[2],formatter),
                                Integer.parseInt( arr[3]),person,Integer.parseInt( arr[10]),
                                Integer.parseInt( arr[11]), Integer.parseInt( arr[12]));
                         valresult= mobileValidator.validate(mobileContract);
                        if (valresult.isEmpty()){
                            repository.add(mobileContract);
                        }
                        break;
                    case ("Television"):
                        TelevisionContract televisionContract=new TelevisionContract(Integer.parseInt( arr[0]),
                                LocalDate.parse(arr[1],formatter),LocalDate.parse(arr[2],formatter),
                                Integer.parseInt( arr[3]),person,stringToChannel(arr[10]));
                        valresult= contractValidator.validate(televisionContract);
                        if (valresult.isEmpty()){
                            repository.add(televisionContract);
                        }
                        break;
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return repository;
    }
    private List<Channels> stringToChannel(String string){
        List<Channels> list=new ArrayList<>();
        String[] arr=string.split(" ");
        for (String el: arr) {
            for (Channels channel:Channels.values()) {
                if (channel.toString().equals(el)){
                    list.add(channel);
                }
            }
        }
        return list;
    }
}
