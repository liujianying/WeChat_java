package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$4 extends c<e> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$4(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        e eVar = (e) bVar;
        if (!(SnsTimeLineUI.g(this.odw) == null || SnsTimeLineUI.g(this.odw).nLK == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
            boolean z2 = eVar.bGf.ahg;
            String str = eVar.bGf.className;
            if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                z = false;
            }
            if (!z) {
                x.d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
            } else if (!z2) {
                bVar2.nwn = System.currentTimeMillis();
            } else if (bVar2.nwn > 0) {
                bVar2.nwm += System.currentTimeMillis() - bVar2.nwn;
                bVar2.nwn = 0;
            }
        }
        return false;
    }
}
