package com.example.laba3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class ParserXML implements Parsing {

    @Override
    public void parse(File file, ArrayList<Reactor> reactorArrayList) {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); //кусок сода открывает файл для парсинга
        Document document = null;
        try {
            document = documentBuilderFactory.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Node rootNode = document.getFirstChild(); //создаем корневой нод = первому элементу файла

        NodeList rootChild = rootNode.getChildNodes();  //возвращает все, что хранится в корневом ноде, т.е. все типы реакторов с данными

        for (int i = 0; i < rootChild.getLength(); i++) {

            Node reactorNode = rootChild.item(i);

            NodeList reactorChilds = reactorNode.getChildNodes(); //возвращает все, что хранится в элементе массива, т.е. в одном типе реакторов

            String name = null;
            double burnup = 0;
            double kpd = 0;
            double enrichment = 0;
            double termal_capacity = 0;
            double electrical_capacity = 0;
            double life_time = 0;
            double first_load = 0;

            for (int j = 0; j < reactorChilds.getLength(); j++) {

                if (reactorChilds.item(j).getNodeType() != Node.ELEMENT_NODE) continue;

                switch (reactorChilds.item(j).getNodeName()) {
                    case "name": {
                        name = reactorChilds.item(j).getTextContent();
                        break;
                    }
                    case "burnup": {
                        burnup = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "kpd": {
                        kpd = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "enrichment": {
                        enrichment = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "termal_capacity": {
                        termal_capacity = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "electrical_capacity": {
                        electrical_capacity = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "life_time": {
                        life_time = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "first_load": {
                        first_load = Double.parseDouble(reactorChilds.item(j).getTextContent());
                    }
                }
            }

            String source = "XML";
            if (name != null) {
                Reactor reactor = new Reactor(name, burnup, kpd, enrichment, termal_capacity, electrical_capacity, life_time, first_load, source);
                reactorArrayList.add(reactor);

            }
        }
    }
}
