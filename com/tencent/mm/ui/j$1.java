package com.tencent.mm.ui;

import com.tencent.mm.g.a.ia;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class j$1 extends c<ia> {
    final /* synthetic */ j tjf;

    j$1(j jVar) {
        this.tjf = jVar;
        this.sFo = ia.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ia iaVar = (ia) bVar;
        if (iaVar == null || iaVar.bRy == null || iaVar.bRy.bRz == null) {
            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event is illegal event[%s]", new Object[]{iaVar});
        } else {
            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event launcherUI isResumeStatus[%b], tid[%d]", new Object[]{Boolean.valueOf(this.tjf.tiZ.cpA()), Long.valueOf(Thread.currentThread().getId())});
            if (this.tjf.tiZ.cpA()) {
                this.tjf.tja = null;
                this.tjf.a(iaVar.bRy);
            } else {
                this.tjf.tja = iaVar.bRy;
            }
        }
        return false;
    }
}
