import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PortTest {

    @Test
    void arrayDecompositionTest() {
        String[] arr = new String[]{"1,2,5", "2", "3-5"};
        Port port = new Port(arr);
        List<Integer> list = new ArrayList<>(port.arrayDecomposition());

        assertEquals(list, List.of(1, 2, 5, 2, 3, 4, 5));

        assertNotEquals(list, List.of(1, 2, 5, 2, 3, 4, 3, 5));
        assertNotEquals(list, List.of(1, 2, 2, 3, 4, 3, 5));
        assertNotEquals(list, List.of(1, 2, 5, 2, 3, 4, 3, 4, 5, 4));
    }

    @Test
    void arrayDecompositionTestWhenEmptyArray() {
        String[] arr = new String[]{};
        Port port = new Port(arr);
        List<Integer> list = new ArrayList<>(port.arrayDecomposition());

        assertEquals(list, new ArrayList<>());
        assertNotEquals(list, List.of(1, 2, 5));
        assertNotEquals(list, List.of(1));
        assertNotEquals(list, List.of(1, 2, 5, 2, 3, 4, 3, 4, 5, 4));
    }

    @Test
    void arrayDecompositionTestWhenAnArrayWithOneElement(){
        String[] arr = new String[]{"1"};
        Port port = new Port(arr);
        List<Integer> list = new ArrayList<>(port.arrayDecomposition());

        assertEquals(list, List.of(1));
        assertNotEquals(list, List.of(1, 2, 5));
        assertNotEquals(list, List.of(1, 2, 5, 2, 3, 4, 3, 4, 5, 4));
    }

    @Test
    void arrayDecompositionTestWhenAnInvalidStringFormatIsEntered(){
        String[] arr = new String[]{"-"};
        Port port = new Port(arr);
        List<Integer> list = new ArrayList<>();
        try {
            list.addAll(port.arrayDecomposition());
            fail("Вы ввели неверный формат строки");
        } catch (Exception thrown) {
            assertNotEquals("", thrown.getMessage());
        }
        assertNotEquals(list, List.of(1, 2, 5));
        assertNotEquals(list, List.of(1, 2, 5, 2, 3, 4, 3, 4, 5, 4));
    }


    @Test
    void arrayCombinationsTest(){
        String[] arr = new String[]{"1,2,5", "2", "3-5"};
        Port port = new Port(arr);
        Set<List<Integer>> set = new HashSet<>(port.arrayCombinations());

        assertEquals(set, Set.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 2, 3),
                List.of(1, 2, 5), List.of(5, 2, 3), List.of(5, 2, 4),
                List.of(5, 2, 5), List.of(2, 2, 4), List.of(2, 2, 5)));

        // меняем расстановку массивов внутри сета
        assertEquals(set, Set.of(List.of(1, 2, 3), List.of(2, 2, 5), List.of(1, 2, 4),
                List.of(2, 2, 3), List.of(1, 2, 5), List.of(5, 2, 3),
                List.of(5, 2, 4), List.of(5, 2, 5), List.of(2, 2, 4)));

        assertNotEquals(set, Set.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 2, 3),
                List.of(1, 2, 5), List.of(2, 2, 4), List.of(2, 2, 5),
                List.of(5, 2, 3), List.of(5, 2, 4), List.of(5, 5)));

        assertNotEquals(set, Set.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 2, 3),
                List.of(1, 2, 5), List.of(2, 2, 4), List.of(2, 2, 5),
                List.of(5, 2, 3), List.of(5, 2, 4), List.of(5, 4, 5)));

    }

    @Test
    void arrayCombinationsTestWhenEmptyArray(){
        String[] arr = new String[]{};
        Port port = new Port(arr);
        Set<List<Integer>> set = new HashSet<>(port.arrayCombinations());

        assertEquals(set,  Set.of(List.of()));

        assertNotEquals(set, Set.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 2, 3),
                List.of(1, 2, 5), List.of(2, 2, 4), List.of(2, 2, 5),
                List.of(5, 2, 3), List.of(5, 2, 4), List.of(5, 5)));

        assertNotEquals(set, Set.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 2, 3),
                List.of(1, 2, 5), List.of(2, 2, 4), List.of(2, 2, 5),
                List.of(5, 2, 3), List.of(5, 2, 4), List.of(5, 4, 5)));

    }

    @Test
    void arrayCombinationsTestWhenAnArrayWithOneElement(){
        String[] arr = new String[]{"1"};
        Port port = new Port(arr);
        Set<List<Integer>> set = new HashSet<>(port.arrayCombinations());

        assertEquals(set, Set.of(List.of(1)));

        assertNotEquals(set, Set.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 2, 3),
                List.of(1, 2, 5), List.of(2, 2, 4), List.of(2, 2, 5),
                List.of(5, 2, 3), List.of(5, 2, 4), List.of(5, 5)));

        assertNotEquals(set, Set.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(2, 2, 3),
                List.of(1, 2, 5), List.of(2, 2, 4), List.of(2, 2, 5),
                List.of(5, 2, 3), List.of(5, 2, 4), List.of(5, 4, 5)));

    }
}

