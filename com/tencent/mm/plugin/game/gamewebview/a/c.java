package com.tencent.mm.plugin.game.gamewebview.a;

import android.content.Context;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.game.model.am.a;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.protocal.c.yf;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static void E(Context context, int i) {
        a g = a.g(12909, new Object[]{Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), null, Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(bi.getInt(null, 0)), Integer.valueOf(an.getNetworkType(context)), null});
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.dIF = 427;
        aVar.dII = 0;
        aVar.dIJ = 0;
        yf yfVar = new yf();
        yfVar.rjL = d.qVI;
        yfVar.rjM = d.qVH;
        yfVar.rjN = d.qVK;
        yfVar.rjO = d.qVL;
        yfVar.rjP = w.chP();
        yfVar.mEk = g.eiF;
        yfVar.rjQ = g.jOg;
        aVar.dIG = yfVar;
    }
}
