package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class n$a<Req extends l> extends d<Req> implements e {
    private static final ThreadLocal<j> qDn = new 1();
    private final int qBI;
    private final AtomicInteger qDo = new AtomicInteger(this.qBI);
    public volatile c qDp;

    public n$a(Req req) {
        super(req);
        this.qBI = req.qBI;
    }

    public m a(j jVar) {
        if (!ace()) {
            return j.a(this);
        }
        s Tn = a.ccH().Tn(cco());
        if (Tn != null) {
            Tn.field_status = 1;
            a.ccH().g(Tn);
        }
        return j.a(this);
    }

    public boolean ace() {
        return true;
    }

    public final void run() {
        m a = a((j) qDn.get());
        if (a != null) {
            this.qDp.a(this, a);
            return;
        }
        x.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[]{aca()});
    }

    public boolean acb() {
        return false;
    }

    public boolean acc() {
        return true;
    }

    public boolean acd() {
        return false;
    }

    public boolean acf() {
        return true;
    }

    public String getURL() {
        return ((l) ach()).url;
    }

    public final String ccB() {
        return "GET";
    }

    public final Collection<b> ccC() {
        Map requestHeaders = ((l) ach()).getRequestHeaders();
        if (requestHeaders == null || requestHeaders.size() == 0) {
            return null;
        }
        Set<String> keySet = requestHeaders.keySet();
        if (keySet == null || keySet.size() == 0) {
            return null;
        }
        Collection<b> linkedList = new LinkedList();
        for (String str : keySet) {
            String str2 = (String) requestHeaders.get(str);
            if (!bi.oW(str2)) {
                linkedList.add(new b(str, str2));
            }
        }
        return linkedList;
    }

    public final int getConnectTimeout() {
        return ((l) ach()).getConnectTimeout();
    }

    public final int getReadTimeout() {
        return ((l) ach()).getReadTimeout();
    }

    public final int ccD() {
        return ((l) ach()).ccD();
    }

    public final String ccE() {
        return "application/x-www-form-urlencoded;charset=utf-8";
    }

    public final String cco() {
        return ((l) ach()).qBy;
    }

    public final String getFilePath() {
        return ((l) ach()).getFilePath();
    }

    public boolean acg() {
        boolean z = this.qDo.decrementAndGet() > 0;
        this.qDp.s(cco(), this.qBI, this.qDo.get());
        return z;
    }

    public boolean bM(long j) {
        this.qDp.t(cco(), j);
        x.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[]{cco(), Long.valueOf(ax.ciJ())});
        if (ax.ciJ() >= j) {
            return true;
        }
        return false;
    }
}
