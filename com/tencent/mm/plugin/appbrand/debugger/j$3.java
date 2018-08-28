package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements a {
    final /* synthetic */ j fti;

    j$3(j jVar) {
        this.fti = jVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            this.fti.ftb.sk(((ahi) bVar.dIE.dIL).rKJ);
            x.i("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", new Object[]{r0.rKJ});
            if (this.fti.fte.isOpen()) {
                j.a(this.fti);
                return;
            }
            return;
        }
        String str2 = "MicroMsg.RemoteDebugJsEngine";
        String str3 = "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Boolean.valueOf(bVar.dIE.dIL == null);
        x.e(str2, str3, objArr);
    }
}
