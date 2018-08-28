package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class c {
    public HashMap<String, a> fnX = new HashMap();

    public final void a(a aVar) {
        if (aVar == null || bi.oW(aVar.bNH)) {
            x.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        x.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", new Object[]{aVar.bNH, aVar.fnM});
        this.fnX.put(aVar.bNH, aVar);
    }

    public final a rs(String str) {
        if (!bi.oW(str)) {
            return (a) this.fnX.get(str);
        }
        x.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}
