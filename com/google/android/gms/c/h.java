package com.google.android.gms.c;

import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import java.util.HashMap;
import java.util.Map;

public final class h extends af<h> {
    public String aGl;
    public String aWn;
    public String aWo;
    public String aWp;
    public boolean aWq;
    public String aWr;
    public boolean aWs;
    public double aWt;

    public final /* synthetic */ void a(af afVar) {
        boolean z = true;
        h hVar = (h) afVar;
        if (!TextUtils.isEmpty(this.aWn)) {
            hVar.aWn = this.aWn;
        }
        if (!TextUtils.isEmpty(this.aGl)) {
            hVar.aGl = this.aGl;
        }
        if (!TextUtils.isEmpty(this.aWo)) {
            hVar.aWo = this.aWo;
        }
        if (!TextUtils.isEmpty(this.aWp)) {
            hVar.aWp = this.aWp;
        }
        if (this.aWq) {
            hVar.aWq = true;
        }
        if (!TextUtils.isEmpty(this.aWr)) {
            hVar.aWr = this.aWr;
        }
        if (this.aWs) {
            hVar.aWs = this.aWs;
        }
        if (this.aWt != 0.0d) {
            double d = this.aWt;
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            w.e(z, "Sample rate must be between 0% and 100%");
            hVar.aWt = d;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.aWn);
        hashMap.put("clientId", this.aGl);
        hashMap.put("userId", this.aWo);
        hashMap.put("androidAdId", this.aWp);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.aWq));
        hashMap.put("sessionControl", this.aWr);
        hashMap.put("nonInteraction", Boolean.valueOf(this.aWs));
        hashMap.put("sampleRate", Double.valueOf(this.aWt));
        return ak(hashMap);
    }
}
