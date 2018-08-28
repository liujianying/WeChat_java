package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.ph;
import com.tencent.mm.protocal.c.pi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;

public enum a implements b {
    ;

    private a(String str) {
    }

    public final void a(int i, String str, int i2, byte[] bArr) {
        if (str == null) {
            x.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
        } else if (g.Eg().Dx()) {
            ph phVar = new ph();
            phVar.rtD = i;
            phVar.rtF = i2;
            phVar.rtE = new bhy().bq(str.getBytes(Charset.forName("UTF-8")));
            if (!bi.bC(bArr)) {
                phVar.rtG = new bhy().bq(bArr);
            }
            pi piVar = new pi();
            piVar.rtI.add(phVar);
            piVar.rtH = piVar.rtI.size();
            ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(211, piVar));
        }
    }
}
