package tdd;

public class PasswordCheck {
    public PasswordType check(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordType.INVALID;
        }

        if (s.length() < 8) {
            return PasswordType.NORMAL;
        }
        boolean containNumber = isContainNumber(s);
        if (!containNumber)
            return PasswordType.NORMAL;
        return PasswordType.STRONG;
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
