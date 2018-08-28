package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;

public class j implements ar {
    private static HashMap<Integer, d> hsC;
    private a hsE;
    private c hss = new c<k>() {
        {
            this.sFo = k.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((k) bVar).bGu.bGv && !g.Eg().Dx()) {
                x.i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
            }
            return false;
        }
    };
    public boolean mDt = false;
    public HashMap<String, List<d>> mFb;
    public HashMap<String, String> mFc;

    static {
        HashMap hashMap = new HashMap();
        hsC = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return com.tencent.mm.plugin.report.a.b.diD;
            }
        });
    }

    public final void onAccountRelease() {
        if (brV() != null) {
            j brV = brV();
            if (brV.hsE != null) {
                brV.hsE.iQ(brV.hashCode());
                brV.hsE = null;
            }
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.hss);
        if (this.mFb != null) {
            this.mFb.clear();
        }
        if (this.mFc != null) {
            this.mFc.clear();
        }
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.hsE = u.a(hashCode(), g.Ei().cachePath + "CommonOneMicroMsg.db", hsC, false);
        x.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bi.cjd());
        com.tencent.mm.sdk.b.a.sFg.b(this.hss);
        this.mFb = new HashMap();
        this.mFc = new HashMap();
        g.Ek();
        g.Em().H(new Runnable() {
            public final void run() {
                if (g.Eg().Dx()) {
                    bi.g(g.Ei().cachePath + "logcat/", "temp_", 10800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void bo(boolean z) {
    }

    public static j brV() {
        return (j) p.v(j.class);
    }
}
