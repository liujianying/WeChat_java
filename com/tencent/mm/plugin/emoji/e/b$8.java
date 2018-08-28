package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.mj;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class b$8 extends c<mj> {
    final /* synthetic */ b ifh;

    b$8(b bVar) {
        this.ifh = bVar;
        this.sFo = mj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mj mjVar = (mj) bVar;
        if (!(mjVar == null || !(mjVar instanceof mj) || mjVar.bXk == null)) {
            String str = mjVar.bXk.bKk;
            if (!bi.oW(str) && i.aEA().igy.Zt(str)) {
                i.aEv().aDI();
            }
        }
        return false;
    }
}
