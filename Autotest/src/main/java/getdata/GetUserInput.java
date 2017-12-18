package getdata;

import processinfo.WriteToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GetUserInput {

    public void getUserInput() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader userInput = new BufferedReader(inputStreamReader);
        String chooseDetails = "";

        while (!checkIfUserEntersYesOrNo(chooseDetails)) {
            System.out.println("Would you like to enter the details yourself? (Yes/No)");
            chooseDetails = userInput.readLine();
        }

        if (chooseDetails.toLowerCase().equals("yes")) {
            WriteToFile writeToFile = new WriteToFile();

            String chooseToStop = "";

            do {
                String userSuggestedCityNameAndCountryCode = "";
                userSuggestedCityNameAndCountryCode = getMultipleInputs(userInput, inputStreamReader);
                writeToFile.writeToFile("\n" + userSuggestedCityNameAndCountryCode, "input.txt", true);
                System.out.println("Keep adding cities and country codes until You wish. Write 'exit' to stop, anything else to continue.");
                chooseToStop = userInput.readLine();
            } while (!chooseToStop.equals("exit"));
            userInput.close();
        }
        else {
            userInput.close();
            System.out.println("The program will use default settings.");
        }
    }

    private boolean checkCountryCodeLength(String userSuggestedCountryCode) {
        return userSuggestedCountryCode.length() == 2;
    }

    private boolean checkCityNameLength(String userSuggestedCityNameAndCountryCode) {
        return userSuggestedCityNameAndCountryCode.length() > 0 && userSuggestedCityNameAndCountryCode.length() < 16;
    }

    private boolean checkIfUserEntersYesOrNo(String chooseDetails) {
        return chooseDetails.toLowerCase().equals("no") || chooseDetails.toLowerCase().equals("yes");
    }

    private String getMultipleInputs(BufferedReader userInput, InputStreamReader is) throws IOException {
        String userSuggestedCityNameAndCountryCode = "";
        while (!checkCityNameLength(userSuggestedCityNameAndCountryCode)) {
            System.out.println("Enter a city name! (1-16 characters)");
            userSuggestedCityNameAndCountryCode = userInput.readLine();
        }
        String userSuggestedCountryCode = "";
        while (!checkCountryCodeLength(userSuggestedCountryCode)) {
            System.out.println("Enter a country code (2 letters)!");
            userSuggestedCountryCode = userInput.readLine();
        }
        userSuggestedCityNameAndCountryCode += "," + userSuggestedCountryCode;

        return userSuggestedCityNameAndCountryCode;
    }
}
