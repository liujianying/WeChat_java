package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.ui.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class e$1 implements a {
    final /* synthetic */ e eMG;

    e$1(e eVar) {
        this.eMG = eVar;
    }

    public final void d(int i, String str, int i2) {
        x.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        ao aoVar = (ao) this.eMG.getItem(i);
        if (aoVar == null) {
            x.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[]{str});
        } else if (bi.oW(aoVar.getUsername())) {
            x.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[]{str});
        } else {
            x.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[]{aoVar.toString()});
            if (aoVar.eLx == 0) {
                int[] iArr = new int[]{o.cx(aoVar.eLw)};
                g gVar = new g(e.a(this.eMG), new 1(this), (byte) 0);
                gVar.g(iArr);
                gVar.eNh = aoVar.eLw;
                aoVar.dHO = 1;
                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar.eLw, aoVar);
                this.eMG.WT();
            } else if (aoVar.eLx == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(e.a(this.eMG), new 2(this));
                aVar.eNh = aoVar.eLw;
                aVar.qIe = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(12));
                aVar.b(aoVar.getUsername(), linkedList, true);
                aoVar.dHO = 1;
                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar.eLw, aoVar);
                this.eMG.WT();
            }
        }
    }
}
