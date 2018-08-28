package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.b;
import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.g;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;

public class f extends a {
    c eBw = new c();
    g eBx = new g();
    j eBy = new j();

    protected final void onCreate() {
        super.onCreate();
        b VS = this.eBw.VS();
        x.i("MicroMsg.AAGetPaylistDetailLogic", "init");
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(1695, VS);
        com.tencent.mm.plugin.aa.a.f VY = this.eBx.VY();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(1629, VY);
        this.eBy.Wb().init();
    }

    protected final void onDestroy() {
        super.onDestroy();
        b VS = this.eBw.VS();
        x.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(1695, VS);
        com.tencent.mm.plugin.aa.a.f VY = this.eBx.VY();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(1629, VY);
        this.eBy.Wb().Wa();
    }
}
