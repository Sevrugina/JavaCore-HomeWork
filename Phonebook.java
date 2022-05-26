package JavaCore_HomeWork4;
import java.util.*;

public class Phonebook {
        private HashMap<String, HashSet<String>> phonebook = new HashMap<>();
    public void addPhonebook(String name, String phone) {
        HashSet<String> phones;
        if (phonebook.containsKey(name)) {
            phones = phonebook.get(name);
        }
        else {
            phones = new HashSet<>();
        }
        phones.add(phone.replaceAll(" ",""));
        phonebook.put(name,phones);
    }
    public Set<String> getPhonebook (String name) {
        return phonebook.get(name);
    }
}
