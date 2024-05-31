import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] kelimelerListe = {"barış", "serkan", "selen", "mehmet", "ahmet"};
        List<String> tekrarlananKelimeler = tekrarlananKelimeleriBul(kelimelerListe);

        if (!tekrarlananKelimeler.isEmpty()) {
            String randomWord = rastgeleKelime(tekrarlananKelimeler);
            System.out.println("Kelimeler: " + tekrarlananKelimeler);
            System.out.println("Rastgele kelime: " + randomWord);
        } else {
            System.out.println("Tekrarlanan harfleri olan kelime bulunamadı.");
        }
    }

    private static List<String> tekrarlananKelimeleriBul(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (tekrarlandımı(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean tekrarlandımı(String word) {
        HashMap<Character, Integer> harfSayisi = new HashMap<>();
        for (char c : word.toCharArray()) {
            harfSayisi.put(c, harfSayisi.getOrDefault(c, 0) + 1);
            if (harfSayisi.get(c) > 1) {
                return true;
            }
        }
        return false;
    }

    private static String rastgeleKelime(List<String> words) {
        StringBuilder tumHarfler = new StringBuilder();
        for (String word : words) {
            tumHarfler.append(word);
        }

        Random random = new Random();
        StringBuilder randomWord = new StringBuilder();
        for (int i = 0; i < tumHarfler.length(); i++) {
            int randomIndex = random.nextInt(tumHarfler.length());
            randomWord.append(tumHarfler.charAt(randomIndex));
            tumHarfler.deleteCharAt(randomIndex);
        }

        return randomWord.toString();
    }
}
