package main;

import java.util.HashMap;

public class Client {
    public HashMap<String, Reactor> readCommonClass(String filePath) {
        JSONReader jsonReader = new JSONReader();
        XMLReader xmlReader = new XMLReader();
        YAMLReader yamlReader = new YAMLReader();

        yamlReader.setNextFileHandler(xmlReader);
        xmlReader.setNextFileHandler(jsonReader);

        return yamlReader.commonloadReactors(filePath);
    }
}
