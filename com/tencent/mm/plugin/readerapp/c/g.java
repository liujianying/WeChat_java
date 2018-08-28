package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.ab.d.c;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.p;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.r.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.b;
import java.util.HashMap;
import java.util.List;

public class g implements ar {
    private static HashMap<Integer, d> cVM;
    private bj mns;
    private c mnt = new c();
    private a mnu = new a();
    private d mnv = new d();
    private f mnw = new f();

    private static g bpS() {
        return (g) p.v(g.class);
    }

    public static bj bpT() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (bpS().mns == null) {
            bpS().mns = new bj(com.tencent.mm.kernel.g.Ei().dqq);
        }
        return bpS().mns;
    }

    public final void onAccountRelease() {
        c.b(Integer.valueOf(12399999), this.mnt);
        a.sFg.c(this.mnu);
        a.sFg.c(this.mnv);
        a.sFg.c(this.mnw);
        i.a(e.mnr);
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
        if ((524288 & i) != 0) {
            a(null);
        }
        if ((262144 & i) != 0) {
            b(null);
        }
    }

    public static void a(a aVar) {
        bpT().hh(20);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yp("newsapp");
        a(20, aVar);
    }

    public static void b(a aVar) {
        bpT().hh(11);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yp("blogapp");
        a(11, aVar);
    }

    public static void en(long j) {
        h(bpT().aV(j), 20);
    }

    public static void x(long j, int i) {
        h(bpT().c(j, i), i);
    }

    private static void h(List<bi> list, int i) {
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    if (i3 == 0) {
                        com.tencent.mm.sdk.platformtools.bi.deleteFile(q.v(((bi) list.get(i3)).Iz(), i, "@T"));
                    } else {
                        com.tencent.mm.sdk.platformtools.bi.deleteFile(q.v(((bi) list.get(i3)).Iz(), i, "@S"));
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static void c(a aVar) {
        ah.A(new 2(aVar));
    }

    private static void a(final int i, final a aVar) {
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.kernel.g.Em().H(new Runnable() {
                public final void run() {
                    int i = 0;
                    b bVar = new b(com.tencent.mm.plugin.p.c.Gb());
                    if (bVar.exists() && bVar.isDirectory()) {
                        b[] cBY = bVar.cBY();
                        if (cBY == null || cBY.length <= 0) {
                            g.c(aVar);
                            return;
                        }
                        String format = String.format("reader_%d_", new Object[]{Integer.valueOf(i)});
                        String format2 = String.format("ReaderApp_%d", new Object[]{Integer.valueOf(i)});
                        while (i < cBY.length) {
                            if (cBY[i].getName().startsWith(format)) {
                                cBY[i].delete();
                            }
                            if (cBY[i].getName().startsWith(format2)) {
                                cBY[i].delete();
                            }
                            i++;
                        }
                        g.c(aVar);
                        return;
                    }
                    g.c(aVar);
                }

                public final String toString() {
                    return super.toString() + "|deleteAllPic";
                }
            });
        } else {
            c(aVar);
        }
    }

    public final void bn(boolean z) {
        c.a(Integer.valueOf(12399999), this.mnt);
        com.tencent.mm.kernel.g.Em().H(new 4(this));
        a.sFg.b(this.mnu);
        a.sFg.b(this.mnv);
        a.sFg.b(this.mnw);
        i.b(e.mnr);
    }

    public final void bo(boolean z) {
    }
}
