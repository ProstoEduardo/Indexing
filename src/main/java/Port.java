import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Port {

    private final String[] indexes;

    public Port(String[] indexes) {
        this.indexes = indexes;
    }

    // Метод разложения массива строк в массив чисел
    public List<Integer> arrayDecomposition() {
        List<Integer> list = new ArrayList<>();
        for (String s : indexes) {
            list.addAll(stringDecomposition(s));
        }
        return list;
    }

    // Метод разложения строки в массив чисел
    public List<Integer> stringDecomposition(String s){
        if(s.equals("") || s.equals("-") || s.equals(",")) {
            try {
                throw new Exception("Вы ввели неверный формат строки");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Integer> list = new ArrayList<>();
        if (s.contains(",")) {
            String[] str = s.split(",");
            for (String elem : str) {
                if (elem.contains("-")) {
                    expandLine(elem, list);
                } else list.add(Integer.parseInt(elem));
            }
        } else if (s.contains("-")) {
            expandLine(s, list);
        } else list.add(Integer.parseInt(s));
        return list;
    }

    // метод раскрытия строки с "-"
    public void expandLine(String str, List<Integer> list) {
        String[] array = str.split("-");
        int prev = Integer.parseInt(array[0]);
        int next = Integer.parseInt(array[1]);
        while (prev <= next) {
            list.add(prev);
            prev++;
        }
    }

    // метод нахождения всех комбинаций массива
    public Set<List<Integer>> arrayCombinations() {
        List<List<Integer>> resultList = new ArrayList<>();
        for (String s : indexes) {
            resultList.add(stringDecomposition(s)); // добавили в resultList, разложенные массивы
        }
        Set<List<Integer>> resultSet = new HashSet<>();
        findingArrayElements(0, new ArrayList<>(), resultList, resultSet);
        return resultSet;
    }

    // метод нахождения комбинации массива
    public void findingArrayElements(int index, List<Integer> list, List<List<Integer>> resultList, Set<List<Integer>> resultSet) {
        if (index == resultList.size()) {
            resultSet.add(list);
        } else {
            List<Integer> arrayElement = resultList.get(index);
            for (Integer number : arrayElement) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(number);
                findingArrayElements(index + 1, newList, resultList, resultSet);
            }
        }
    }
}
