package atividade.Aula13;

import java.util.Scanner;

import atividade.Aula13.Menu.SegmentPosition;

import java.util.concurrent.TimeUnit;
/*1. Entrada de Dados:
a. Permitir ao usuário inserir até 50 produtos.
b. Cada produto terá um nome (string) e um preço (float).
c. Os produtos devem ser armazenados em vetores e matrizes sendo:
i. Uma do tipo string para armazenar o nome do produto
ii. Uma matriz do tipo float 2x50 que irá armazenar o valor do produto e a
quantidade do produto em estoque.

2. Funções e Procedimentos:
a. Implementar funções para os métodos de ordenação: Bubble Sort, Insertion Sort e
Selection Sort.
b. Implementar um procedimento para exibir a lista de produtos.
c. Implementar uma função para buscar um produto pelo nome e retornar seu preço.

3. Ordenação:
a. Permitir ao usuário escolher o método de ordenação.
b. Permitir ao usuário escolher se deseja ordenar por nome ou por preço.

4. Interface:
a. Exibir um menu para o usuário com as seguintes opções:
b. Inserir produto.
c. Exibir produtos.
d. Ordenar produtos por nome.
e. Ordenar produtos por preço.
f. Buscar produto por nome.
g. Sair.

5. Funcionalidades:
a. Implementar uma função que identifique e remova produtos duplicados (com base no
nome) após a inserção.
b. Implementar uma função que calcule e retorne a média de preço dos produtos
inseridos.
c. Permitir ao usuário escolher a ordem da ordenação (crescente ou decrescente) quando
selecionar as opções de ordenar por nome ou preço. 

*/
public class Main {

