package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Looper;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public final class q {
    private volatile ah dJt;
    public final boolean fAQ;
    public final ag handler;
    public final t qDu;
    public final n qDv;
    public final i qDw;

    /* synthetic */ q(byte b) {
        this();
    }

    private q() {
        this.dJt = null;
        r.init();
        this.qDu = t.ccJ();
        if (this.qDu == null) {
            this.fAQ = false;
            this.qDv = null;
            this.handler = null;
            this.qDw = null;
            return;
        }
        this.fAQ = true;
        u uVar = new u();
        this.handler = new ag(Looper.getMainLooper());
        this.qDw = new i(Em().cil());
        this.qDv = new n(uVar, this.qDw);
    }

    public final void C(Runnable runnable) {
        Em().H(new b(runnable, (byte) 0));
    }

    final ah Em() {
        if (this.dJt == null) {
            this.dJt = new ah("ResDownloader-WorkerThread");
        }
        return this.dJt;
    }

    public final void a(String str, d dVar) {
        x.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[]{str, dVar});
        if (this.fAQ) {
            i iVar = this.qDw;
            x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = " + dVar);
            if (dVar != null) {
                int hashCode = str.hashCode();
                synchronized (iVar.qDa) {
                    List list = (List) iVar.qCZ.get(hashCode);
                    if (list == null) {
                        list = new LinkedList();
                    }
                    list.add(dVar);
                    iVar.qCZ.put(hashCode, list);
                }
            }
        }
    }

    static a c(l lVar) {
        x.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = lVar.aca().hashCode();
        for (g gVar : r.ccI()) {
            x.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[]{gVar.getClass().getSimpleName(), gVar.aca()});
            if (gVar.aca().hashCode() == hashCode) {
                return gVar.c(lVar);
            }
        }
        return null;
    }

    public final void g(s sVar) {
        if (this.fAQ) {
            boolean z;
            long VF = bi.VF();
            if (this.qDu.Tn(sVar.field_urlKey) != null) {
                this.qDu.h(sVar);
                z = false;
            } else {
                this.qDu.i(sVar);
                z = true;
            }
            x.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[]{sVar.field_urlKey, Boolean.valueOf(z), Long.valueOf(bi.bH(VF))});
        }
    }

    public final s Tn(String str) {
        if (!this.fAQ) {
            return null;
        }
        long VF = bi.VF();
        s Tn = this.qDu.Tn(str);
        String str2 = "MicroMsg.ResDownloaderCore";
        String str3 = "doQuery: urlKey = %s, cost = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Tn == null ? "null" : Tn.field_urlKey;
        objArr[1] = Long.valueOf(bi.bH(VF));
        x.i(str2, str3, objArr);
        return Tn;
    }

    public final int d(l lVar) {
        if (!this.fAQ) {
            return -1;
        }
        if (bi.oW(lVar.url)) {
            x.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[]{lVar.qBy});
            return 3;
        }
        x.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[]{lVar.qBy});
        return this.qDv.b(lVar);
    }

    public final boolean To(String str) {
        if (!this.fAQ) {
            return false;
        }
        if (this.qDv.isDownloading(str) || this.qDv.Tl(str)) {
            return true;
        }
        return false;
    }

    public final void Tp(String str) {
        if (this.fAQ) {
            n nVar = this.qDv;
            Future future = (Future) nVar.qCV.remove(str);
            if (future != null) {
                future.cancel(true);
            }
            nVar.qCU.remove(str);
        }
    }
}
