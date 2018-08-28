package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$a$1 implements Runnable {
    final /* synthetic */ boolean iXU;
    final /* synthetic */ a iXV;

    b$a$1(a aVar, boolean z) {
        this.iXV = aVar;
        this.iXU = z;
    }

    public final void run() {
        if (this.iXU) {
            x.i("MicroMsg.Fav.FavAddService", "has data, check cdn now, type %d", new Object[]{Integer.valueOf(this.iXV.iWQ.field_type)});
            this.iXV.iWQ.field_itemStatus = 1;
            this.iXV.iWQ.field_xml = g.s(this.iXV.iWQ);
            if (b.k(this.iXV.iWQ)) {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(this.iXV.iWQ, new String[0]);
            } else {
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().y(this.iXV.iWQ);
            }
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getCheckCdnService().run();
            return;
        }
        x.i("MicroMsg.Fav.FavAddService", "no data, send item now, type %d", new Object[]{Integer.valueOf(this.iXV.iWQ.field_type)});
        this.iXV.iWQ.field_itemStatus = 9;
        this.iXV.iWQ.field_xml = g.s(this.iXV.iWQ);
        if (b.k(this.iXV.iWQ)) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(this.iXV.iWQ, new String[0]);
        } else {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().y(this.iXV.iWQ);
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getSendService().run();
    }
}
