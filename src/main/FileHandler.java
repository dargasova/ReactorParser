package main;

import java.util.HashMap;

public abstract class FileHandler {
    FileHandler nextFileHandler;

    public abstract boolean checkType(String filePath);

    public abstract HashMap<String, Reactor> loadReactors(String filePath);

    public void setNextFileHandler(FileHandler nextFileHandler) {
        this.nextFileHandler = nextFileHandler;
    }

    public HashMap<String, Reactor> commonloadReactors(String filePath) {
        HashMap<String, Reactor> reactors;
        if (checkType(filePath)) {
            reactors = loadReactors(filePath);
        } else {
            reactors = nextFileHandler.commonloadReactors(filePath);
        }
        return reactors;
    }
}
