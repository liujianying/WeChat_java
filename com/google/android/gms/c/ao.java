package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ao extends af<ao> {
    public String aYQ;
    public boolean aYR;

    public final /* synthetic */ void a(af afVar) {
        ao aoVar = (ao) afVar;
        if (!TextUtils.isEmpty(this.aYQ)) {
            aoVar.aYQ = this.aYQ;
        }
        if (this.aYR) {
            aoVar.aYR = this.aYR;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.aYQ);
        hashMap.put("fatal", Boolean.valueOf(this.aYR));
        return ak(hashMap);
    }
}
