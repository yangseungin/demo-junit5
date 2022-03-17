package tdd;

public class PasswordCheck {
    public PasswordType check(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordType.INVALID;
        }

        boolean containNumber = isContainNumber(s);
        boolean containUpper = isContainUpper(s);
        boolean lengthEnough = s.length() >= 8;

        if (lengthEnough && !containNumber && !containUpper) {
            return PasswordType.WEAK;
        }
        if (!lengthEnough && containNumber && !containUpper) {
            return PasswordType.WEAK;
        }
        if (!lengthEnough && !containNumber && containUpper) {
            return PasswordType.WEAK;
        }

        if (!lengthEnough) {
            return PasswordType.NORMAL;
        }
        if (!containNumber)
            return PasswordType.NORMAL;

        if (!containUpper)
            return PasswordType.NORMAL;


        return PasswordType.STRONG;
    }

    private boolean isContainUpper(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainNumber(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
