package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class a$a$a {
    Map<String, String> gVN = null;
    boolean gVO = true;

    public a$a$a(String str) {
        this.gVN = ay.WA(str);
        if (this.gVN == null) {
            this.gVO = false;
            this.gVN = new HashMap();
        }
    }

    final int getInt(String str) {
        if (this.gVN.containsKey(str)) {
            return bi.getInt((String) this.gVN.get(str), 0);
        }
        return 0;
    }
}
