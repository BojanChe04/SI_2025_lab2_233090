
package org.example;

import java.util.List;
class Item {
    String name;
    int quantity; //numerical
    int price;
    double discount;

    public Item(String name, int quantity, int price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}


class SILab2 {
    public static double checkCart(List<Item> allItems, String cardNumber){//1
        if (allItems == null){//2
            throw new RuntimeException("allItems list can't be null!");//3
        }

        double sum = 0;//4

        for (int i = 0; i < allItems.size(); i++){//5
            Item item = allItems.get(i);//6
            if (item.getName() == null || item.getName().length() == 0){//7
                throw new RuntimeException("Invalid item!");//8
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){//9
                sum -= 30;//10
            }

            if (item.getDiscount() > 0){//11
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity();//12
            }
            else {
                sum += item.getPrice()*item.getQuantity();//13
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {//14
            String allowed = "0123456789";
            char[] chars = cardNumber.toCharArray();
            for (int j = 0; j < cardNumber.length(); j++) {//15
                char c = cardNumber.charAt(j);//16
                if (allowed.indexOf(c) == -1) {//17
                    throw new RuntimeException("Invalid character in card number!");//18
                }
            }
        }
        else{
            throw new RuntimeException("Invalid card number!");//19
        }

        return sum;//20

    }
}//21