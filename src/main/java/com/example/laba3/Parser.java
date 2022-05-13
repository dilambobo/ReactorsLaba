package com.example.laba3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Parser {

    private final ArrayList<Reactor> reactorArrayList = new ArrayList<>();

    public Parser(File file) throws FileNotFoundException {
        String extension = getFileExtension(file);
        switch (extension) {
            case ("json"): {
                ParserJSON jsonPars = new ParserJSON();
                jsonPars.parse(file, reactorArrayList);
                break;
            }
            case ("xml"): {
                ParserXML xmlPars = new ParserXML();
                xmlPars.parse(file, reactorArrayList);
                break;
            }
            case ("yaml"): {
                ParserYAML yamlPars = new ParserYAML();
                yamlPars.parse(file, reactorArrayList);
                break;
            }
        }
    }

    public ArrayList<Reactor> getReactorArrayList() {
        return reactorArrayList;
    }

    // ф-я получения расширения файла
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".")+1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }
}
