package cn.twilight.order;

import java.util.*;

public class DoSomething {
    public static void main(String[] args) {
        doChooseByCount(9);
    }

    private static void doChooseByCount(int count) {
        Double price = count * 20.0;
        Double sum = 0.0;
        List allDish = new ArrayList();
        List todayDish = new ArrayList();
        Integer wightSum = 0;
        Random random = new Random();
        int index = 0;

        for (ZuXinTuCaiCun_Menu dish : ZuXinTuCaiCun_Menu.values()) {
            allDish.add(dish);
            wightSum += dish.getWeight();
        }
        if (wightSum <= 0) System.err.println("Error: wightSum = " + wightSum.toString());
        while (sum <= price) {
            for (Object dish : allDish) {
                if (todayDish.contains(dish)) continue;
                Integer n = random.nextInt(wightSum);
                index += ((ZuXinTuCaiCun_Menu) dish).getWeight();
                if (n <= index) {
                    todayDish.add(dish);
                    sum += ((ZuXinTuCaiCun_Menu) dish).getCost();
                    break;
                }
            }
        }

        todayDish.forEach(dish -> System.out.println(((ZuXinTuCaiCun_Menu)dish).getName() + ":" + ((ZuXinTuCaiCun_Menu) dish).getCost()));
        System.out.println("金额: " + sum + "人均:" + sum/count);
    }
}
