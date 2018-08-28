package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.account.bind.ui.d.1;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1$1 implements a {
    final /* synthetic */ 1 eIF;

    d$1$1(1 1) {
        this.eIF = 1;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        x.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
        com.tencent.mm.plugin.account.friend.a.a pq = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pq(str2);
        if (pq == null) {
            x.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[]{str2});
        } else if (z) {
            pq.username = str;
            pq.status = 2;
            pq.dHO = 2;
            x.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[]{pq.toString()});
            ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(str2, pq);
            this.eIF.eIE.WT();
            br.IE().c(26, new Object[0]);
        }
    }
}
