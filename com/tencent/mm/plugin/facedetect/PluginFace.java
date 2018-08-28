package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.j.c;

public class PluginFace extends f implements a {
    public String name() {
        return "plugin-facedetect";
    }

    public void execute(g gVar) {
        x.i("MicroMsg.PluginFace", "hy: starting execute.");
        if (gVar.ES()) {
            com.tencent.mm.vending.g.g.cBK().d(new b()).a(new d.a<c<Integer, String>>() {
                public final /* synthetic */ void bd(Object obj) {
                    c cVar = (c) obj;
                    if (cVar != null) {
                        int a = bi.a((Integer) cVar.get(0), -1);
                        String aG = bi.aG((String) cVar.get(1), "unknown");
                        x.e("MicroMsg.PluginFace", "hy: onInterrupt errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(a), aG});
                        return;
                    }
                    x.e("MicroMsg.PluginFace", "hy: null in on interrupt");
                }
            });
        }
    }
}
