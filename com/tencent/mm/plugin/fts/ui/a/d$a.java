package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.a.m.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bi;

public class d$a extends b {
    final /* synthetic */ d jxN;

    public d$a(d dVar) {
        this.jxN = dVar;
        super(dVar);
    }

    public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        d dVar = (d) aVar2;
        m.a aVar3 = (m.a) aVar;
        m.h(aVar3.contentView, this.jxN.jtj);
        if (bi.oW(dVar.fyJ.talker)) {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, dVar.fyJ.jrv);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, dVar.fyJ.talker);
        }
        m.a(dVar.jxL, aVar3.eTm);
        m.a(dVar.eCi, aVar3.hPq);
        m.a(dVar.jyG, aVar3.hrs);
    }
}
