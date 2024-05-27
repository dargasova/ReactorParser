package main;

import java.util.HashMap;

public abstract class DateHandler {
    DateHandler nextDateHandler;

    public abstract boolean checkType(String filePath);

    public abstract HashMap<String, Reactor> loadReactors(String filePath);

    public void setNextDateHandler(DateHandler nextDateHandler) {
        this.nextDateHandler = nextDateHandler;
    }

    public HashMap<String, Reactor> commonloadReactors(String filePath) {
        HashMap<String, Reactor> reactors;
        if (checkType(filePath)) {
            reactors = loadReactors(filePath);
        } else {
            reactors = nextDateHandler.commonloadReactors(filePath);
        }
        return reactors;
    }
}
