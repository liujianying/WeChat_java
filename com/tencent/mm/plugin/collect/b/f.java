package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class f implements e {
    public static f hTN;
    private final String TAG = "MicroMsg.F2fGetPayUrlManager";
    public Map<l, a> diQ = new HashMap();

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof l) {
            l lVar2 = (l) lVar;
            a aVar = (a) this.diQ.get(lVar);
            if (aVar == null) {
                x.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
                return;
            }
            if (i == 0 && i2 == 0) {
                aVar.a(true, lVar2.hUl);
            } else {
                x.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[]{lVar2});
                aVar.a(false, null);
            }
            this.diQ.remove(lVar);
        }
    }
}
