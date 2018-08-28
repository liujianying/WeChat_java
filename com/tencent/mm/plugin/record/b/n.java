package com.tencent.mm.plugin.record.b;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class n implements ar {
    private static HashMap<Integer, d> cVM;
    private k msq = null;
    private d msr = null;
    private l mss = new l();
    private c mst = new c<mf>() {
        {
            this.sFo = mf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mf mfVar = (mf) bVar;
            String str = mfVar.bWR.bVv;
            long j = mfVar.bWR.bIZ;
            com.tencent.mm.protocal.b.a.c Ks = h.Ks(str);
            str = "";
            Iterator it = Ks.dzs.iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    str = str2 + h.c((vx) it.next(), j) + ":";
                } else {
                    mfVar.bWS.bWT = str2;
                    return true;
                }
            }
        }
    };

    private static n bqu() {
        au.HN();
        n nVar = (n) bs.iK("plugin.record");
        if (nVar != null) {
            return nVar;
        }
        nVar = new n();
        au.HN().a("plugin.record", nVar);
        return nVar;
    }

    public static e bqv() {
        return ((a) g.n(a.class)).getRecordMsgInfoStorage();
    }

    public static com.tencent.mm.plugin.record.a.d getRecordMsgCDNStorage() {
        return ((a) g.n(a.class)).getRecordMsgCDNStorage();
    }

    public static k bqw() {
        g.Eg().Ds();
        if (bqu().msq == null) {
            bqu().msq = new k();
        }
        return bqu().msq;
    }

    public static d bqx() {
        g.Eg().Ds();
        if (bqu().msr == null) {
            bqu().msr = new d();
        }
        return bqu().msr;
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return e.diD;
            }
        });
        cVM.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new 3());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.d("MicroMsg.SubCoreRecordMsg", "on account post reset");
        com.tencent.mm.sdk.b.a.sFg.b(this.mss);
        com.tencent.mm.sdk.b.a.sFg.b(this.mst);
        au.HU();
        File file = new File(com.tencent.mm.model.c.Gm());
        if (!file.exists() || !file.isDirectory()) {
            x.d("MicroMsg.SubCoreRecordMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreRecordMsg", "on account post release");
        com.tencent.mm.sdk.b.a.sFg.c(this.mss);
        com.tencent.mm.sdk.b.a.sFg.c(this.mst);
        com.tencent.mm.plugin.record.a.c cVar = bqu().msq;
        if (cVar != null) {
            cVar.finish();
            au.DF().b(632, cVar);
            getRecordMsgCDNStorage().b(cVar);
        }
        c cVar2 = bqu().msr;
        if (cVar2 != null) {
            cVar2.finish();
        }
    }
}
