package com.tencent.mm.plugin.fav.b.b;

import com.tencent.mm.a.n;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<fy> {
    public b() {
        this.sFo = fy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        fy fyVar = (fy) bVar;
        x.v("MicroMsg.FavNotifyListener", "deal with fav notify");
        if (((ae) g.n(ae.class)).getSendService().TM()) {
            x.w("MicroMsg.FavNotifyListener", "sending item, do not do sync");
        } else {
            byte[] bArr = fyVar.bOJ.bOK;
            g.DF().a(new aj(bArr == null ? 1 : n.r(bArr, 0)), 0);
        }
        return false;
    }
}
