package com.google.android.gms.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class e extends af<e> {
    public Map<Integer, String> aWl = new HashMap(4);

    public final /* synthetic */ void a(af afVar) {
        ((e) afVar).aWl.putAll(this.aWl);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.aWl.entrySet()) {
            hashMap.put("dimension" + entry.getKey(), entry.getValue());
        }
        return ak(hashMap);
    }
}
