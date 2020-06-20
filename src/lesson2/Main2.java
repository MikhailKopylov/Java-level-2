package lesson2;

public class Main2 {

    public static void main(String[] args) {


        String[][] strings1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "1fs", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] strings2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] strings3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        try {
            int sum1 = sumElemArray(strings1);
            System.out.println("Сумма элементов массива = " + sum1);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (MyArrayDataException e) {
            String message = String.format("Невозможно преобразовать в число в строке %d и столбце %d",
                    e.getRow(), e.getColumn());
            e.printStackTrace();
            System.out.println(message);
            System.out.println();
        }

        try {
            int sum2 = sumElemArray(strings2);
            System.out.println("Сумма элементов массива = " + sum2);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println();
        } catch (MyArrayDataException e) {
            String message = String.format("Невозможно преобразовать в число в строке %d и столбце %d",
                    e.getRow(), e.getColumn());
            e.printStackTrace();
            System.out.println(message);
            System.out.println();
        }

        try {
            int sum3 = sumElemArray(strings3);
            System.out.println("Сумма элементов массива = " + sum3);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println();
        } catch (MyArrayDataException e) {
            String message = String.format("Невозможно преобразовать в число в строке %d и столбце %d",
                    e.getRow(), e.getColumn());
            e.printStackTrace();
            System.out.println(message);
            System.out.println();
        }

    }

    public static int sumElemArray(String[][] strings) throws MyArraySizeException {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length != 4) {
                String message = String.format("Неверный размер массива: %d в строке %d", strings[i].length, i);
                throw new MyArraySizeException(message, strings[i].length, i);
            }

        }
        int sum = 0;
        int row = 0;
        int column = 0;
        try {
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length; j++) {
                    row = i;
                    column = j;
                    sum += Integer.parseInt(strings[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Неверный формат числа", row, column);
        }
        return sum;
    }

}

