package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements r<by> {
    final /* synthetic */ g qmg;

    g$4(g gVar) {
        this.qmg = gVar;
    }

    public final /* synthetic */ void e(a aVar) {
        by byVar = (by) aVar;
        if (byVar.jQd != 51 && q.GF().equals(byVar.rcj.siM)) {
            au.HU();
            cm I = c.FT().I(byVar.rck.siM, byVar.rcq);
            if (I.field_msgSvrId == 0) {
                x.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(byVar.rcq));
                return;
            }
            x.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] selfSend msg, svrID:%d, localId:%d", Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId));
            g.bYF().bYH().fF(I.field_msgId);
        }
    }

    public final /* bridge */ /* synthetic */ void f(a aVar) {
    }
}
