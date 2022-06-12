package org.example;

import org.example.provider.ApplicationGlobalState;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class UserInterface {
    private final Controller controller = new Controller();

    public UserInterface() throws SQLException, ClassNotFoundException {
    }

    public void runApplication() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name of the city in English ");
            String city = scanner.nextLine();
            checkIsExit(city);
            setGlobalCity(city);

            System.out.println("Input:\n1 - Get the current weather," +
                    "\n2 - Get the weather for the next 5 days," +
                    "\n3 - Get the weather from Database" +
                    "\n0 - exit");
            String result = scanner.nextLine();

            checkIsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkIsExit(String result) throws SQLException, IOException {
        if (result == null || result.equals("0")) {
            controller.exitApp();
            exit(0);

        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }


    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws IOException, SQLException {
        controller.onUserInput(input);
    }

}
