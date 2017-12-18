package main;

import getdata.GetDataRunner;
import getdata.GetUserInput;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GetUserInput getUserInput = new GetUserInput();
        GetDataRunner getDataRunner = new GetDataRunner(getUserInput);
        getDataRunner.getAllData();
    }

}
