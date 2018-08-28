package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.pluginsdk.c.c;
import java.util.HashMap;

public class d implements ar {
    private static a hKH;
    private c<jv> hKB = new 1(this);
    private c<jy> hKC = new 2(this);
    private c<jx> hKD = new 3(this);
    private c<kc> hKE = new 4(this);
    private c<jw> hKF = new 5(this);
    private com.tencent.mm.sdk.b.c hKG = new 6(this);

    private static d aAs() {
        au.HN();
        d dVar = (d) bs.iK("plugin.chatroom");
        if (dVar == null) {
            synchronized (d.class) {
                if (dVar == null) {
                    dVar = new d();
                    au.HN().a("plugin.chatroom", dVar);
                }
            }
        }
        return dVar;
    }

    private static a aAt() {
        g.Eg().Ds();
        aAs();
        if (hKH == null) {
            aAs();
            hKH = new a();
        }
        aAs();
        return hKH;
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.sdk.b.a.sFg.b(this.hKG);
        com.tencent.mm.sdk.b.a.sFg.b(this.hKB);
        com.tencent.mm.sdk.b.a.sFg.b(this.hKF);
        com.tencent.mm.sdk.b.a.sFg.b(this.hKC);
        com.tencent.mm.sdk.b.a.sFg.b(this.hKD);
        com.tencent.mm.sdk.b.a.sFg.b(this.hKE);
        a aAt = aAt();
        au.getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", aAt.hKS, true);
        au.getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", aAt.hKS, true);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.hKG);
        com.tencent.mm.sdk.b.a.sFg.c(this.hKB);
        com.tencent.mm.sdk.b.a.sFg.c(this.hKF);
        com.tencent.mm.sdk.b.a.sFg.c(this.hKC);
        com.tencent.mm.sdk.b.a.sFg.c(this.hKD);
        com.tencent.mm.sdk.b.a.sFg.c(this.hKE);
        a aAt = aAt();
        au.getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", aAt.hKS, true);
        au.getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", aAt.hKS, true);
    }
}
