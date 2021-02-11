import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String[][] array = new String[4][4];
        char rand = 0;
        String randString = "";
        // заполняем массив случайными значениями
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                rand = (char) (random.nextInt(14)+ 44);
                randString = Character.toString(rand);
                array[i][j] = randString;
            }
        }
        System.out.println("Заданный массив:\n"+Arrays.deepToString(array));

        try {
            sumElementArray(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
        }
    }

    public static void sumElementArray(String[][] array) throws MyArraySizeException, MyArrayDataException{
        if(array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException();
        }
        int sum = 0;
        int buf;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try{
                    buf = Integer.parseInt(array[i][j]);
                    sum += buf;
                } catch (NumberFormatException e){
//                    System.out.println(sum);
                    throw new MyArrayDataException("Значение array["+i+"]["+j+"] не является числом: \""+array[i][j]+"\"");
                } finally {
                    continue; // суммируем дальше
                }
            }
        }
        System.out.println("Сумма чисел в массиве = "+sum);
    }
}
