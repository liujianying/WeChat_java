package com.tencent.mm.plugin.hardwareopt.a;

import com.tencent.mm.plugin.hardwareopt.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.e;

public final class a implements com.tencent.mm.plugin.hardwareopt.a.a.a {
    public final void fD(boolean z) {
        new e().w(new Object[]{ad.getContext()}).e(new com.tencent.mm.plugin.hardwareopt.c.a()).d(new b(z)).a(new com.tencent.mm.vending.g.d.a() {
            public final void bd(Object obj) {
                x.w("MicroMsg.HardwareProvider", "hy: on interrupt.");
            }
        }).a(new 1(this));
    }
}