    public static void main(String[] args) throws InterruptedException {

        int mainMenuSize = 60;
        int productMenuSize = 50;
        int ordinationMenuSize = 71;
        int searchMenuSize = 80;
        int maxProducts = 50;

        Menu mainMenu = new Menu("Menu", mainMenuSize);
        Menu productMenu = new Menu("Produtos", productMenuSize);
        Menu ordinationMenu = new Menu("Ordenações", ordinationMenuSize);
        Menu searchMenu = new Menu("Buscar Produto", searchMenuSize);


        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        String[] nameList = new String[maxProducts];
        Float[][] productList = new Float[2][maxProducts];
        int productQuantity = 0;

        boolean isRunning = true, inProduct = false, inOrdination = false, inSearch = false;
        boolean usingBubble = true, usingInsertion = false, usingSelection = false;
        String currentOrdination = "Bubble Sort";

        int menuCommand, productCommand, removeCommand, ordinationCommand, searchCommand;

        while (isRunning) {

            mainMenu.printTitle();
            mainMenu.printBody();
            System.out.println();
            menuCommand = mainMenu.intInput(intInput);

            if (menuCommand == 1) {

                inProduct = true;

            }

            if (menuCommand == 2) {

                inOrdination = true;

            }
            if(menuCommand == 3){
            
                inSearch = true;
            
            }
            
            if (menuCommand == 4) {

                isRunning = false;

            }

            while (inProduct) {

                productMenu.printTitle();
                productMenu.printSegment();
                productMenu.printSegment("1 - Adicionar", "  2 - Remover", "  3 - Voltar");

                productMenu.printLine();
                System.out.println();
                productCommand = productMenu.intInput(intInput);

                if (productCommand == 1) {
                    if (productList.length < 50) {

                        productMenu.printTitle();
                        nameList[productQuantity] = productMenu.stringInput(stringInput, "Nome");
                        productList[0][productQuantity] = productMenu.floatInput(intInput, "Valor");
                        productList[1][productQuantity] = productMenu.floatInput(intInput, "Quantidade");

                        productQuantity++;

                    }

                    else if (productList.length >= 50) {

                        productMenu.printTitle();
                        productMenu.printSegment("A quantidade de produtos excede 50!");
                        productMenu.printLine();

                        TimeUnit.SECONDS.sleep(2);

                    }

                }

                if (productCommand == 2 && productQuantity > 0) {

                    productMenu.printTitle();
                    productMenu.printSegment("Qual produto deseja remover?");
                    productMenu.printLine();
                    System.out.println();
                    productMenu.printSegment();

                    int toBeShown = productQuantity;
                    int productShowed = 0;
                    while (toBeShown > 0) {

                        if (toBeShown - 2 <= -1) {

                            productMenu.printSegment(productShowed + " - " + nameList[productShowed]);
                            toBeShown -= 1;
                        }

                        else if (toBeShown >= 2) {

                            productMenu.printSegment(productShowed + " - " + nameList[productShowed++], "    ",
                                    productShowed + " - " + nameList[productShowed++]);
                            toBeShown -= 2;
                        }

                    }

                    productMenu.printLine();
                    System.out.println();

                    removeCommand = productMenu.intInput(intInput);

                    if (nameList[removeCommand] != null) {

                        for (int i = removeCommand; i < productQuantity - 1; i++) {
                            nameList[i] = nameList[i + 1];
                            productList[0][i] = productList[0][i + 1];
                            productList[1][i] = productList[1][i + 1];
                        }

                        nameList[productQuantity - 1] = null;
                        productList[0][productQuantity - 1] = 0f;
                        productList[1][productQuantity - 1] = 0f;

                        productQuantity--;

                    }

                    else if (nameList[removeCommand] == null) {

                        productMenu.printTitle();
                        productMenu.printSegment();
                        productMenu.printSegment("Não há esse produto para remover!");
                        productMenu.printLine();
                        System.out.println();

                        TimeUnit.SECONDS.sleep(2);
                    }

                } else if (productCommand == 2 && productQuantity <= 0) {

                    productMenu.printTitle();
                    productMenu.printSegment();
                    productMenu.printSegment("Não há produtos para remover!");
                    productMenu.printLine();
                    System.out.println();

                    TimeUnit.SECONDS.sleep(2);

                }

                if (productCommand == 3) {

                    inProduct = false;

                }

            } // produto

            while(inOrdination){
            
                ordinationMenu.printTitle();
                ordinationMenu.printSegment();
                ordinationMenu.printSegment("1 - Bubble", "   2 - Insertion", "   3 - Selection", "   4 - Voltar");
                ordinationMenu.printSegment();
                ordinationMenu.printSegment("Usando: " + currentOrdination);
                ordinationMenu.printLine();
                System.out.println();

                ordinationCommand = ordinationMenu.intInput(intInput);

                if (ordinationCommand == 1) {

                    usingBubble = true;
                    usingInsertion = false;
                    usingSelection = false;
                    currentOrdination = "Bubble Sort";

                }
                
                if (ordinationCommand == 2) {

                    usingBubble = false;
                    usingInsertion = true;
                    usingSelection = false;
                    currentOrdination = "Insertion Sort";

                }

                if (ordinationCommand == 3) {

                    usingBubble = false;
                    usingInsertion = false;
                    usingSelection = true;
                    currentOrdination = "Selection Sort";

                }
                if(ordinationCommand == 4){
                
                    inOrdination = false;
                
                }
            } //ordenação

            while (inSearch) {

                searchMenu.printTitle();
                searchMenu.printSegment("Ordenação atual: " + currentOrdination, SegmentPosition.LEFT);
                searchMenu.printSegment();
                searchMenu.printSegment("1 - Buscar por nome" , "    2 - Mostrar todos os produtos", "    3 - Voltar");
                searchMenu.printLine();
                System.out.println();
                
                searchCommand = searchMenu.intInput(intInput);
                int currentNamePos = 0;

                if (searchCommand == 1) {

                    searchMenu.printTitle();
                    searchMenu.printSegment();
                    String nameToFind = searchMenu.stringInput(stringInput, "Nome");

                    boolean nameFound = false;
                
                    for (String name : nameList) {

                        if (nameToFind.toLowerCase().equalsIgnoreCase(name) && !nameFound) {

                            nameFound = true;
                            break;
                        }
                        currentNamePos++;
                    }

                    if (nameFound) {

                        searchMenu.printTitle();
                        searchMenu.printSegment();

                        String value = String.format("%.2f", productList[0][currentNamePos]);
                        String quantity = String.format("%.0f", productList[1][currentNamePos]);

                        searchMenu.printSegment("Nome do produto: ", nameList[currentNamePos]);
                        searchMenu.printSegment("Valor do produto: R$", value);
                        searchMenu.printSegment("Quantidade total: ", quantity);
                        searchMenu.printSegment();

                        searchMenu.printSegment("1 - Voltar");
                        searchMenu.printLine();

                        System.out.println();
                        searchMenu.intInput(intInput);

                    }
                    if (!nameFound) {

                        searchMenu.printTitle();
                        searchMenu.printSegment();
                        searchMenu.printSegment("Produto não encontrado!");
                        searchMenu.printLine();
                        System.out.println();

                        TimeUnit.SECONDS.sleep(2);

                    }
                }
                if (searchCommand == 2) {
                    searchMenu.printTitle();

                    int toBeShown = productQuantity;
                    int productShowed = 0;
                    while (toBeShown > 0) {

                        if (toBeShown - 2 <= -1) {

                            searchMenu.printSegment(productShowed + " - " + nameList[productShowed]);
                            toBeShown -= 1;
                        }

                        else if (toBeShown >= 2) {

                            searchMenu.printSegment(productShowed + " - " + nameList[productShowed++], "    ",
                                    productShowed + " - " + nameList[productShowed++]);
                            toBeShown -= 2;
                        }

                        if (productQuantity == 0) {

                            searchMenu.printSegment("Nenhum produto encontrado");

                        }
                    }

                    searchMenu.printSegment("1 - Voltar", SegmentPosition.LEFT);
                    searchMenu.printLine();
                    System.out.println();

                    searchCommand = searchMenu.intInput(intInput);
                }

                if(searchCommand == 3){
                
                    inSearch = false;

                }

            }
        }
    }
}

