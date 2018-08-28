package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.e.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

class a$a$b {
    StringBuffer gVP = new StringBuffer();

    a$a$b() {
    }

    public final void wA(String str) {
        this.gVP.append("<" + str + ">");
    }

    public final void wB(String str) {
        this.gVP.append("</" + str + ">");
    }

    public final void bR(String str, String str2) {
        wA(str);
        if (!bi.oW(str2)) {
            if (str2.contains(a.gVK)) {
                this.gVP.append("<![CDATA[" + bi.WS(str2) + "]]>");
            } else {
                this.gVP.append("<![CDATA[" + str2 + "]]>");
            }
        }
        wB(str);
    }

    public final void aT(String str, int i) {
        wA(str);
        this.gVP.append(i);
        wB(str);
    }

    public final void i(String str, Map<String, String> map) {
        this.gVP.append("<" + str);
        for (String str2 : map.keySet()) {
            this.gVP.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
        }
        this.gVP.append(">");
        map.clear();
    }
}
