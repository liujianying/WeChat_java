package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.j.3;
import com.tencent.mm.protocal.c.cgl;

class j$3$1 implements e {
    final /* synthetic */ 3 ffH;

    j$3$1(3 3) {
        this.ffH = 3;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar != null && (lVar.dJd instanceof b)) {
            cgl cgl = (cgl) ((b) lVar.dJd).dIE.dIL;
            int a = j.a(this.ffH.ffE);
            int i3 = cgl.version;
            aq.b(ae.r("@LibraryAppId", a, i3), new 1(this));
        }
        g.Eh().dpP.b(1168, (e) this);
    }
}
