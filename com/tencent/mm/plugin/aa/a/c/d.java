package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;

public final class d extends a {
    l eBp = new l();
    e eBq = new e();

    protected final void onCreate() {
        super.onCreate();
        x.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        k Wc = this.eBp.Wc();
        g.Ek();
        g.Eh().dpP.a(1624, Wc);
        g.Ek();
        g.Eh().dpP.a(1655, Wc);
        com.tencent.mm.plugin.aa.a.d VX = this.eBq.VX();
        x.i("MicroMsg.AAOperationData", "init");
        g.Ek();
        g.Eh().dpP.a(1698, VX);
    }

    protected final void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        k Wc = this.eBp.Wc();
        g.Ek();
        g.Eh().dpP.b(1624, Wc);
        g.Ek();
        g.Eh().dpP.b(1655, Wc);
        com.tencent.mm.plugin.aa.a.d VX = this.eBq.VX();
        x.i("MicroMsg.AAOperationData", "uninit");
        g.Ek();
        g.Eh().dpP.b(1698, VX);
    }
}
