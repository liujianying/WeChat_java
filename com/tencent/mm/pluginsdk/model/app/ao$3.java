package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.a.hd;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class ao$3 extends c<hd> {
    final /* synthetic */ ao qAR;

    ao$3(ao aoVar) {
        this.qAR = aoVar;
        this.sFo = hd.class.getName().hashCode();
    }

    private static boolean a(hd hdVar) {
        int i;
        try {
            if (g.AT() == null) {
                i = 0;
            } else {
                i = bi.getInt(g.AT().getValue("AndroidUseUnicodeEmoji"), 0);
            }
        } catch (Exception e) {
            i = 0;
        }
        hdVar.bQr.bKi = i;
        return false;
    }
}
