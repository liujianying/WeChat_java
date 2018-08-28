package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.mo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;

class e$15 extends c<mo> {
    final /* synthetic */ e ffn;

    e$15(e eVar) {
        this.ffn = eVar;
        this.sFo = mo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bd bdVar = ((mo) bVar).bXx.bGS;
        if (bdVar != null) {
            String str = bdVar.field_talker;
            if (ab.gr(str)) {
                e.abf().bd(str + "_unreadCount", String.valueOf(bi.getInt(e.abf().get(str + "_unreadCount", "0"), 0) + 1));
                ai Yq = ((i) g.l(i.class)).FW().Yq(str);
                d.aB(q.rW(str), Yq != null ? Yq.field_unReadCount : 0);
            }
        }
        return false;
    }
}
