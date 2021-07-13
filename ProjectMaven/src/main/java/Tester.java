import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    private DeleteDuplication array;

    @Before
    public void init() {
        array = new DeleteDuplication();
    }

    @Test
    public void additionTest() {
        array.addElement(22);
        array.addElement(44);
        array.addElement(66);
        array.addElement(77);
        Assert.assertEquals(4, array.getSize());
    }

    @Test
    public void isEmptyTest(){
        array.addElement(6);
        array.addElement(34);
        Assert.assertFalse(array.isEmpty());
    }

    @Test
    public void isNotNullTest(){
        Assert.assertNotNull(array);
    }

    @Test
    public void deleteTest(){
        ArrayList<Integer> equalArray = new ArrayList<>(Arrays.asList(3,5,8,9,10));
        array.addElement(3);array.addElement(3);
        array.addElement(5);array.addElement(5);
        array.addElement(8);array.addElement(8);
        array.addElement(9);array.addElement(9);
        array.addElement(10);
        Assert.assertEquals(array.delete(), equalArray);
    }

    @After
    public void cleanUp() {
        array = null;
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Tests finished");
    }

}
