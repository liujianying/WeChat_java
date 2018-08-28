package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.x;

public final class p {
    private static boolean hez = false;

    static /* synthetic */ void atG() {
        if (!g.Eg().Dx() || a.Dr()) {
            x.w("MicroMsg.OnNetworkAvailableListener", "dealWithNetworkAvailable hasSetuin:" + g.Eg().Dx() + " isHold:" + a.Dr());
            return;
        }
        m.TK().run();
        o.Tf().run();
        com.tencent.mm.ak.o.Pd().run();
        ao.cca().run();
        if (am.a.dBu != null) {
            am.a.dBu.HF();
        }
        com.tencent.mm.sdk.b.a.sFg.m(new qv());
    }

    public static synchronized void cF(Context context) {
        synchronized (p.class) {
            if (!hez) {
                hez = true;
                g.Eh().a(new 1(context));
            }
        }
    }
}
