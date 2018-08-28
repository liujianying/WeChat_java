package c.t.m.g;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class bg extends LinkedHashMap<String, String> {
    bg() {
        super(8, 1.0f, true);
    }

    protected final boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 8;
    }
}
