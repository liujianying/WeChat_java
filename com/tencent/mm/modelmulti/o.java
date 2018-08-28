package com.tencent.mm.modelmulti;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.modelmulti.b.2;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ax;
import java.util.HashMap;

public class o implements ar {
    public static HashMap<Integer, d> cVM;
    private b eaq;
    private ax ear;

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new d() {
            public final String[] xb() {
                return ax.diD;
            }
        });
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        this.ear = new ax(g.Ei().dqq);
        b PN = PN();
        x.i("MicroMsg.SubCoreSync", "getChatRoomMsgService %s", new Object[]{PN});
        if (PN != null) {
            PO().PL().a(PN, au.Em().lnJ.getLooper());
            ((i) g.l(i.class)).bcY().a(PN.dYI, au.Em().lnJ.getLooper());
            au.Em().H(new 2(PN));
        }
    }

    public final ax PL() {
        g.Ek();
        g.Eg().Ds();
        return this.ear;
    }

    public static p PM() {
        return ((b) g.l(b.class)).PM();
    }

    public static b PN() {
        g.Eg().Ds();
        if (PO().eaq == null) {
            PO().eaq = new b();
        }
        return PO().eaq;
    }

    public static o PO() {
        au.HN();
        o oVar = (o) bs.iK(o.class.getName());
        if (oVar != null) {
            return oVar;
        }
        oVar = new o();
        au.HN().a(o.class.getName(), oVar);
        return oVar;
    }

    public final void onAccountRelease() {
        b bVar = PO().eaq;
        if (bVar != null) {
            x.i("MicroMsg.GetChatRoomMsgService", "clear clearList.size:%d needGetInfosMap.size:%d respList.size:%d, currentListener:%s", new Object[]{Integer.valueOf(bVar.dYF.size()), Integer.valueOf(bVar.dYE.size()), Integer.valueOf(bVar.dSN.size()), bVar.dYG});
            bVar.dSR.SO();
            bVar.dSS.SO();
            bVar.dYF.clear();
            bVar.dYE.clear();
            bVar.dSN.clear();
            bVar.dYG = null;
            bVar.dGS = false;
            PO().PL().d(bVar);
            ((i) g.l(i.class)).bcY().a(bVar.dYI);
        }
    }
}
