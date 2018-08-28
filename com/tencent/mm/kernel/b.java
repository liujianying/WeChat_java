package com.tencent.mm.kernel;

import com.tencent.mm.ab.o;
import com.tencent.mm.ab.v;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.model.aj;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public static String dpN = "wechatnetwork";
    private static aj dpS = null;
    public final a dpO;
    public final o dpP;
    private HashSet<n> dpQ = new HashSet();
    public n dpR = new com.tencent.mm.network.n.a() {
        public final void ev(int i) {
            try {
                HashSet hashSet = new HashSet();
                synchronized (b.this.dpQ) {
                    hashSet.addAll(b.this.dpQ);
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).ev(i);
                }
            } catch (final Throwable e) {
                x.printErrStackTrace("MMKernel.CoreNetwork", e, "onNetworkChange caught crash", new Object[0]);
                new ag().post(new Runnable() {
                    public final void run() {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    };

    static class a extends com.tencent.mm.by.a<d> implements d {
        a() {
        }

        public final void b(final e eVar) {
            a(new com.tencent.mm.by.a.a<d>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((d) obj).b(eVar);
                }
            });
        }
    }

    public b(com.tencent.mm.ab.o.a aVar, a aVar2) {
        this.dpP = o.a(aVar);
        this.dpP.dJt = g.Em();
        v.dKi = new com.tencent.mm.ab.v.b() {
            public final o DG() {
                return b.this.dpP;
            }
        };
        this.dpO = aVar2;
    }

    public final void a(n nVar) {
        synchronized (this.dpQ) {
            this.dpQ.add(nVar);
        }
    }

    public final void b(n nVar) {
        synchronized (this.dpQ) {
            this.dpQ.remove(nVar);
        }
    }

    public static aj DD() {
        return dpS;
    }

    public static void a(aj ajVar) {
        dpS = ajVar;
    }

    public final byte[] DE() {
        try {
            if (this.dpP == null || this.dpP.dJs == null || this.dpP.dJs.Lr() == null) {
                return null;
            }
            return this.dpP.dJs.Lr().DE();
        } catch (Throwable e) {
            x.w("MMKernel.CoreNetwork", "get session key error, %s", e.getMessage());
            x.e("MMKernel.CoreNetwork", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final o DF() {
        return this.dpP;
    }

    public static void b(int i, int i2, boolean z, String str) {
        com.tencent.mm.sdk.b.b kdVar = new kd();
        kdVar.bUv.status = i;
        kdVar.bUv.bUw = i2;
        kdVar.bUv.bUx = z;
        kdVar.bUv.bUy = str;
        com.tencent.mm.sdk.b.a.sFg.m(kdVar);
    }
}
