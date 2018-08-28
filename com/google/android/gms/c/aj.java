package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aj extends af<aj> {
    public String aEV;
    public String aEW;
    public String aYu;
    public String aYv;

    public final void a(aj ajVar) {
        if (!TextUtils.isEmpty(this.aEV)) {
            ajVar.aEV = this.aEV;
        }
        if (!TextUtils.isEmpty(this.aEW)) {
            ajVar.aEW = this.aEW;
        }
        if (!TextUtils.isEmpty(this.aYu)) {
            ajVar.aYu = this.aYu;
        }
        if (!TextUtils.isEmpty(this.aYv)) {
            ajVar.aYv = this.aYv;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.aEV);
        hashMap.put("appVersion", this.aEW);
        hashMap.put("appId", this.aYu);
        hashMap.put("appInstallerId", this.aYv);
        return ak(hashMap);
    }
}
