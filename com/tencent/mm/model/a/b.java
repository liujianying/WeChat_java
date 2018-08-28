package com.tencent.mm.model.a;

import java.util.HashMap;

public final class b {
    public String dDI;
    public String dDJ;
    public String dDK;
    public String dDL;
    public HashMap<String, e> dDM = new HashMap();

    public final e iP(String str) {
        if (this.dDM == null || !this.dDM.containsKey(str)) {
            return null;
        }
        return (e) this.dDM.get(str);
    }
}
