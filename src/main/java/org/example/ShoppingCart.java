package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {


    public String showDiscount() {

        int[] priceList = {5, 6, 4, 3, 4};

        String output = giveDiscount(priceList);

        return output;
    }

    public String giveDiscount(int[] priceList) {
        try {

            boolean result = isNumberListCorrect(priceList);

            if (!result) {
                throw new ConstraintException("Hata: Sayılar sınırların dışında");
            }

        } catch (ConstraintException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
        }

        int[] discountedPricesList = new int[priceList.length];

        for (int i = 0; i < priceList.length - 1; i++) {
            int currentPrice = priceList[i];
            int nextPrice = priceList[i + 1];

            if (nextPrice < currentPrice) {
                int discount = currentPrice - nextPrice;
                discountedPricesList[i] = discount;
            } else {
                discountedPricesList[i] = currentPrice;
            }
        }

        discountedPricesList[priceList.length - 1] = priceList[priceList.length - 1];


        int sum = 0;

        for (int num : discountedPricesList) {
            sum = sum + num;

        }
        //  System.out.println("Dizi elemanları toplamı : " + sum);

        List<Integer> nonDiscountedItemsList = new ArrayList<>();


        for (int i = 0; i < priceList.length; i++) {
            if (priceList[i] == discountedPricesList[i]) {
                nonDiscountedItemsList.add(priceList[i]);
            }
        }


        StringBuilder nonDiscountedItemsListString = new StringBuilder();

        Collections.sort(nonDiscountedItemsList);
        for (int item : nonDiscountedItemsList) {
            nonDiscountedItemsListString.append(item).append(", ");
        }

        if (nonDiscountedItemsListString.length() > 0) {
            nonDiscountedItemsListString.setLength(nonDiscountedItemsListString.length() - 2);
        }
        String output = ("Toplam tutar: " + sum + ", İndirim yapılmayan kalemler, C= { " + (nonDiscountedItemsListString) + "}");


        return output;

    }



    public boolean isNumberListCorrect(int[] priceList) {
        for (int sayi : priceList) {
            if (sayi < 0 || sayi > 2000) {
                return false;
            }
        }
        return priceList.length > 0 && priceList.length < 100;
    }


}