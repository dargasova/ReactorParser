package main;

import java.util.HashMap;

public class FileReaderChain {
    public HashMap<String, Reactor> readCommonClass(String filePath) {
        JSONReader jsonReader = new JSONReader();
        XMLReader xmlReader = new XMLReader();
        YAMLReader yamlReader = new YAMLReader();

        yamlReader.setNextDateHandler(xmlReader);
        xmlReader.setNextDateHandler(jsonReader);

        return yamlReader.commonloadReactors(filePath);
    }
}
