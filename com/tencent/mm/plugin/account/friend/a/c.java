package com.tencent.mm.plugin.account.friend.a;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.aq.l;
import com.tencent.mm.g.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<af> {
    public c() {
        this.sFo = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (afVar.bHo.bHq == 0) {
            try {
                int GQ = q.GQ() | GLIcon.LEFT;
                g.Ei().DT().set(34, Integer.valueOf(GQ));
                ((i) g.l(i.class)).FQ().b(new l("", "", "", "", "", "", "", "", GQ, "", ""));
                x.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
