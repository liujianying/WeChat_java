package com.tencent.mm.plugin.zero;

import com.tencent.mm.k.e;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class a implements c, com.tencent.mm.plugin.zero.b.a {
    private com.tencent.mm.k.c qxA = new com.tencent.mm.k.c();
    private e qxz = new e();

    public final e AT() {
        g.Ek();
        g.Eg().Ds();
        return this.qxz;
    }

    public final com.tencent.mm.k.c AU() {
        g.Ek();
        g.Eg().Ds();
        return this.qxA;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (cVar.dqH) {
            com.tencent.mm.k.c cVar2 = this.qxA;
            File file = new File(com.tencent.mm.compatible.util.e.bnE + "configlist/");
            if (file.exists()) {
                File file2 = new File(com.tencent.mm.k.c.dgQ);
                if (!file2.exists()) {
                    x.d("MicroMsg.ConfigListDecoder", "bugfix");
                    cVar2.d(file, file2);
                }
            }
        }
        this.qxz.kS();
        this.qxA.init();
    }

    public final void onAccountRelease() {
    }
}
