package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.plugin.account.bind.ui.b.b;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class d$1 implements b {
    final /* synthetic */ d eIE;

    d$1(d dVar) {
        this.eIE = dVar;
    }

    public final void c(int i, String str, int i2) {
        x.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        a aVar = (a) this.eIE.getItem(i);
        if (aVar == null) {
            x.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[]{str});
            return;
        }
        x.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[]{aVar.toString()});
        if (aVar.status == 1) {
            com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(d.a(this.eIE), new 1(this));
            aVar2.qHX = new 2(this, aVar);
            if (d.c(this.eIE) instanceof MobileFriendUI) {
                ((MobileFriendUI) d.e(this.eIE)).geJ = new 3(this, aVar);
            }
            aVar2.eNh = aVar.Xh();
            aVar2.qIe = false;
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(13));
            aVar2.b(aVar.getUsername(), linkedList, false);
        }
    }
}
