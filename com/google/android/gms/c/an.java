package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class an extends af<an> {
    public String aOA;
    public String aYO;
    public long aYP;
    public String pM;

    public final /* synthetic */ void a(af afVar) {
        an anVar = (an) afVar;
        if (!TextUtils.isEmpty(this.pM)) {
            anVar.pM = this.pM;
        }
        if (!TextUtils.isEmpty(this.aOA)) {
            anVar.aOA = this.aOA;
        }
        if (!TextUtils.isEmpty(this.aYO)) {
            anVar.aYO = this.aYO;
        }
        if (this.aYP != 0) {
            anVar.aYP = this.aYP;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.pM);
        hashMap.put("action", this.aOA);
        hashMap.put("label", this.aYO);
        hashMap.put("value", Long.valueOf(this.aYP));
        return af.ak(hashMap);
    }
}
