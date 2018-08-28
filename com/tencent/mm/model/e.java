package com.tencent.mm.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;

public class e implements d {
    private static final a dAq = new a();

    private static final class a extends com.tencent.mm.by.a<com.tencent.mm.plugin.messenger.foundation.a.a> implements com.tencent.mm.plugin.messenger.foundation.a.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(com.tencent.mm.ab.d.a aVar, bd bdVar, String str, String str2, boolean z) {
            a(new 1(this, aVar, bdVar, str, str2, z));
        }

        public final void b(com.tencent.mm.ab.d.a aVar, bd bdVar, String str, String str2, boolean z) {
            a(new 2(this, aVar, bdVar, str, str2, z));
        }
    }

    public static void a(com.tencent.mm.plugin.messenger.foundation.a.a aVar) {
        dAq.aI(aVar);
    }

    public b b(com.tencent.mm.ab.d.a aVar) {
        by byVar = aVar.dIN;
        String str = (String) g.Ei().DT().get(2, "");
        if (str.length() <= 0) {
            return null;
        }
        String a = ab.a(byVar.rcj);
        String a2 = ab.a(byVar.rck);
        if (bi.oV(a).length() <= 0 || bi.oV(a2).length() <= 0) {
            x.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
            return null;
        }
        bd a3 = a(byVar, a, a2, str);
        if (a3 == null) {
            return null;
        }
        int i;
        bd bdVar;
        b bVar;
        boolean z = ((i) g.l(i.class)).FZ().has(a) || str.equals(a);
        if (z) {
            a3.eX(1);
            a3.ep(a2);
            i = byVar.hcd;
            bdVar = a3;
        } else {
            a3.eX(0);
            a3.ep(a);
            if (byVar.hcd > 3) {
                i = byVar.hcd;
                bdVar = a3;
            } else {
                i = 3;
                bdVar = a3;
            }
        }
        bdVar.setStatus(i);
        if (byVar.jQd == 10000) {
            a3.setStatus(4);
        }
        a3.dt(byVar.rco);
        if (a3.YU(q.GF())) {
            ai Yq = ((i) g.l(i.class)).FW().Yq(a3.field_talker);
            if (Yq != null) {
                Yq.gg(16777216);
                ((i) g.l(i.class)).FW().a(Yq, a3.field_talker);
            }
        }
        dAq.a(aVar, a3, a, a2, z);
        if (a3.field_msgId == 0) {
            bd.a(a3, aVar);
            a3.setMsgId(bd.i(a3));
            bVar = new b(a3, true);
        } else {
            ((i) g.l(i.class)).bcY().b(byVar.rcq, a3);
            bVar = new b(a3, false);
        }
        dAq.b(aVar, a3, a, a2, z);
        return bVar;
    }

    public bd a(by byVar, String str, String str2, String str3) {
        String str4 = str3.equals(str) ? str2 : str;
        bd I = ((i) g.l(i.class)).bcY().I(str4, byVar.rcq);
        x.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId), str, str2, str4});
        if (I.field_msgId != 0 && I.field_createTime + 604800000 < bd.o(str4, (long) byVar.lOH)) {
            x.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId)});
            bd.aU(I.field_msgId);
            I.setMsgId(0);
        }
        if (I.field_msgId != 0) {
            return I;
        }
        I = new bd();
        I.ax(byVar.rcq);
        I.ay(bd.o(str4, (long) byVar.lOH));
        I.setType(byVar.jQd);
        I.setContent(bi.Xk(bi.oV(ab.a(byVar.rcl))));
        return I;
    }

    public void h(bd bdVar) {
    }
}
