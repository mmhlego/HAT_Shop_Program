package Model;

public class PasswordChecker {

    private enum STATUS {
        WEAK, NORMALL, POWERFULL, ULTIMATE
    }

    public static boolean LENGTH, NUMBER, SMALL, CAPS, SPECIAL = false;

    public static STATUS Strength(String Password) {
        int PasswordRate = 0;

        if (Password.length() < 8) {
            return STATUS.WEAK;
        } else if (Password.length() >= 10) {
            LENGTH = true;
            PasswordRate += 2;
        } else {
            LENGTH = true;
            PasswordRate += 1;
        }
        if (Password.matches("(?=.*[0-9]).*")) {
            NUMBER = true;
            PasswordRate += 2;
        }

        if (Password.matches("(?=.*[a-z]).*")) {
            SMALL = true;
            PasswordRate += 2;
        }

        if (Password.matches("(?=.*[A-Z]).*")) {
            CAPS = true;
            PasswordRate += 2;
        }

        if (Password.matches("(?=.*[~/\\!@#$%^&*()_-]).*")) {
            SPECIAL = true;
            PasswordRate += 2;
        }

        if (PasswordRate >= 9) {
            return STATUS.ULTIMATE;
        } else if (PasswordRate < 9 && PasswordRate >= 7) {
            return STATUS.POWERFULL;
        } else if (PasswordRate < 7 && PasswordRate >= 5) {
            return STATUS.NORMALL;
        } else if (PasswordRate < 5 && PasswordRate >= 3 && (LENGTH && (NUMBER || SMALL || CAPS || SPECIAL))) {
            return STATUS.WEAK;
        } else {
            return STATUS.WEAK;
        }

    }

    public static int CheckStrength(STATUS st) {
        switch (st) {
        case ULTIMATE:
            return 3;
        case POWERFULL:
            return 2;
        case NORMALL:
            return 1;
        case WEAK:
            return 0;
        default:
            return 0;
        }
    }
}
