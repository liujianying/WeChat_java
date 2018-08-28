package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static volatile com.tencent.mm.by.c<f> qxT;
    private final f qxU;

    public c() {
        if (qxT != null) {
            this.qxU = (f) qxT.get();
        } else {
            this.qxU = null;
        }
    }

    public final void bD(Object obj) {
        if (this.qxU != null) {
            this.qxU.bD(obj);
        }
    }

    public final boolean a(pm pmVar, boolean z) {
        if (g.Eg().Dx()) {
            long VF = bi.VF();
            byte[] a = ab.a(pmVar.rtN);
            x.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[]{Long.valueOf(VF), Integer.valueOf(pmVar.rtM), Integer.valueOf(bi.bD(a)), Long.valueOf(Thread.currentThread().getId())});
            if (bi.bC(a)) {
                x.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
                return false;
            }
            try {
                if (this.qxU != null) {
                    this.qxU.a(pmVar, a, z);
                }
                x.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[]{Long.valueOf(VF), Integer.valueOf(pmVar.rtM), Long.valueOf(bi.bH(VF))});
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", e, "", new Object[0]);
                return false;
            }
        }
        x.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
        return false;
    }

    public final void bE(Object obj) {
        if (this.qxU != null) {
            this.qxU.bE(obj);
        }
    }

    public final void bF(Object obj) {
        if (this.qxU != null) {
            this.qxU.bF(obj);
        }
    }
}
