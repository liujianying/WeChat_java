package com.tencent.mm.plugin.expt.b;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class a$2 implements m {
    final /* synthetic */ a iHY;

    a$2(a aVar) {
        this.iHY = aVar;
    }

    public final b a(String str, Map<String, String> map, a aVar) {
        if (!"expt".equals(str)) {
            x.w("MicroMsg.ExptService", "receive expt xml but subtype[%s] is error", str);
        } else if (map == null || map.size() <= 0) {
            x.w("MicroMsg.ExptService", "receive expt xml but map is null");
        } else {
            this.iHY.AB((String) map.get(".sysmsg.content"));
        }
        return null;
    }
}
