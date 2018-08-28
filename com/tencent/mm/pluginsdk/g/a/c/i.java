package com.tencent.mm.pluginsdk.g.a.c;

import android.util.SparseArray;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i implements c {
    private final ag qCY;
    public final SparseArray<List<d>> qCZ = new SparseArray();
    public final Object qDa = new Object();

    i(ag agVar) {
        this.qCY = agVar;
    }

    public final void a(e eVar, m mVar) {
        x.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = " + mVar);
        s Tn;
        List Tm;
        switch (mVar.status) {
            case 2:
                Tn = a.ccH().Tn(mVar.qBy);
                if (Tn != null) {
                    Tn.field_status = 2;
                    a.ccH().g(Tn);
                }
                x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + eVar.aca());
                Tm = Tm(eVar.aca());
                if (bi.cX(Tm)) {
                    x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    return;
                }
                x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + Tm.size());
                this.qCY.post(new 2(this, Tm, mVar, eVar.cco()));
                return;
            case 3:
                Tn = a.ccH().Tn(mVar.qBy);
                if (Tn != null) {
                    Tn.field_status = 3;
                    a.ccH().g(Tn);
                }
                Tm = Tm(eVar.aca());
                if (!bi.cX(Tm)) {
                    this.qCY.post(new 1(this, Tm, mVar, eVar.cco()));
                    return;
                }
                return;
            case 4:
                Tn = a.ccH().Tn(mVar.qBy);
                if (Tn != null) {
                    Tn.field_status = 4;
                    a.ccH().g(Tn);
                }
                Tm = Tm(eVar.aca());
                if (!bi.cX(Tm)) {
                    this.qCY.post(new 3(this, Tm, mVar, eVar.cco()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void s(String str, int i, int i2) {
        x.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        s Tn = a.ccH().Tn(str);
        if (Tn != null) {
            Tn.field_maxRetryTimes = i;
            Tn.field_retryTimes = i2;
            a.ccH().g(Tn);
        }
    }

    public final void t(String str, long j) {
        s Tn = a.ccH().Tn(str);
        if (Tn != null) {
            Tn.field_contentLength = j;
            a.ccH().g(Tn);
        }
    }

    public final void a(String str, k kVar) {
    }

    private List<d> Tm(String str) {
        List<d> list;
        int hashCode = str.hashCode();
        synchronized (this.qDa) {
            list = (List) this.qCZ.get(hashCode);
        }
        return list;
    }
}
