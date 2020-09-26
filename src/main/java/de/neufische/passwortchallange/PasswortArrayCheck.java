package de.neufische.passwortchallange;


import java.util.Arrays;

public class PasswortArrayCheck {

    public static void main(String[] args) {

        String [] passwords = {"1234", "BROTFÜRDIEWELT", "baumhaus", "Passwort123", "Jutesack"};

        System.out.println(isPasswordArrayValid(passwords));


        System.out.println(passwords[2]);

        String[][] passwordsTwoDim = checkAllPasswordsAndPutItIntoTwoDimArray(passwords);
        //'Arrays.deepToString()' converts multi-dimensional array to strings
        System.out.println(Arrays.deepToString(passwordsTwoDim));
    }


    public static boolean isPasswordArrayValid(String[] passwords){

        for (int i = 0; i < passwords.length; i++){
            String singlePassword = passwords[i];
            boolean isLengthValid = checkPasswordLength(singlePassword);
            boolean isUpperLowerValid = checkIfPasswordContainsUpperLowerCase(singlePassword);
            boolean isNumberPresent = checkIfPasswordContainsNumber(singlePassword);
            boolean isValidPassword = isLengthValid && isUpperLowerValid && isNumberPresent;
            if (!isValidPassword) {
                return false;
            }
        }
        return true;
    }

    public static String[][] checkAllPasswordsAndPutItIntoTwoDimArray (String[] passwords) {
        int k = 4;
        String[][] array2D = new String[passwords.length][k];
        for (int i = 0; i < passwords.length; i++) {
            String singlePassword = passwords[i];
            //'String.valueOf' cast boolean to string
            //'toString()' cast int, double...
            String isLengthValid = String.valueOf(checkPasswordLength(singlePassword));
            String isUpperLowerValid = String.valueOf(checkIfPasswordContainsUpperLowerCase(singlePassword));
            String isNumberPresent = String.valueOf(checkIfPasswordContainsNumber(singlePassword));

            //while-loop works because fist index increments in the loop

            int zeile = i;
            while (zeile < passwords.length){
                array2D[zeile][0] = singlePassword;
                array2D[zeile][1] = isLengthValid;
                array2D[zeile][2] = isUpperLowerValid;
                array2D[zeile][3] = isNumberPresent;
                zeile++;
            }

            //for-loop dosn`t work because fist index increments after the loop

            /*for (int zeile = 0; zeile < array2D.length; zeile++) {
            array2D[zeile][0] = singlePassword;
            array2D[zeile][1] = isLengthValid;
            array2D[zeile][2] = isUpperLowerValid;
            array2D[zeile][3] = isNumberPresent;
        }*/

        }return array2D;
    }

    public static boolean checkPasswordLength (String password){
        int minLength = 8;
        int actualLength = password.length();
        return actualLength >= minLength;
    }

    public static boolean checkIfPasswordContainsNumber (String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean checkIfPasswordContainsUpperLowerCase(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        if(hasUppercase && hasLowercase == true) {
            return true;
        }
        return false;
    }

}
