package com.tencent.mm.ac.a;

import com.tencent.mm.ac.a.b.a.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.d;

class e$1 implements Runnable {
    final /* synthetic */ a dAD = null;
    final /* synthetic */ String dNs;
    final /* synthetic */ boolean dNt;

    e$1(String str, boolean z) {
        this.dNs = str;
        this.dNt = z;
    }

    public final void run() {
        b Nb = z.Nb();
        String str = this.dNs;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("' ");
        x.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[]{stringBuilder.toString(), Boolean.valueOf(Nb.diF.fV("BizChatConversation", stringBuilder.toString()))});
        if (Nb.diF.fV("BizChatConversation", stringBuilder.toString())) {
            a aVar = new a();
            b bVar = new b();
            bVar.dNf = -1;
            bVar.bKC = str;
            bVar.dNe = b.a.a.dNb;
            bVar.dNg = aVar;
            Nb.dKC.ci(bVar);
            Nb.dKC.doNotify();
        }
        ((i) g.l(i.class)).FW().Yp(this.dNs);
        d Na = z.Na();
        str = this.dNs;
        stringBuilder = new StringBuilder();
        stringBuilder.append("delete from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("' ");
        x.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[]{stringBuilder.toString(), Boolean.valueOf(Na.diF.fV("BizChatInfo", stringBuilder.toString()))});
        if (Na.diF.fV("BizChatInfo", stringBuilder.toString())) {
            c cVar = new c();
            d$a$b d_a_b = new d$a$b();
            d_a_b.dNf = -1;
            d_a_b.bKC = str;
            d_a_b.dNp = d.a.a.dNm;
            d_a_b.dNq = cVar;
            Na.dKC.ci(d_a_b);
            Na.dKC.doNotify();
        }
        d.I(e.cy(this.dNs), true);
        if (this.dNt) {
            k Nc = z.Nc();
            str = this.dNs;
            stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatUserInfo");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            x.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[]{stringBuilder.toString(), Boolean.valueOf(Nc.diF.fV("BizChatUserInfo", stringBuilder.toString()))});
            if (Nc.diF.fV("BizChatUserInfo", stringBuilder.toString())) {
                j jVar = new j();
                k.a.b bVar2 = new k.a.b();
                bVar2.dNR = k.a.a.dNO;
                bVar2.dNS = jVar;
                Nc.dKC.ci(bVar2);
                Nc.dKC.doNotify();
            }
            z.Nd().ll(this.dNs);
            d.I(e.lj(this.dNs), true);
        }
        ah.A(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|deleteMsgByTalkers";
    }
}
