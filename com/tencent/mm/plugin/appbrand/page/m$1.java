package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class m$1 implements c {
    final /* synthetic */ m gmG;

    m$1(m mVar) {
        this.gmG = mVar;
    }

    public final void a(l lVar) {
        for (k kVar : this.gmG.gmF) {
            if (!(kVar == null || kVar.gju)) {
                Context context = this.gmG.fFv.mContext;
                p pVar = this.gmG.fFv;
                String str = this.gmG.mAppId;
                this.gmG.gmE.uJU.booleanValue();
                if (kVar != null) {
                    a aVar = (a) m.a.gjN.gjM.get(Integer.valueOf(kVar.id));
                    if (aVar != null) {
                        aVar.a(context, pVar, lVar, str);
                    }
                }
            }
        }
    }
}
