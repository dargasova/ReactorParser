package main;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class JSONReader extends FileHandler {

    @Override
    public boolean checkType(String filePath) {
        return filePath.endsWith(".json");
    }

    @Override
    public HashMap<String, Reactor> loadReactors(String filePath) {
        HashMap<String, Reactor> reactors = new HashMap<>();

        JSONParser parser = new JSONParser();

        try {
            JSONObject reactorsObj = (JSONObject) parser.parse(new FileReader(filePath));

            for (Object key : reactorsObj.keySet()) {
                String reactorClass = (String) key;
                JSONObject reactorData = (JSONObject) reactorsObj.get(reactorClass);

                Reactor reactor = new Reactor(
                        ((Number) reactorData.get("burnup")).doubleValue(),
                        reactorData.get("class").toString(),
                        ((Number) reactorData.get("electrical_capacity")).doubleValue(),
                        ((Number) reactorData.get("first_load")).doubleValue(),
                        ((Number) reactorData.get("kpd")).doubleValue(),
                        ((Number) reactorData.get("life_time")).doubleValue(),
                        ((Number) reactorData.get("termal_capacity")).doubleValue(),
                        "json"
                );

                reactors.put(reactorClass, reactor);
            }

        } catch (Exception ignored) {
        }


        return reactors;
    }

}
