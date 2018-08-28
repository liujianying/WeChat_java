package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Set;

public final class q {
    private volatile ah dJt;
    private final Object gBw;
    public final c pTk;
    public final c pTl;
    private volatile i pTm;
    final SparseArray<l> pTn;
    public final c pTo;
    final e pTp;
    public final byte[] pTq;
    public final SparseArray<Set<Object>> pTr;

    private static final class a {
        private static final q pTz = new q();
    }

    /* synthetic */ q(byte b) {
        this();
    }

    private q() {
        this.pTk = new c<tu>() {
            {
                this.sFo = tu.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                tu tuVar = (tu) bVar;
                if (tuVar != null) {
                    q.this.Em().H(new 1(this, new f(tuVar.cfw.url, tuVar.cfw.filePath, tuVar.cfw.version, tuVar.cfw.appId, tuVar.cfw.cfx, tuVar.cfw.cfy, tuVar.cfw.cfz, tuVar.cfw.aBC, tuVar.cfw.cfA, tuVar.cfw.exception)));
                }
                return false;
            }
        };
        this.pTl = new 2(this);
        this.pTn = new SparseArray();
        this.pTo = new c();
        this.pTp = new e();
        this.gBw = new Object();
        this.pTq = new byte[0];
        this.pTr = new SparseArray();
    }

    public final void release(boolean z) {
        for (int i = 0; i < this.pTn.size(); i++) {
            this.pTn.valueAt(i);
        }
        this.pTn.clear();
        a.clearCache();
        if (this.dJt != null) {
            synchronized (this.gBw) {
                if (this.dJt == null) {
                } else if (z) {
                    this.dJt.lnJ.quit();
                } else {
                    this.dJt.H(new 4(this, this.dJt));
                    this.dJt = null;
                }
            }
        }
    }

    public final ah Em() {
        if (this.dJt == null) {
            synchronized (this.gBw) {
                if (this.dJt == null) {
                    this.dJt = new 3(this, "WebViewCacheWorkerManager#WorkerThread");
                }
            }
        }
        return this.dJt;
    }

    public final void Ar(int i) {
        if (au.HX()) {
            try {
                Set set;
                a.pTz.pTp.Ao(i);
                synchronized (this.pTq) {
                    set = (Set) this.pTr.get(i);
                }
                if (set == null) {
                    return;
                }
                if (set.size() > 0) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (this.pTm == null) {
                            this.pTm = new i();
                        }
                        i iVar = this.pTm;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewCacheWorkerManager", "onWebViewUIDestroy, accHasReady, but occurred exception = %s", new Object[]{e});
            }
        }
    }
}
