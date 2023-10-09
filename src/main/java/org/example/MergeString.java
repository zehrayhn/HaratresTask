package org.example;

public class MergeString {
    public String merge(String a, String b) {
        if ((a.length() <= 1 || a.length() >= 2500) || (b.length() <= 1 || b.length() >= 2500)) {
            throw new IllegalArgumentException("String uzunlukları 1 ile 2500 arasında olmalıdır.");
        }

        StringBuilder mergeString = new StringBuilder();

        int length = Math.min(a.length(), b.length());

        for (int i = 0; i < length; i++) {
            mergeString.append(a.charAt(i)).append(b.charAt(i));
        }

        if (a.length() > length) {
            mergeString.append(a.substring(length));
        } else if (b.length() > length) {
            mergeString.append(b.substring(length));
        }

        return mergeString.toString();
    }

    public String showMerge() {
        String a = "hrte";
        String b = "aars";

        String sumAsString = merge(a, b);
        return sumAsString;
    }
}
