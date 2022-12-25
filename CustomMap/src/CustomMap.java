import java.util.ArrayList;

public class CustomMap<K,V> {

    private final ArrayList<K> keys = new ArrayList<>();
    private final ArrayList<V> values = new ArrayList<>();

    public void put(K newKey, V newValue) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(newKey)) {
                values.set(i, newValue);
                return;
            }
        }

        keys.add(newKey);
        values.add(newValue);
    }

    public Object[] getKeys() {
        return keys.toArray();
    }

    public void remove(K key2Delete) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key2Delete)) {
                keys.remove(i);
                values.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            builder.append("[" + keys.get(i) + ":" + values.get(i) + "]");

            if (i != keys.size() -1) {
                builder.append(", ");
            }
        }

        return "CustomMap{" + builder.toString() + "}";
    }
}
