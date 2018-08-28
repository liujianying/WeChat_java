package com.tencent.mm.plugin.websearch.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.protocal.c.bjn;
import com.tencent.mm.protocal.c.bjo;
import org.xwalk.core.Log;

class a$1 implements a {
    final /* synthetic */ d pMW;
    final /* synthetic */ com.tencent.mm.plugin.websearch.a.a pMX;
    final /* synthetic */ a pMY;

    a$1(a aVar, d dVar, com.tencent.mm.plugin.websearch.a.a aVar2) {
        this.pMY = aVar;
        this.pMW = dVar;
        this.pMX = aVar2;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (this.pMW != null) {
            if (i == 0 && i2 == 0) {
                this.pMW.a(true, ((bjo) this.pMX.diG.dIE.dIL).sjz, ((bjo) this.pMX.diG.dIE.dIL).rlo, ((bjn) this.pMX.diG.dID.dIL).sjx);
            } else {
                Log.w("RelevantSearchService", "search local page error " + str);
                this.pMW.a(false, null, null, null);
            }
        }
        return 0;
    }
}
