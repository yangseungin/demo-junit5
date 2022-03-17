package tdd;

public class PasswordCheck {
    public PasswordType check(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordType.INVALID;
        }
        int metCount = getMetCount(s);

        if (metCount <= 1) {
            return PasswordType.WEAK;
        }
        if (metCount == 2) {
            return PasswordType.NORMAL;
        }

        return PasswordType.STRONG;
    }

    private int getMetCount(String s) {
        int metCount = 0;

        if (s.length() >= 8) {
            metCount++;
        }
        if (isContainNumber(s)) {
            metCount++;
        }
        if (isContainUpper(s)) {
            metCount++;
        }
        return metCount;
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
