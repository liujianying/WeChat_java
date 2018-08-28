package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.g.a.jz;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

class ExtControlProviderNearBy$3 extends b {
    final /* synthetic */ ExtControlProviderNearBy iKu;

    ExtControlProviderNearBy$3(ExtControlProviderNearBy extControlProviderNearBy) {
        this.iKu = extControlProviderNearBy;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        if ((bVar instanceof jz) && ExtControlProviderNearBy.c(this.iKu) != null) {
            jz jzVar = (jz) bVar;
            x.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i2 + ", errType: " + i);
            if (i == 0 && i2 == 0) {
                ExtControlProviderNearBy.a(this.iKu, jzVar.bUf.bUm);
                if (ExtControlProviderNearBy.d(this.iKu) == null || ExtControlProviderNearBy.d(this.iKu).size() == 0) {
                    x.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                    ExtControlProviderNearBy.c(this.iKu).countDown();
                } else {
                    if (ExtControlProviderNearBy.d(this.iKu).size() > 10) {
                        x.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(this.iKu).size());
                        ExtControlProviderNearBy.d(this.iKu).subList(10, ExtControlProviderNearBy.d(this.iKu).size()).clear();
                    }
                    ExtControlProviderNearBy.a(this.iKu, new CountDownLatch(ExtControlProviderNearBy.d(this.iKu).size()));
                    ExtControlProviderNearBy.c(this.iKu).countDown();
                    ExtControlProviderNearBy.e(this.iKu);
                }
            } else {
                x.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i2 + ", errType=" + i);
                ExtControlProviderNearBy.c(this.iKu).countDown();
            }
            ExtControlProviderNearBy.f(this.iKu);
        }
    }
}
