package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import b.c.b.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c implements b {
    private static final String TAG = TAG;
    public static final b mju = new b((byte) 0);
    final Context context;
    private final ag handler = new ag();
    private final LinkedList<String> mjp = new LinkedList();
    public final HashMap<String, String> mjq = new HashMap();
    public final i mjr = new i(this);
    public final g mjs = new g(this);
    final c mjt;

    public c(c cVar, Context context) {
        e.i(cVar, "delegate");
        e.i(context, "context");
        this.mjt = cVar;
        this.context = context;
    }

    public static final /* synthetic */ void bW(String str, int i) {
        fq fqVar = new fq();
        fqVar.bOf.bOh = 0;
        fqVar.bOf.talker = str;
        fqVar.bOf.state = i;
        a.sFg.m((com.tencent.mm.sdk.b.b) fqVar);
    }

    public final long Kh(String str) {
        e.i(str, "username");
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(this, (d) new f(this, str, currentTimeMillis));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(48));
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        aVar.onStart();
        aVar.mjw = linkedList;
        aVar.gtX = str;
        if (str != null) {
            aVar.mjv.add(str);
        }
        g.DF().d((l) new m(2, aVar.mjv, linkedList, "", ""));
        return currentTimeMillis;
    }

    public final e Ki(String str) {
        e eVar;
        e.i(str, "username");
        com.tencent.mm.kernel.c.a l = g.l(i.class);
        e.h(l, "service(IMessengerStorage::class.java)");
        ab Yg = ((i) l).FR().Yg(str);
        if (Yg == null || Yg.BJ() == 0) {
            if (this.mjp.contains(str)) {
                eVar = e.mjA;
            } else {
                eVar = e.mjz;
            }
        } else if (Yg.Bx()) {
            eVar = e.mjB;
        } else if (this.mjq.containsKey(str)) {
            eVar = e.mjC;
        } else if (this.mjp.contains(str)) {
            eVar = e.mjA;
        } else {
            eVar = e.mjz;
        }
        x.d(TAG, "query username(%s) status %s", new Object[]{str, eVar});
        return eVar;
    }

    private final void J(ab abVar) {
        if (this.mjp.contains(abVar.getUsername())) {
            this.mjp.remove(abVar.getUsername());
        }
        if (this.mjp.contains(abVar.wR())) {
            this.mjp.remove(abVar.wR());
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        e.i(mVar, "stg");
        x.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            x.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        com.tencent.mm.kernel.c.a l = g.l(i.class);
        e.h(l, "service(IMessengerStorage::class.java)");
        ab Yg = ((i) l).FR().Yg(str);
        if (Yg != null && Yg.Bx()) {
            x.d(TAG, "ContactStg onNotifyChange %s", new Object[]{str});
            K(Yg);
        }
    }

    private final void K(ab abVar) {
        J(abVar);
        this.mjq.remove(abVar.getUsername());
        this.mjq.remove(abVar.wR());
        this.handler.post((Runnable) new j(this, abVar));
    }
}
