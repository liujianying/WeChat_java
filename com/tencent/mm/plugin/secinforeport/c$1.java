package com.tencent.mm.plugin.secinforeport;

import android.util.Base64;
import com.tencent.c.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;

class c$1 implements b {
    final /* synthetic */ c mOq;

    c$1(c cVar) {
        this.mOq = cVar;
    }

    public final boolean o(int i, byte[] bArr) {
        if (i == 0) {
            String encodeToString = Base64.encodeToString(bArr, 2);
            Object[][] objArr = new Object[1][];
            objArr[0] = new Object[]{"\u001e<:& *\u001e&3\u0005!3'\u0007%(?ol", encodeToString};
            c.a(this.mOq, com.tencent.mm.plugin.normsg.a.b.lFJ.a(objArr).getBytes(Charset.forName("UTF-8")));
            return true;
        }
        x.w("MicroMsg.SecInfoReporterImpl", "TuringService recvReqData failed, code: " + i);
        return false;
    }
}
