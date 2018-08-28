package com.tencent.mm.plugin.report.b;

import com.tencent.b.a.a.f;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements f {
    d$1() {
    }

    public final void cg(String str) {
        x.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[]{str, Integer.valueOf(d.bB())});
        if (d.wz() <= 0) {
            x.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[]{Integer.valueOf(d.bB())});
            return;
        }
        a aVar = new a();
        aVar.dIG = new bdy();
        aVar.dIH = new bdz();
        aVar.uri = "/cgi-bin/micromsg-bin/querymid";
        aVar.dIF = 684;
        b KT = aVar.KT();
        ((bdy) KT.dID.dIL).fWF = str;
        ((bdy) KT.dID.dIL).jRb = 1;
        v.a(KT, new 1(this), true);
    }
}
