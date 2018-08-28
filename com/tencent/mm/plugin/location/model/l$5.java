package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.bk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class l$5 extends c<bk> {
    final /* synthetic */ l kDB;

    l$5(l lVar) {
        this.kDB = lVar;
        this.sFo = bk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        j aZh = l.aZh();
        x.i("MicroMsg.StaticMapMsgLogic", "clean task");
        aZh.kCU.clear();
        aZh.kCY.clear();
        aZh.kCZ.clear();
        aZh.kCW.clear();
        aZh.kCX.clear();
        aZh.kDa.clear();
        aZh.kCV.clear();
        l.aZg().a(aZh);
        l.aZg().a(aZh);
        return false;
    }
}
