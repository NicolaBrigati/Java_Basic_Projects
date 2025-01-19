import java.util.ArrayList;

public class CustomIntegerArrayList {
    private ArrayList<Integer> arr;

    // Costruttore senza argomenti
    public CustomIntegerArrayList() {
        arr = new ArrayList<>();
    }

    // Costruttore con un ArrayList di elementi
    public CustomIntegerArrayList(ArrayList<Integer> elements) {
        arr = new ArrayList<>(elements);
    }

    // Ritorna la lista
    public ArrayList<Integer> getArrayList() {
        return arr;
    }

    // Ritorna l'elemento all'indice specificato
    public int get(int index) {
        return arr.get(index);
    }

    // Aggiunge un elemento alla lista
    public void add(int element) {
        arr.add(element);
    }

    // Aggiunge un elemento all'indice specificato
    public void add(int index, int element) {
        arr.add(index, element);
    }

    // Rimuove l'elemento all'indice specificato
    public void remove(int index) {
        arr.remove(index);
    }

    // Rimuove un numero specifico di occorrenze di un elemento
    public void remove(int num, int element) {
        if (num <= 0) return;
        int count = 0;
        for (int i = 0; i < arr.size() && count < num; i++) {
            if (arr.get(i).equals(element)) {
                arr.remove(i);
                count++;
                i--; // Decresce l'indice per compensare la rimozione
            }
        }
    }

    // Rimuove un numero specifico di elementi dalla lista
    public void splice(int index, int num) {
        if (index < 0 || index >= arr.size()) return;
        for (int i = 0; i < num && index < arr.size(); i++) {
            arr.remove(index);
        }
    }

    // Rimuove e inserisce nuovi elementi in una posizione specificata
    public void splice(int index, int num, int[] otherArray) {
        // Rimuoviamo prima gli elementi
        splice(index, num);

        // Poi inseriamo i nuovi elementi in modo corretto
        if (index < 0 || index > arr.size()) return;
        for (int i = 0; i < otherArray.length; i++) {
            arr.add(index + i, otherArray[i]);
        }
    }
}
