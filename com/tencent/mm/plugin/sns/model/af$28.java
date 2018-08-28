package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qk;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.plugin.sns.lucky.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.IOException;
import java.nio.charset.Charset;

class af$28 extends c<qk> {
    final /* synthetic */ af nqT;

    af$28(af afVar) {
        this.nqT = afVar;
        this.sFo = qk.class.getName().hashCode();
    }

    private static boolean byD() {
        g.bxc();
        a aVar = a.sSv;
        i iVar = new i();
        try {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Ei().DT().a(aVar, new String(iVar.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            x.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e.getLocalizedMessage());
        }
        return false;
    }
}
