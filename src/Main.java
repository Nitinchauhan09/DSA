import mapimplementation.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> map = new Map<>();
        map.insert("Nitin", 50);
        map.insert("Chetan", 60);
        map.insert("Ashu", 70);

        System.out.println(map.getValue("Nitin"));

    }
}