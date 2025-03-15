package program;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        intArrayList();
    }

    private static void intArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>(100);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(45)); //діапазон збільшено для більшої вірогідності відсутності декількох значень
        }
        System.out.println(numbers);

        // покроковий пошук та видалення дублікатів значень варіант 1 (довгий)
//        List<Integer> uniqueNumbers = new ArrayList<>();
//        for (int i = 0; i < numbers.size(); i++) {
//            boolean isDuplicate = false;
//
//            // Перевірка, чи це число вже є в `uniqueNumbers`
//            for (int j = 0; j < uniqueNumbers.size(); j++) {
//                if (numbers.get(i).equals(uniqueNumbers.get(j))){
//                    isDuplicate = true;
//                    break;
//                }
//            }
//            // Додаємо число, якщо воно унікальне
//            if (!isDuplicate){
//                uniqueNumbers.add(numbers.get(i));
//            }
//        }
//         System.out.println("Після видалення дублікатів: " + uniqueNumbers);

        // покроковий пошук та видалення дублікатів значень варіант 2 (з використанням contains)
        List<Integer> uniqueNumbers = new ArrayList<>();
        for(Integer number : numbers) {
            if(!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        System.out.println("Після видалення дублікатів: " + uniqueNumbers);

        //Використання HashSet для видалення дублікатів варіант 1
//        Set<Integer> uniqueNumbers = new HashSet<>();
//        numbers.forEach(num -> uniqueNumbers.add(num));

        //Використання HashSet для видалення дублікатів варіант 2
//        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
//        numbers = new ArrayList<>(uniqueNumbers);
//        System.out.println(numbers);

        //Використання LinkedHashSet для видалення дублікатів для збереження порядку варіант 1
//        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
//        numbers.forEach(num -> uniqueNumbers.add(num));

        //варіант 2
//        Set<Integer> set = new LinkedHashSet<>(numbers);
//        numbers = new ArrayList<>(set);
//        System.out.println(numbers);

        //System.out.println("Після видалення дублікатів: " + uniqueNumbers);

//друга частина, пошук відсутніх чисел
        // список для перевірки
        List<Integer> referenceList = new ArrayList<>();
        for(int i = 0; i <= 20; i++) {
            referenceList.add(i);
        }

        // список для збереження відсутніх чисел
        List<Integer> missingNumbers = new ArrayList<>();

        // Пошук відсутніх чисел
        for (int num : referenceList) {
            if (!uniqueNumbers.contains(num)) {
                missingNumbers.add(num);
            }
        }

        // Вивід результату
        System.out.println("Відсутні числа: " + missingNumbers);
    }
}