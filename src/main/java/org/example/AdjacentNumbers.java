package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacentNumbers {
    public String findAdjacentNumbers(ArrayList<Integer> numberList) {

        int minimumSubtract = Integer.MAX_VALUE;
        List<String> numberListString = new ArrayList<>();

        for (int i = 0; i < numberList.size() - 1; i++) {
            for (int j = i + 1; j < numberList.size(); j++) {
                int subtract = Math.abs(numberList.get(i) - numberList.get(j));
                if (subtract != 0 && subtract < minimumSubtract) {
                    minimumSubtract = subtract;

                    numberListString.clear();
                    numberListString.add(numberList.get(i) + " " + numberList.get(j));
                } else if (subtract != 0 && subtract == minimumSubtract) {

                    String dual = numberList.get(i) + " " + numberList.get(j);
                    if (!numberListString.contains(dual)) {
                        numberListString.add(dual);
                    }
                }
            }
        }

        String minimumSubtractString = Integer.toString(minimumSubtract);

        Collections.sort(numberListString);
        StringBuilder numberListStringBuilder = new StringBuilder();
        for (String item : numberListString) {
            numberListStringBuilder.append("\"").append(item).append("\"").append(", ");
        }

        if (!numberListString.isEmpty()) {
            numberListStringBuilder.setLength(numberListStringBuilder.length() - 2);
        }

        return "D={" + numberListStringBuilder + "}";

    }

    public String showAdjacentNumbers() {
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(32);
        numberList.add(41);
        numberList.add(12);
        numberList.add(15);
        numberList.add(21);
        numberList.add(32);
        numberList.add(48);
        numberList.add(35);
        try {

            boolean result = isNumberListCorrect(numberList);

            if (!result) {
                throw new ConstraintException("Hata: Sayılar sınırların dışında");
            }

        } catch (ConstraintException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

        String sumAsString = findAdjacentNumbers(numberList);
        return sumAsString;
    }

    public boolean isNumberListCorrect(ArrayList<Integer> numberList) {
        for (int sayi : numberList) {
            if (sayi < -20000  || sayi > 2000) {
                return false;
            }
        }
        return numberList.size() > 0 && numberList.size() < 100;
    }
}
