package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ar extends af<ar> {
    public String aYO;
    public String aZc;
    public long aZd;
    public String pM;

    public final /* synthetic */ void a(af afVar) {
        ar arVar = (ar) afVar;
        if (!TextUtils.isEmpty(this.aZc)) {
            arVar.aZc = this.aZc;
        }
        if (this.aZd != 0) {
            arVar.aZd = this.aZd;
        }
        if (!TextUtils.isEmpty(this.pM)) {
            arVar.pM = this.pM;
        }
        if (!TextUtils.isEmpty(this.aYO)) {
            arVar.aYO = this.aYO;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.aZc);
        hashMap.put("timeInMillis", Long.valueOf(this.aZd));
        hashMap.put("category", this.pM);
        hashMap.put("label", this.aYO);
        return ak(hashMap);
    }
}
