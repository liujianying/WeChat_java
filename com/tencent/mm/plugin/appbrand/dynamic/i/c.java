package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c implements a {
    private String appId;
    private String fuu;
    private String fxE;
    private Map<String, Integer> fxF = new HashMap();

    public c(String str, String str2) {
        this.appId = str;
        this.fuu = str2;
        this.fxE = this.fuu + "-" + this.appId;
    }

    public final void sI(String str) {
        if (!TextUtils.isEmpty(str)) {
            Integer num = (Integer) this.fxF.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.fxF.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public final void xP() {
        for (Entry entry : this.fxF.entrySet()) {
            h.mEJ.h(14705, new Object[]{entry.getKey(), entry.getValue(), this.fxE, this.fuu, this.appId});
        }
        this.fxF.clear();
    }
}
