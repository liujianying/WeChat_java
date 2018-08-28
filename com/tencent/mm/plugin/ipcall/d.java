package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.aa.a;

public final class d {
    public static boolean aWV() {
        if (!au.HX()) {
            return false;
        }
        if (g.AT().getInt("WCOEntranceSwitch", 0) > 0) {
            au.HU();
            c.DT().a(a.sRf, Boolean.valueOf(true));
            return true;
        }
        au.HU();
        c.DT().a(a.sRf, Boolean.valueOf(false));
        return false;
    }
}
