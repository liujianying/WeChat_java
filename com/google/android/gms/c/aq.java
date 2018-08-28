package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aq extends af<aq> {
    public String aOA;
    public String aZa;
    public String aZb;

    public final /* synthetic */ void a(af afVar) {
        aq aqVar = (aq) afVar;
        if (!TextUtils.isEmpty(this.aZa)) {
            aqVar.aZa = this.aZa;
        }
        if (!TextUtils.isEmpty(this.aOA)) {
            aqVar.aOA = this.aOA;
        }
        if (!TextUtils.isEmpty(this.aZb)) {
            aqVar.aZb = this.aZb;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.aZa);
        hashMap.put("action", this.aOA);
        hashMap.put("target", this.aZb);
        return af.ak(hashMap);
    }
}
