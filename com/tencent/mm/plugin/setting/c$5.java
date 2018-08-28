package com.tencent.mm.plugin.setting;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class c$5 implements n {
    final /* synthetic */ c mOE;

    c$5(c cVar) {
        this.mOE = cVar;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if (map != null) {
            String str2 = (String) map.get(".sysmsg.security");
            if (!bi.oW(str2)) {
                try {
                    int i = bi.getInt(str2, 0);
                    g.Ei().DT().a(aa.a.sZE, Integer.valueOf(i));
                    if (i != 0) {
                        c.Cp().b(aa.a.sZC, true);
                    } else {
                        c.Cp().b(aa.a.sZC, false);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SubCoreSetting", e, "device protect security value is not number!", new Object[0]);
                }
            }
        }
    }
}
