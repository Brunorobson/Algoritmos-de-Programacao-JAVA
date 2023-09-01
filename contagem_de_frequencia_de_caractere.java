import java.util.HashMap;
import java.util.Map;

public class contagem_de_frequencia_de_caractere {

    public static Map<Character, Integer> countCharacterFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : input.toCharArray()) {
            // Verifica se o caractere já está no mapa
            if (frequencyMap.containsKey(c)) {
                // Se sim, incrementa a contagem
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                // Se não, adiciona o caractere ao mapa com contagem 1
                frequencyMap.put(c, 1);
            }
        }
        
        return frequencyMap;
    }

    public static void main(String[] args) {
        String text = "hello world";
        Map<Character, Integer> frequencyMap = countCharacterFrequency(text);

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Character: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }
}
