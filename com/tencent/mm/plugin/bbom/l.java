package com.tencent.mm.plugin.bbom;

import com.tencent.mm.bk.a;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.u;

public final class l implements r<by> {
    public final /* synthetic */ void e(a aVar) {
        String a = ab.a(((by) aVar).rcj);
        if (s.fq(a)) {
            au.HU();
            u ii = c.Ga().ii(a);
            au.HU();
            com.tencent.mm.storage.ab Yg = c.FR().Yg(a);
            if (Yg == null || ((int) Yg.dhP) <= 0) {
                am.a.dBr.a(a, null, new 1(this, ii, a));
            } else if (ii.ckL()) {
                jy jyVar = new jy();
                jyVar.bUc.chatroomName = a;
                jyVar.bUc.bUd = ii.ckK();
                com.tencent.mm.sdk.b.a.sFg.m(jyVar);
            }
        }
    }

    public final /* synthetic */ void f(a aVar) {
        String a = ab.a(((by) aVar).rcj);
        if (!bi.oW(a) && !((i) g.l(i.class)).FR().Yi(a)) {
            am.a.dBr.R(a, "");
        }
    }
}
