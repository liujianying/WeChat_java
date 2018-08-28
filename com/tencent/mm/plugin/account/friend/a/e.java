package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.g.a.fr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends c<fr> {
    public e() {
        this.sFo = fr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fr frVar = (fr) bVar;
        if (frVar instanceof fr) {
            frVar.bOj.bOm = true;
            if (!bi.oW(l.px(frVar.bOi.bOk))) {
                frVar.bOj.bOm = false;
            } else if (bi.oW(l.px(frVar.bOi.bOl))) {
                x.i("MicroMsg.FMessageMobileFilterListenerImpl", "mobile fmessage not found by phonemd5 or fullphonemd5");
            } else {
                frVar.bOj.bOm = false;
            }
        }
        return false;
    }
}