class Menu {

    private int size;
    private String title;

    public Menu(String title, int size) {

        this.title = title;
        this.size = size;
    }

    public void printSegment() {

        int titleSize = title.length();
        int menuSize = size;
        int paddle = 0;

        if (titleSize % 2 != 0 || menuSize % 2 != 0) {

            paddle = 1;

        }

        System.out.print("|");

        for (int i = 0; i < size - paddle; i++) {

            System.out.print(" ");

        }

        System.out.print("|\n");

    }

    public void printSegment(String... texts) {

        int titleSize = title.length();
        int menuSize = size;
        int paddle = 0;

        if (titleSize % 2 != 0 || menuSize % 2 != 0) {
            paddle = 1;
        }

        System.out.print("|");

        int totalTextLength = 0;

        for (String text : texts) {
            totalTextLength += text.length();
        }

        int totalSpaces = size - totalTextLength - texts.length - paddle;

        int spacesBefore = totalSpaces / 2;
        int spacesAfter = totalSpaces / 2;

        if (totalTextLength % 2 != 0) {

            spacesAfter += 2;

        }

        if (texts.length % 2 != 0) {

            spacesAfter++;

        }

        if (texts.length % 2 != 0 && totalTextLength % 2 != 0) {

            spacesAfter -= 3;

        }
        if (texts.length % 2 == 0 && totalTextLength % 2 != 0) {

            spacesAfter--;

        }

        for (int i = 0; i < spacesBefore; i++) {
            System.out.print(" ");
        }

        for (String text : texts) {
            System.out.print(text);
            System.out.print(" ");
        }

        for (int i = 0; i < spacesAfter; i++) {
            System.out.print(" ");
        }

        System.out.print("|\n");
    }

