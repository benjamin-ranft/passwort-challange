package de.neufische.passwortchallange;

public class PasswortArrayCheck {

    public static void main(String[] args) {

        String [] passwords = {"1234", "BROTFÜRDIEWELT", "baumhaus", "Passwort123", "Jutesack"};

        System.out.println(isPasswordArrayValid(passwords));

        //System.out.println(passwords[2]);

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
