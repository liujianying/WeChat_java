package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnClickListener {
    final /* synthetic */ b quG;

    b$1(b bVar) {
        this.quG = bVar;
    }

    public final void onClick(View view) {
        x.i("WNNoteBanner", "click WNNoteBanner");
        p bZY = h.bZX().bZY();
        if (bZY == null) {
            x.i("WNNoteBanner", "keepTopItem is null");
            this.quG.setVisibility(8);
        } else if (bZY.qpf) {
            if (bZY.qpi) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14789, new Object[]{Integer.valueOf(3)});
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14789, new Object[]{Integer.valueOf(2)});
            }
            x.i("WNNoteBanner", "isOpenFromSession: true");
            j jVar = new j();
            c.bZb().qnC = jVar;
            wn wnVar = new wn();
            wnVar.scene = 8;
            jVar.a(bZY.qpk, Long.valueOf(bZY.qph), true, (Context) this.quG.qJS.get(), bZY.qpl, bZY.qpm, wnVar);
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.h(14789, new Object[]{Integer.valueOf(1)});
            x.i("WNNoteBanner", "isOpenFromSession: false");
            g gVar = new g();
            c.bZb().qnC = gVar;
            wn wnVar2 = new wn();
            wnVar2.scene = 8;
            gVar.a(bZY.qpg, (Context) this.quG.qJS.get(), Boolean.valueOf(true), bZY.qpl, bZY.qpm, wnVar2);
        }
    }
}
