package cn.abelib.datastructure.tree.bpt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abel.huang
 * @date 2020/10/9 14:23
 */
public class KeyValue implements Comparable<KeyValue> {
    private String key;
    private List<Object> values;

    public KeyValue(String key, Object value) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
    }

    public KeyValue(KeyValue keyValue) {
        this.key = keyValue.getKey();
        this.values = keyValue.getValues();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    @Override
    public int compareTo(KeyValue keyValue) {
        return this.key.compareTo(keyValue.key);
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "key='" + key + '\'' +
                ", values=" + values +
                '}';
    }
}
