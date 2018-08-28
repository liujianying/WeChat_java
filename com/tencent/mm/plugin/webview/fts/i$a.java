package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.k;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class i$a implements Comparable {
    private ThreadPoolExecutor pPA;
    public a pPB;
    public a pPn;
    final /* synthetic */ i pPx;

    private i$a(i iVar) {
        this.pPx = iVar;
        this.pPA = new ThreadPoolExecutor(0, 10, 120, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
    }

    /* synthetic */ i$a(i iVar, byte b) {
        this(iVar);
    }

    static /* synthetic */ a c(j jVar) {
        a kVar = (!i.Ah(jVar.scene) || n.aot()) ? i.Ai(jVar.scene) ? new k(jVar) : new f(jVar) : new o(jVar);
        kVar.pKL = jVar.bWo;
        return kVar;
    }

    public final void b(j jVar) {
        if (this.pPB != null) {
            this.pPB.gYf = true;
        }
        this.pPB = new a(this, (byte) 0);
        this.pPB.dFC = jVar;
        i.a(this.pPx, jVar);
        this.pPA.execute(this.pPB);
    }

    public final int compareTo(Object obj) {
        return 0;
    }
}
