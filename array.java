public class array {

    public static void main(String[] args) {
        // Declaração e inicialização de um array de inteiros
        int[] numbers = new int[5];
        
        // Atribuição de valores aos elementos do array
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        // Acesso e impressão dos elementos do array
        System.out.println("Element at index 0: " + numbers[0]);
        System.out.println("Element at index 3: " + numbers[3]);
        
        // Iteração sobre os elementos do array usando um loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }
}
