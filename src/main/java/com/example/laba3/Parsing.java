package com.example.laba3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Parsing {

    public void parse(File file, ArrayList<Reactor> reactorArrayLis) throws FileNotFoundException;
}
