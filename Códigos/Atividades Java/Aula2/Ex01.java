import java.util.Scanner;
public class Ex01 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int valor;
        int [] vet = new int[10];
        System.out.print("Digite um valor para ser mostrado na tabuada: ");
        valor = input.nextInt();
        for(int i = 0; i < 10; i++){
            System.out.println(i + 1 + "x" + valor + "=" + valor*(i + 1));
            vet[i] = valor * i;
        }
        
        input.close();
        for (int i = 0; i < vet.length;i++)
            System.out.print(vet[i] + " ");
    }
 
}