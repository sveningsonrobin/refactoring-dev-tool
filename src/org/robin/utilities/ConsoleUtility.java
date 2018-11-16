package org.robin.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUtility {
    private static final String YES_ANSWER = "yes";

    public static boolean readQuestionResponse(String question) throws IOException {
        System.out.println(question);

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String answer = bufferedReader.readLine();

        boolean hasAnswer = answer != null;

        if (hasAnswer) {
            return answer.equals(YES_ANSWER);
        } else {
            return false;
        }
    }
}
