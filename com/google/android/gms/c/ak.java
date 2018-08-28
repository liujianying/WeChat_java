package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ak extends af<ak> {
    public String aEN;
    public String aYA;
    public String aYB;
    public String aYC;
    public String aYD;
    public String aYw;
    public String aYx;
    public String aYy;
    public String aYz;
    public String mName;

    public final /* synthetic */ void a(af afVar) {
        ak akVar = (ak) afVar;
        if (!TextUtils.isEmpty(this.mName)) {
            akVar.mName = this.mName;
        }
        if (!TextUtils.isEmpty(this.aYw)) {
            akVar.aYw = this.aYw;
        }
        if (!TextUtils.isEmpty(this.aYx)) {
            akVar.aYx = this.aYx;
        }
        if (!TextUtils.isEmpty(this.aYy)) {
            akVar.aYy = this.aYy;
        }
        if (!TextUtils.isEmpty(this.aYz)) {
            akVar.aYz = this.aYz;
        }
        if (!TextUtils.isEmpty(this.aEN)) {
            akVar.aEN = this.aEN;
        }
        if (!TextUtils.isEmpty(this.aYA)) {
            akVar.aYA = this.aYA;
        }
        if (!TextUtils.isEmpty(this.aYB)) {
            akVar.aYB = this.aYB;
        }
        if (!TextUtils.isEmpty(this.aYC)) {
            akVar.aYC = this.aYC;
        }
        if (!TextUtils.isEmpty(this.aYD)) {
            akVar.aYD = this.aYD;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put("source", this.aYw);
        hashMap.put("medium", this.aYx);
        hashMap.put("keyword", this.aYy);
        hashMap.put("content", this.aYz);
        hashMap.put("id", this.aEN);
        hashMap.put("adNetworkId", this.aYA);
        hashMap.put("gclid", this.aYB);
        hashMap.put("dclid", this.aYC);
        hashMap.put("aclid", this.aYD);
        return ak(hashMap);
    }
}
