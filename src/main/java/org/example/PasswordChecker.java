package org.example;

public class PasswordChecker {
    protected int minLength = -1;
    protected int maxRepeats = -1;

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLen) {
        if (minLen < 0) {
            throw new IllegalStateException("Длина пароля не может быть меньше 0");
        }
        minLength = minLen;
    }

    public int getMaxRepeats() {
        return maxRepeats;
    }

    public void setMaxRepeats(int maxRep) {
        if (maxRep <= 0) {
            throw new IllegalArgumentException("Количество повторений должно быть больше 0");
        }
        maxRepeats = maxRep;
    }

    public boolean verify(String password) {
        if (minLength == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Не заданы параметры проверки пароля!");
        }
        int counter = 0;
        char symbol = password.charAt(0);
        for (int i = 1; i < password.length(); i++) {
            if (symbol == password.charAt(i)) {
                counter++;
                if (counter >= maxRepeats) break;
            } else {
                symbol = password.charAt(i);
                counter = 0;
            }

        }
        return password.length() >= minLength && counter < maxRepeats;
    }
}
