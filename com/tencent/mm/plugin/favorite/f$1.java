package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class f$1 extends c<fx> {
    final /* synthetic */ f jfY;

    f$1(f fVar) {
        this.jfY = fVar;
        this.sFo = fx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fx fxVar = (fx) bVar;
        if (fxVar.bOG.bOH != null && (fxVar.bOG.bOH instanceof a) && fxVar.bOG.bHj != null && (fxVar.bOG.bHj instanceof Context)) {
            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fxVar.bOG.bJA);
            g Bf = (dy != null || bi.oW(fxVar.bOG.bOI)) ? dy : com.tencent.mm.plugin.fav.a.b.Bf(fxVar.bOG.bOI);
            a aVar = (a) fxVar.bOG.bOH;
            Context context = (Context) fxVar.bOG.bHj;
            d.a(aVar, context, Bf);
            d.b(aVar, context, Bf);
        }
        fxVar.bOG.bJA = 0;
        fxVar.bOG.bOH = null;
        fxVar.bOG.bHj = null;
        return false;
    }
}