    enum SegmentPosition {
        UNILEFT,LEFT,RIGHT
    }

    public void printSegment(String text, SegmentPosition position) {

        int titleSize = title.length();
        int menuSize = size;
        int paddle = 0;

        if (titleSize % 2 != 0 || menuSize % 2 != 0) {
            paddle = 1;
        }

        System.out.print("|");

        int spacesBefore = 0;
        int spacesAfter = 0;

        switch (position) {
            case UNILEFT:
                spacesBefore = 1;
                spacesAfter = size - text.length() - spacesBefore - paddle + 3;
                break;
            case LEFT:
                spacesBefore = 1;
                spacesAfter = size - text.length() - spacesBefore - paddle;
                break;
            case RIGHT:
                spacesBefore = size - text.length() - paddle;
                spacesAfter = 1;
                break;
        }

        for (int i = 0; i < spacesBefore; i++) {
            System.out.print(" ");
        }

        System.out.print(text);

        for (int i = 0; i < spacesAfter; i++) {
            System.out.print(" ");
        }

        System.out.print("|\n");
    }

    public void printLine() {

        int titleSize = title.length();
        int menuSize = size;
        int paddle = 0;

        if (titleSize % 2 == 0 && menuSize % 2 == 0) {
            paddle = 1;
        }

        if (titleSize % 2 != 0 && menuSize % 2 == 0) {
            paddle = 2;
        }
        for (int i = 0; i <= menuSize + paddle; i++) {

            System.out.print("-");

        }
    }

    public void printTitle() {

        int titleSize = title.length();
        int menuSize = size;

        System.out.println("\033[1J");
        System.out.println("\033[H");

        printLine();
        System.out.print("\n|");

        for (int i = 0; i < menuSize / 2 - titleSize / 2; i++) {

            System.out.print(" ");

        }
        System.out.print(title);
        for (int i = 0; i < menuSize / 2 - titleSize / 2; i++) {

            System.out.print(" ");

        }
        System.out.print("|\n");

        printLine();

        System.out.println();
    }

    public void printBody() {

        printSegment();
        printSegment("(1) - Produtos",
    "                 (3) - Buscar produto");
        printSegment("(2) - Métodos de Ordenação",
                "     (4) - Sair do Sistema");
        printLine();

    }

    public int intInput(Scanner input) {

        int command;

        printSegment(" input:\033[s", SegmentPosition.UNILEFT);

        printLine();
        System.out.print("\033[u ");
        command = input.nextInt();
        System.out.println();

        return command;
    }

    public int intInput(Scanner input, String label) {

        int command;

        printSegment(" " + label + ":\033[s", SegmentPosition.UNILEFT);

        printLine();
        System.out.print("\033[u ");
        command = input.nextInt();
        System.out.println();

        return command;
    }

    public String stringInput(Scanner input, String label) {

        String command;

        printSegment(" " + label + ":\033[s", SegmentPosition.UNILEFT);

        printLine();
        System.out.print("\033[u ");
        command = input.nextLine();
        System.out.println();

        return command;

    }

    public float floatInput(Scanner input, String label) {

        float command;

        printSegment(" " + label + ":\033[s", SegmentPosition.UNILEFT);

        printLine();
        System.out.print("\033[u ");
        command = input.nextFloat();
        System.out.println();

        return command;
    }
}
class Sort {

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

    public static int[] insertionSort(int[] array) {
        int key, i, j;

        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;

            }
            array[j + 1] = key;
        }
        return array;
    }

    public static Float[] bubbleSort(Float[] product) {

        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product.length - 1; j++) {
                if (product[j] > product[j + 1]) {
                    float aux = product[j];
                    product[j] = product[j + 1];
                    product[j + 1] = aux;
                }
            }
        }

        return product;
    }
}

