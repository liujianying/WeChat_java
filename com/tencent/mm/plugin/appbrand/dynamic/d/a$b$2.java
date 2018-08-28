package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.sdk.platformtools.x;

class a$b$2 implements a {
    final /* synthetic */ String fvL;
    final /* synthetic */ b fvM;
    final /* synthetic */ int fvO;

    a$b$2(b bVar, int i, String str) {
        this.fvM = bVar;
        this.fvO = i;
        this.fvL = str;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.b bVar) {
        x.d("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null && this.fvO != 2) {
            aos aos = (aos) bVar.dIE.dIL;
            int i3 = aos.rRd.bMH;
            String str2 = aos.rRd.bMI;
            x.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorizeConfirm jsErrcode[%d], jsErrmsg[%s]", Integer.valueOf(i3), str2);
            if (i3 == 0) {
                b.a(this.fvM, this.fvL);
            }
        }
    }
}
