package com.example.laba3;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParserYAML implements Parsing {

    @Override
    public void parse(File file, ArrayList<Reactor> reactorArrayList) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(file);
        Yaml yaml = new Yaml(new Constructor(ReactorKind.class)); // используем экземпляр класса коструктор с типом reactorkind
        ReactorKind data = yaml.load(inputStream); // метод load() теперь возвращает экземпляр типа reactorkind
        reactorArrayList.addAll(data.getReactorKind()); // добавляем экземпляр в список реакторов
    }
}
