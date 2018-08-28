package com.google.android.gms.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class f extends af<f> {
    public Map<Integer, Double> aWm = new HashMap(4);

    public final /* synthetic */ void a(af afVar) {
        ((f) afVar).aWm.putAll(this.aWm);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.aWm.entrySet()) {
            hashMap.put("metric" + entry.getKey(), entry.getValue());
        }
        return ak(hashMap);
    }
}
