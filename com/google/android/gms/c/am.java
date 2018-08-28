package com.google.android.gms.c;

import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class am extends af<am> {
    public final List<a> aYK = new ArrayList();
    public final List<c> aYL = new ArrayList();
    public final Map<String, List<a>> aYM = new HashMap();
    public b aYN;

    public final /* synthetic */ void a(af afVar) {
        am amVar = (am) afVar;
        amVar.aYK.addAll(this.aYK);
        amVar.aYL.addAll(this.aYL);
        for (Entry entry : this.aYM.entrySet()) {
            String str = (String) entry.getKey();
            for (a aVar : (List) entry.getValue()) {
                if (aVar != null) {
                    Object obj;
                    if (str == null) {
                        obj = "";
                    } else {
                        String obj2 = str;
                    }
                    if (!amVar.aYM.containsKey(obj2)) {
                        amVar.aYM.put(obj2, new ArrayList());
                    }
                    ((List) amVar.aYM.get(obj2)).add(aVar);
                }
            }
        }
        if (this.aYN != null) {
            amVar.aYN = this.aYN;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        if (!this.aYK.isEmpty()) {
            hashMap.put("products", this.aYK);
        }
        if (!this.aYL.isEmpty()) {
            hashMap.put("promotions", this.aYL);
        }
        if (!this.aYM.isEmpty()) {
            hashMap.put("impressions", this.aYM);
        }
        hashMap.put("productAction", this.aYN);
        return ak(hashMap);
    }
}
