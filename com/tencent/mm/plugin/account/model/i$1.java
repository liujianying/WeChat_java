package com.tencent.mm.plugin.account.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al.a;

class i$1 implements a {
    i$1() {
    }

    public final boolean vD() {
        i.wy();
        if (i.bB() == 1 || i.bB() == 16 || i.bB() % 96 == 0) {
            ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().xS();
        }
        return true;
    }
}
