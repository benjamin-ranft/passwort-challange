package de.neufische.passwortchallange;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswortArrayCheckTest {

    @Test
    void main() {

    }

    @Test
    public void checkPasswordLongEnoughTest() {
        String password = "HUNDEhaus";

        boolean isPasswordLongEnough = PasswortArrayCheck.checkPasswordLength(password);
        assertTrue(isPasswordLongEnough);
    }

    @Test
    public void checkPasswordTooShortTest() {
        String password = "Katze";

        boolean isPasswordTooShort = PasswortArrayCheck.checkPasswordLength(password);
        assertFalse(isPasswordTooShort);
    }

    @Test
    void checkIfPasswordContainsNumberTest() {
        String password = "Katzenhaus1";

        boolean PasswordContainsNumber = PasswortArrayCheck.checkIfPasswordContainsNumber(password);
        assertTrue(PasswordContainsNumber);
    }

    @Test
    void checkIfPasswordContainsNoNumberTest() {
        String password = "Katzenhaus";

        boolean PasswordContainsNoNumber = PasswortArrayCheck.checkIfPasswordContainsNumber(password);
        assertFalse(PasswordContainsNoNumber);
    }


    /*@Test
    void checkIfPasswordContainsUpperLowerCaseTest() {
        String password = "Katzenhaus";

        boolean passwordContainsUpperLowerCase = PasswortArrayCheck.checkIfPasswordContainsUpperLowerCase(password);
        assertTrue(passwordContainsUpperLowerCase);

    }*/

    /*@Test
    void checkIfPasswordContainsNoUpperLowerCaseTest() {
        String password = "katzenhaus";

        boolean passwordContainsNoUpperLowerCase = PasswortArrayCheck.checkIfPasswordContainsUpperLowerCase(password);
        assertFalse(passwordContainsNoUpperLowerCase);
    }*/

    @ParameterizedTest(name = "password {0} should return {1}")
    @CsvSource({
            "Katzenhaus,true",
            "katzenhaus, false",
            "KATZENHAUS, false",
    })
    public void passwordContainsUpperLowerCase(String password, boolean check){
        boolean UpperLowerCaseResult = PasswortArrayCheck.checkIfPasswordContainsUpperLowerCase(password);
        assertEquals(check, UpperLowerCaseResult);
    }


    @Test
    public void isPasswordArrayValidTest() {
        String [] passwords = {"Passwort123", "Passwort123", "Passwort123", "Passwort123", "Passwort123"};
        boolean allPasswordsRight = PasswortArrayCheck.isPasswordArrayValid(passwords);
        assertTrue(allPasswordsRight);
    }
    @Test
    public void isPasswordArrayNotValidTest() {
        String [] passwords = {"Passwort123", "Passwort", "Passwort123", "Passwort123", "Passwort123"};
        boolean onePasswordWrong = PasswortArrayCheck.isPasswordArrayValid(passwords);
        assertFalse(onePasswordWrong);
    }
}
