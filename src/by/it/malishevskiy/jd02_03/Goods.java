package by.it.malishevskiy.jd02_03;

import java.util.HashMap;

public class Goods {
    public static HashMap<String, Integer> pricelist = new HashMap<>();

    public static void fillPricelist() {
        pricelist.put("Хлеб", 10);
        pricelist.put("Масло", 15);
        pricelist.put("Молоко", 20);
        pricelist.put("Сыр", 24);
        pricelist.put("Сок", 12);
        pricelist.put("Батон", 10);
        pricelist.put("Вода", 12);
        pricelist.put("Сметана", 13);
    }
}
