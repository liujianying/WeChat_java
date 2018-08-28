package com.tencent.mm.plugin.chatroom.e;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class a implements com.tencent.mm.model.bv.a {
    public final void a(com.tencent.mm.ab.d.a aVar) {
        int i = 1;
        by byVar = aVar.dIN;
        if (byVar.jQd == 10002) {
            String a = ab.a(byVar.rcl);
            if (bi.oW(a)) {
                x.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
                return;
            }
            String a2 = ab.a(byVar.rcj);
            au.HU();
            bd I = c.FT().I(a2, byVar.rcq);
            if (I.field_msgId <= 0) {
                i = 0;
            }
            I.ax(byVar.rcq);
            I.ay(com.tencent.mm.model.bd.o(a2, (long) byVar.lOH));
            I.setType(10002);
            I.setContent(a);
            I.eX(0);
            I.ep(a2);
            I.dt(byVar.rco);
            I.eC(I.cqa & -129);
            com.tencent.mm.model.bd.a(I, aVar);
            if (i == 0) {
                com.tencent.mm.model.bd.i(I);
                return;
            }
            au.HU();
            c.FT().b(byVar.rcq, I);
            return;
        }
        x.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(byVar.jQd)});
    }
}
