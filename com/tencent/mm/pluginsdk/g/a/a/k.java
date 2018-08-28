package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.f;
import com.tencent.mm.pluginsdk.g.a.c.f.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.u;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k extends f<a> {
    private final a qCE = new a(this, 0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new u());

    k() {
    }

    static void f(s sVar) {
        new a(a.a(sVar)).run();
    }

    final void a(a aVar) {
        if (Tl(aVar.qBy)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[]{aVar.qBy});
            return;
        }
        int i;
        if (!(aVar.qBz && aVar.bIE == aVar.qBC && aVar.qBC >= 0) && (aVar.qBz || !aVar.qBA)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[]{aVar.qBy});
            super.b(aVar);
        }
    }

    protected final a ccv() {
        return this.qCE;
    }
}
