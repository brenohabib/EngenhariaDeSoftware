package AtividadesJava.Aula11;

public class Au11Ex1 {
    public static void main(String[] args) {

        int[] array = new int[10];
        array = randomArray(array);

        printArray(array);

        array = randomArray(array);

        array = selectionSort(array);

        printArray(array);
    }

    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int key = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[key]) {

                    key = j;

                }

            }
            int temp = array[key];
            array[key] = array[i];
            array[i] = temp;

        }
        return array;

    }

    public static int[] randomArray(int[] array) {

        for (int i = 0; i < array.length; i++) {

            array[i] = (int) (Math.random() * 11);

        }

        return array;

    }
    
    public static void printArray(int[] array) {
    
        for (int i = 0; i < array.length; i++) {
            
            System.out.print(" | " + array[i]);

        }
        System.out.println(" | ");
    }

}